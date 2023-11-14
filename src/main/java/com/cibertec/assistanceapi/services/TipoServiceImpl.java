package com.cibertec.assistanceapi.services;

import com.cibertec.assistanceapi.entities.Tipo;
import com.cibertec.assistanceapi.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServiceImpl implements TipoService{
	
	@Autowired 
	private TipoRepository Repository;
	
	@Override
	public List<Tipo> listaTipo() {
		return Repository.findAll();

	}
}
