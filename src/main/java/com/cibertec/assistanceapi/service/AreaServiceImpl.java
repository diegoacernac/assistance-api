package com.cibertec.assistanceapi.service;

import com.cibertec.assistanceapi.entity.Area;
import com.cibertec.assistanceapi.repository.AreaRepository;
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
