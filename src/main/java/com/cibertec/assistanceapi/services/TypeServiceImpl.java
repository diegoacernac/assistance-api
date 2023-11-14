package com.cibertec.assistanceapi.services;


import com.cibertec.assistanceapi.entities.Type;
import com.cibertec.assistanceapi.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepository Repository;

    @Override
    public List<Type> listaTipo() {
        return Repository.findAll();

    }
}