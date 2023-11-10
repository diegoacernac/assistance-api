package com.cibertec.assistanceapi.services;

import com.cibertec.assistanceapi.entities.Area;
import com.cibertec.assistanceapi.repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaRepository Repository;

    @Override
    public List<Area> listaArea() {
        return Repository.findAll();

    }
}