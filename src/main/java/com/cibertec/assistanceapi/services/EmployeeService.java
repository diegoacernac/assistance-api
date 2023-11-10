package com.cibertec.assistanceapi.services;

import com.cibertec.assistanceapi.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> listEmployees();
    Employee insertEmployee(Employee obj);
    List<Employee> listEmployeesByNameDNIEstadoArea(String name,String dni,int state,int id_area);
    List<Employee> listEmployeesByNameLike(String name);
    List<Employee> listEmployeesByDni(String dni);
}