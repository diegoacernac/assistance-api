package com.cibertec.assistanceapi.servlets;

import com.cibertec.assistanceapi.entities.Tipo;
import com.cibertec.assistanceapi.services.TipoService;
import com.cibertec.assistanceapi.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class TipoController {
	
	@Autowired
	private TipoService tipoService;
	
	
	@GetMapping("/listaTipo")
	@ResponseBody
	public List<Tipo> listaArea() {
		return tipoService.listaTipo();
	}
}
