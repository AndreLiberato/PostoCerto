package com.ufrn.pds.postocerto.controller;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======

>>>>>>> 122c32df8d4523eb5f9daf7c3305b8536c6d0d9e
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======

>>>>>>> 122c32df8d4523eb5f9daf7c3305b8536c6d0d9e
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ufrn.pds.postocerto.model.Posto;
<<<<<<< HEAD
import com.ufrn.pds.postocerto.model.Usuario;
import com.ufrn.pds.postocerto.service.IPostoService;
import com.ufrn.pds.postocerto.service.IUsuarioService;

@RestController
@RequestMapping("/mapa")
public class MapaController {
	@Autowired
	private IPostoService postoService;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/all")
	public List<Posto> findAll() {
		return postoService.getAll();
	}

	@GetMapping("/user")
	public Optional<Usuario> userAll() {
		long userID = 1;
		return usuarioService.find(userID);
	}

	@GetMapping("/postos")
	public List<Posto> mostrarPostosMaisProximos() {
		long userID = 1;

		List<Posto> postos = postoService.getAll();
		List<Posto> postosProximos = new ArrayList<>();

		double raioBusca = 15.0; // km
		
		for (Posto posto : postos) {
			double latUser = usuarioService.find(userID).get().getLatitude();
			double lngUser = usuarioService.find(userID).get().getLongitude();

			double distancia = distanciaEntreCoordenadas(latUser, lngUser, posto.getLatitude(), posto.getLongitude()); // em
																														// metros

			if (distancia <= raioBusca) {
				posto.setDistancia(distancia);
				postosProximos.add(new Posto(posto.getNome(), posto.getLatitude(), posto.getLongitude(), distancia));
			}
		}
		return postosProximos;
	}

	private static double distanciaEntreCoordenadas(double lat1, double lon1, double lat2, double lon2) {

		final int R = 6371; // raio médio da Terra em km
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);

		double a = Math.pow(Math.sin(dLat / 2), 2)
				+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.pow(Math.sin(dLon / 2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double distancia = R * c;

		return distancia;
=======

import com.ufrn.pds.postocerto.service.implementation.MapaService;

@RestController
@RequestMapping("/mapa")
public class MapaController {

	@Autowired
	private MapaService mapaService;

	@GetMapping("/postos")
	public List<Posto> mostrarPostosMaisProximos() {
		return mapaService.mostrarPostosMaisProximos();
>>>>>>> 122c32df8d4523eb5f9daf7c3305b8536c6d0d9e
	}

}
