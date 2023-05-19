package com.ufrn.pds.postocerto.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.model.PostoCombustivel;
import com.ufrn.pds.postocerto.repository.PostoRepository;
import com.ufrn.pds.postocerto.repository.UsuarioRepository;
import com.ufrn.pds.postocerto.service.IPostoCombustivelService;

import jakarta.transaction.Transactional;
@Service
public class MapaService {
	@Autowired
    private PostoRepository postoRepository;
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Autowired()
    private IPostoCombustivelService postoCombustivelService;
	
	@Transactional
	public List<Posto> mostrarPostosMaisProximos() {
		 long userID = 1;
	
	     List<Posto> postos = postoRepository.findAll();
	     List<Posto> postosProximos = new ArrayList<>();
	     
	     double raioBusca = 15.0; // km
	     double raioBuscaMetros = raioBusca * 1000; // converter para metros

	     double latUser = usuarioRepository.findById(userID).get().getLatitude();
	     double lngUser = usuarioRepository.findById(userID).get().getLongitude();
	     
	     
	     for (Posto posto : postos) { 
	    	// posto.getCombustiveis();
	    	// List<PostoCombustivel> combustiveisdoposto = postoCombustivelService.getPostoCombustiveisByPostoId(posto.getId());
	         double distancia = distanciaEntreCoordenadas(latUser, lngUser, posto.getLatitude(), posto.getLongitude()); // em metros
	         
	         if (distancia <= raioBusca) {
	     	    posto.setDistancia(distancia);
	            postosProximos.add(new Posto(posto.getNome(), posto.getLatitude(), posto.getLongitude(), posto.getCombustiveis(), distancia));
	         } 
	     }
    // Collections.sort(postosProximos, new Comparator<Posto>() {
    //     public int compare(Posto p1, Posto p2) {
    //         return Double.compare(p1.getDistancia(), p2.getDistancia());
    //     }
    // });

	     return postosProximos;
	}
	
	

	 private static double distanciaEntreCoordenadas(double lat1, double lon1, double lat2, double lon2) {
		
		 final int R = 6371; // raio médio da Terra em km
		 double dLat = Math.toRadians(lat2 - lat1);
		 double dLon = Math.toRadians(lon2 - lon1);
		    
		 double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.pow(Math.sin(dLon / 2), 2);
		 double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		    
		 double distancia = R * c;
		    
		 return distancia;    
	 }
}
