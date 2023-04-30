package com.ufrn.pds.postocerto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.repository.PostoRepository;
import com.ufrn.pds.postocerto.service.IPostoService;

@RestController
@RequestMapping("/mapa")
public class MapaController implements IMapaPostos<Posto, Long>  {
	@Autowired
	private IPostoService postoService;
	@GetMapping("/all")
    public List<Posto> findAll() {
        return postoService.getAll();
    }
	
//	@GetMapping
//	public List<Posto> mostrarPostosMaisProximos(double latAtual, double lngAtual) {
//        List<Posto> postos = postoService.getAll();
//        List<Posto> postosProximos = new ArrayList<>();
//        double raioBusca = 5; // km
//        double raioBuscaMetros = raioBusca * 1000; // converter para metros
//
//        for (Posto posto : postos) {
//            double latPosto = Double.parseDouble(posto.getLatitude());
//            double lngPosto = Double.parseDouble(posto.getLongitude());
//
//            double distancia = distanciaEntreCoordenadas(latAtual, lngAtual, latPosto, lngPosto); // em metros
//
//           if (distancia <= raioBuscaMetros) {
//        	   posto.setDistancia(distancia/1000);
//               postosProximos.add(new Posto(posto.getNome(), posto.getLatitude(), posto.getLongitude(), distancia));
//            }
//            
//        }
//
//        // Collections.sort(postosProximos, new Comparator<Posto>() {
//        //     public int compare(Posto p1, Posto p2) {
//        //         return Double.compare(p1.getDistancia(), p2.getDistancia());
//        //     }
//        // });
//
//        return postosProximos;
//    }
	
	

//    private static double distanciaEntreCoordenadas(double lat1, double lng1, double lat2, double lng2) {
//        final int R = 6371; // raio médio da Terra em km
//        double dLat = Math.toRadians(lat2 - lat1);
//        double dLng = Math.toRadians(lng2 - lng1);
//        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
//                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLng / 2)
//                        * Math.sin(dLng / 2);
//        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//        double distancia = R * c * 1000; // converter para metros
//        return distancia;
//    }
}
