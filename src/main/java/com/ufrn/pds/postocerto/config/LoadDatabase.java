package com.ufrn.pds.postocerto.config;

import java.time.LocalDateTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ufrn.pds.postocerto.controller.PrecoController;
import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.model.Preco;
import com.ufrn.pds.postocerto.model.Usuario;
import com.ufrn.pds.postocerto.repository.CombustivelRepository;
import com.ufrn.pds.postocerto.repository.PostoRepository;
import com.ufrn.pds.postocerto.repository.PrecoRepository;
import com.ufrn.pds.postocerto.repository.UsuarioRepository;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  LocalDateTime now = LocalDateTime.now();
  @Bean
  CommandLineRunner initDatabase(PostoRepository repository, CombustivelRepository repositoryC,
      UsuarioRepository usuarioRep, CombustivelRepository combustivelRep,PrecoRepository precoRep) {
	  	
    return args -> {
      log.info("Preloading " + repository.save(new Posto("Posto 1", "-23.5505", "-46.6333", 0.0)));
      log.info("Preloading " + repository.save(new Posto("Posto 2", "51.5074", "-0.1278", 0.0)));
      log.info("Preloading " + repository.save(new Posto("Posto 3", "40.7128", "-74.0060", 0.0)));
      log.info("Preloading " + usuarioRep.save(new Usuario("Usuario 1", "40.7128", "-74.0060")));
      log.info("Preloading " + combustivelRep.save(new Combustivel("Gasolina")));
      log.info("Preloading " + precoRep.save(new Preco(20.0, now.toString())));
    };
  }
}
