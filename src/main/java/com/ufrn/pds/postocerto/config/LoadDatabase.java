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
      log.info("Preloading " + repository.save(new Posto("Bilbo Baggins")));
      log.info("Preloading " + repository.save(new Posto("Frodo Baggins")));
    };
  }
}
