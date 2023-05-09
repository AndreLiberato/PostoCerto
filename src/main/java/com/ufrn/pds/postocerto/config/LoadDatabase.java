package com.ufrn.pds.postocerto.config;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.model.Preco;
import com.ufrn.pds.postocerto.model.Usuario;
import com.ufrn.pds.postocerto.repository.CombustivelRepository;
import com.ufrn.pds.postocerto.repository.PostoCombustivelRepository;
import com.ufrn.pds.postocerto.repository.PostoRepository;
import com.ufrn.pds.postocerto.repository.PrecoRepository;
import com.ufrn.pds.postocerto.repository.UsuarioRepository;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  LocalDateTime now = LocalDateTime.now();
  @Bean
  CommandLineRunner initDatabase(PostoRepository repository, CombustivelRepository repositoryC,
      UsuarioRepository usuarioRep, CombustivelRepository combustivelRep,PrecoRepository precoRep, PostoCombustivelRepository postCombRep) {
	  	
    return args -> {
      log.info("Preloading " + repository.save(new Posto("Posto Senador", "-35.23003062936271", "-5.822940123720272", 0.0)));
      log.info("Preloading " + repository.save(new Posto("Posto 2", "-35.226331795196984", "-5.830829375937654", 0.0)));
      log.info("Preloading " + repository.save(new Posto("Ale Sat", "-35.23233871992727", "-5.830047899539721", 0.0)));
      log.info("Preloading " + usuarioRep.save(new Usuario("Usuario 1", "40.7128", "-74.0060")));
      log.info("Preloading " + combustivelRep.save(new Combustivel("Gasolina")));
      log.info("Preloading " + precoRep.save(new Preco(20.0, now.toString())));
    };
  }
}
