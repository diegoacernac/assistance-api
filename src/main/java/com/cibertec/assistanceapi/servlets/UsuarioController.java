package com.cibertec.assistanceapi.servlets;

import com.cibertec.assistanceapi.entities.Empleado;
import com.cibertec.assistanceapi.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/asistencia/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {

        this.usuarioService = usuarioService;

    }

    @GetMapping("/listarUsuarios")
    public ResponseEntity<?> getAll() {

        try {

            return ResponseEntity.status(HttpStatus.OK)
                    .body(usuarioService.getAllUsers());

        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"ERROR\":\"Eror. Por favor intente mas tarde.\"}");

        }

    }

    @GetMapping("/listarUsuarioPorID/{id}")
    public ResponseEntity<?> getUserByID(Long id) {

        try {

            return ResponseEntity.status(HttpStatus.OK)
                    .body(usuarioService.getAllUserByID(id));

        } catch(Exception ex) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"ERROR\":\"Eror. Por favor intente mas tarde.\"}");

        }

    }


    @PostMapping("/agregarUsuario")
    public ResponseEntity<?> save(@RequestBody Empleado entidad) {

        try {

            return ResponseEntity.status(HttpStatus.OK)
                    .body(usuarioService.saveUser(entidad));

        } catch(Exception ex) {

            return ResponseEntity.status((HttpStatus.NOT_FOUND))
                    .body("{\"ERROR\":\"Eror. Por favor intente mas tarde.\"}");

        }

    }

    @PutMapping("/actualizarUsuario")
    public ResponseEntity<?> update(@RequestBody @RequestParam Empleado id) {

        try {

            return ResponseEntity.status(HttpStatus.OK)
                    .body(usuarioService.updateUser(id));

        } catch( Exception ex) {

            return ResponseEntity.status((HttpStatus.NOT_FOUND))
                    .body("{\"ERROR\":\"Eror. Por favor intente mas tarde.\"}");

        }

    }

    @RequestMapping("/eliminarUsuarioPorID")
    public String delete(@RequestParam Long id, RedirectAttributes redirect) {

       usuarioService.deleteUser(id);

       redirect.addFlashAttribute("Mensaje", "Usuario Eliminado");

       return "redirect:/api/asistencia/usuario/listarUsuarios";

    }



    /*@GetMapping("/consulta")
    public ResponseEntity<?> listarDocentePornombreAndCategoria(
            @RequestParam String nombre,
            @RequestParam Categoria categoria,
            @RequestParam String correo,
            @RequestParam String dni) {

        try {

            return ResponseEntity.status(HttpStatus.OK)
                    .body(docenteService.findDocenteByCampos(
                            nombre,categoria,
                            correo, dni));

        } catch(Exception ex) {

            return ResponseEntity.status((HttpStatus.NOT_FOUND))
                    .body("{\"ERROR\":\"Eror. Por favor intente mas tarde.\"}");

        }

    }*/

}
