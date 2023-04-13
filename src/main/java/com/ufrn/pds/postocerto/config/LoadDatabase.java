package com.ufrn.pds.postocerto.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.model.Usuario;
import com.ufrn.pds.postocerto.repository.PostoRepository;
import com.ufrn.pds.postocerto.repository.UsuarioRepository;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PostoRepository repository, UsuarioRepository usuarioR) {

    return args -> {
      // log.info("Preloading " + repository.save(new Posto("Bilbo Baggins")));
      // log.info("Preloading " + repository.save(new Posto("Frodo Baggins")));

      // log.info("Preloading " + usuarioR.save(new Usuario("André")));
      // log.info("Preloading " + usuarioR.save(new Usuario("nsdaiofjhasdj")));
    };
  }
}
