package com.cibertec.assistanceapi.services;

import com.cibertec.assistanceapi.entities.Employee;
import com.cibertec.assistanceapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository Repository;


    @Override
    public Employee insertEmployee(Employee obj) {
        return Repository.save(obj);
    }

    @Override
    public List<Employee> listEmployees() {
        return Repository.findAll();
    }

    @Override
    public List<Employee> listEmployeesByNameDNIEstadoArea(String name, String dni, int state,
                                                           int id_area) {
        return Repository.listEmployeesByNameDNIEstadoArea(name, dni, state, id_area);
    }

    @Override
    public List<Employee> listEmployeesByNameLike(String name) {
        return Repository.listByNameLike(name);
    }

    @Override
    public List<Employee> listEmployeesByDni(String dni) {
        return Repository.listEmployeesByDNI(dni);
    }

}