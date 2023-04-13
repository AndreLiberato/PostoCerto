package com.ufrn.pds.postocerto.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.repository.PostoRepository;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PostoRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Posto("São Paulo", "-23.5505", "-46.6333", 0.0)));
      log.info("Preloading " + repository.save(new Posto("Londres", "51.5074", "-0.1278", 0.0)));
      log.info("Preloading " + repository.save(new Posto("Nova York", "40.7128", "-74.0060", 0.0)));


      // log.info("Preloading " + usuarioR.save(new Usuario("André")));
      // log.info("Preloading " + usuarioR.save(new Usuario("nsdaiofjhasdj")));
    };
  }
}
