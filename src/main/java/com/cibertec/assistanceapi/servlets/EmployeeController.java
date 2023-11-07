package com.cibertec.assistanceapi.servlets;

import com.cibertec.assistanceapi.entities.Employee;
import com.cibertec.assistanceapi.services.EmployeeService;
import com.cibertec.assistanceapi.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/url/employee")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EmployeeController {

	@Autowired 
	private EmployeeService employeeService;
	/*
	@Autowired
	UsuarioService usuarioService;*/


	@GetMapping("/listaEmployee")
	@ResponseBody
	public ResponseEntity<List<Employee>> listaEmployee(){
		List<Employee> lista = employeeService.listEmployees();
		return ResponseEntity.ok(lista);
	} 
	
	@GetMapping("/listaEmployee/WithParameters")
	@ResponseBody    
	public ResponseEntity<Map<String,Object>> listEmployeesByNameDNIEstadoArea(
			@RequestParam(name = "name", required = false, defaultValue = "") String name,
			@RequestParam(name = "dni", required = false, defaultValue = "") String dni,
			@RequestParam(name = "state", required = true, defaultValue = "1") int state,
			@RequestParam(name = "id_area", required = false, defaultValue = "-1") int id_area) {
		Map<String, Object> response = new HashMap<>();
		try {
			List<Employee> employees = employeeService.listEmployeesByNameDNIEstadoArea("%" + name + "%", dni, state, id_area);
			if (CollectionUtils.isEmpty(employees)) {
				response.put("mensaje", "No existen datos para mostrar");
					}else {
				response.put("lista", employees);
				response.put("mensaje", "Existen" +employees.size()+ "elementos para mostrar");
					}
				}catch(Exception e) {
					e.printStackTrace();
			response.put("mensaje", "Error en los datos, consulte con el administrador");
				}
				return ResponseEntity.ok(response);
			}

	@GetMapping("/listEmployeesByNameLike/{name}")
	@ResponseBody
	public ResponseEntity<List<Employee>> listEmployeesByNameLike(@PathVariable("name") String name) {
		List<Employee> employees = new ArrayList<>();
		try {
			if (name.equalsIgnoreCase("todos")) {
				employees = employeeService.listEmployeesByNameLike("");
			} else {
				employees = employeeService.listEmployeesByNameLike("%" + name + "%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(employees);
	}

	@PostMapping("/registerEmployee")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertEmployee(@RequestBody Employee obj) {
		Map<String, Object> response = new HashMap<>();
		try {
			List<Employee> existingEmployees = employeeService.listEmployeesByDni(obj.getDni());
			if (CollectionUtils.isEmpty(existingEmployees)) {
				obj.setRegistrationDate(new Date());
				Employee insertedEmployee = employeeService.insertEmployee(obj);

				if (insertedEmployee != null) {
					// Registro de usuario con contraseña generada
					String nombres = obj.getName();
					String apellidos = obj.getLastName();
					String dni = obj.getDni();
					String login = obj.getDni();
					String correo = obj.getEmail();
					Date fechaRegistro = obj.getRegistrationDate();
					Date fechaNacimiento = obj.getBirthdate();

					// Generación de contraseña
					String password = nombres.concat("2023");
					BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
					String encodedPassword = encoder.encode(password);

					//usuarioService.insertUserWithRole(nombres, apellidos, dni, login, encodedPassword, correo, fechaRegistro, fechaNacimiento, "zzz");

					response.put("mensaje", "Se registró correctamente.");
				} else {
					response.put("mensaje", "No se registró, consulte con el administrador.");
				}
			} else {
				response.put("mensaje", "El DNI " + obj.getDni() + " ya existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(response);
	}

	
	@PutMapping("/updateEmployee")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> updateEmployee(@RequestBody Employee obj) {
		Map<String, Object> response = new HashMap<>();
		try {
			obj.setUpdateDate(new Date());
			Employee updatedEmployee = employeeService.insertEmployee(obj);
			if (updatedEmployee != null) {
				response.put("mensaje", "No se actualizo, consulte con el administrador");
			} else {
				response.put("mensaje", "Se actualizo correctamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.put("mensaje", "No se actualizo, consulte con el administrador");
		}
		return ResponseEntity.ok(response);
	}
}
