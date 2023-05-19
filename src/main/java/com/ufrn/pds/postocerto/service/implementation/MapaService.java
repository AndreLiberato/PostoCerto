package com.ufrn.pds.postocerto.service.implementation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.pds.postocerto.model.Posto;
import jakarta.transaction.Transactional;
import com.ufrn.pds.postocerto.repository.PostoRepository;
import com.ufrn.pds.postocerto.repository.UsuarioRepository;
// import com.ufrn.pds.postocerto.model.OfertaCombustivel;
// import com.ufrn.pds.postocerto.service.IOfertaCombustivelService;

@Service
public class MapaService {
	@Autowired
	private PostoRepository postoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	// @Autowired()
	// private IOfertaCombustivelService ofertaCombustivelService;

	@Transactional
	public List<Posto> mostrarPostosMaisProximos() {
		long userID = 1;

		List<Posto> postos = postoRepository.findAll();
		List<Posto> postosProximos = new ArrayList<>();

		double raioBusca = 15.0; // km

		double latUser = usuarioRepository.findById(userID).get().getLatitude();
		double lngUser = usuarioRepository.findById(userID).get().getLongitude();

		for (Posto posto : postos) {
			double distancia = distanciaEntreCoordenadas(latUser, lngUser, posto.getLatitude(), posto.getLongitude());

			if (distancia <= raioBusca) {
				posto.setDistancia(distancia);
				postosProximos.add(posto);
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
	}
}
