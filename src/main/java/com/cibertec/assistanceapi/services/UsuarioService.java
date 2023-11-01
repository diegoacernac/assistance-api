package com.cibertec.assistanceapi.services;

import com.cibertec.assistanceapi.entities.Empleado;
import com.cibertec.assistanceapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRespository;

    public List<Empleado> getAllUsers() {

        return usuarioRespository.findAll();

    }

    public Optional<Empleado> getAllUserByID(Long id) {

        return usuarioRespository.findById(id);

    }

    public Empleado saveUser(Empleado user) {

        return usuarioRespository.save(user);

    }

    public Empleado updateUser(Empleado id) {

        return usuarioRespository.save(id);

    }

    public void deleteUser(Long id) {

        usuarioRespository.deleteById(id);

    }

    public  List<Empleado> getUsersByName(String name) {

        return usuarioRespository.findByNameStartingWith(name);

    }




}
