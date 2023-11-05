package com.cibertec.assistanceapi.controller;

import com.cibertec.assistanceapi.entity.Area;
import com.cibertec.assistanceapi.service.AreaService;
import com.cibertec.assistanceapi.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	
	@GetMapping("/listaArea")
	@ResponseBody
	public List<Area> listaArea() {
		return areaService.listaArea();
	}
}
