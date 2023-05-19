package com.ufrn.pds.postocerto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.service.implementation.MapaService;

@RestController
@RequestMapping("/mapa")
public class MapaController {

	@Autowired
	private MapaService mapaService;

	@GetMapping("/postos")
	public List<Posto> mostrarPostosMaisProximos() {
		return mapaService.mostrarPostosMaisProximos();
	}

}
