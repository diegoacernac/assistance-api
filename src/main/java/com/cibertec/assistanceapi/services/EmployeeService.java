package com.cibertec.assistanceapi.services;

import com.cibertec.assistanceapi.entities.Employee;

import java.util.List;

public interface EmployeeService {

	public abstract List<Employee> listEmployees();
	public abstract Employee insertEmployee(Employee obj);
	public abstract List<Employee> listEmployeesByNameDNIEstadoArea(String name,String dni,int state,int id_area);
	public abstract List<Employee> listEmployeesByNameLike(String name);
	public abstract List<Employee> listEmployeesByDni(String dni);
}
