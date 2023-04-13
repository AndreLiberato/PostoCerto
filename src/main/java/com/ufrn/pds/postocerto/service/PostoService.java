package com.ufrn.pds.postocerto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.repository.PostoRepository;

@Service
public class PostoService {

    @Autowired
    private PostoRepository postoRepository;

    PostoService(PostoRepository postoRepository) {
        this.postoRepository = postoRepository;
    }

    public List<Posto> mostrarPostosMaisProximos(double latAtual, double lngAtual) {
        List<Posto> postos = postoRepository.findAll();
        List<Posto> postosProximos = new ArrayList<>();
        double raioBusca = 15; // km
        double raioBuscaMetros = raioBusca * 1000; // converter para metros
    
        for (Posto posto : postos) {
            double latPosto = Double.parseDouble(posto.getLatitude());
            double lngPosto = Double.parseDouble(posto.getLongitude());
    
            double distancia = distanciaEntreCoordenadas(latAtual, lngAtual, latPosto, lngPosto); // em metros
    
            // if (distancia <= raioBuscaMetros) {
        
            // }
            posto.setDistancia(distancia/1000);
            postosProximos.add(new Posto(posto.getNome(), posto.getLatitude(), posto.getLongitude(), distancia));
        }
    
        // Collections.sort(postosProximos, new Comparator<Posto>() {
        //     public int compare(Posto p1, Posto p2) {
        //         return Double.compare(p1.getDistancia(), p2.getDistancia());
        //     }
        // });
    
        return postosProximos;
    }

    private static double distanciaEntreCoordenadas(double lat1, double lng1, double lat2, double lng2) {
        final int R = 6371; // raio médio da Terra em km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLng / 2)
                        * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distancia = R * c * 1000; // converter para metros
        return distancia;
    }
}
