package com.ufrn.pds.postocerto.config;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.model.Usuario;
import com.ufrn.pds.postocerto.service.implementation.CombustivelService;
import com.ufrn.pds.postocerto.service.implementation.PostoService;
import com.ufrn.pds.postocerto.service.implementation.UsuarioService;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  LocalDateTime now = LocalDateTime.now();
  @Bean
  CommandLineRunner initDatabase(PostoService postoService, CombustivelService combustivelService,
      UsuarioService usuarioService) {
	  	
    return args -> {
      // Postos de Gasolina
      log.info("Preloading " + postoService.save(new Posto("Posto Senador",-5.822940123720272 , -35.23003062936271, 0.0)));
      log.info("Preloading " + postoService.save(new Posto("Posto longe", -5.6401759797421676, -35.42623003161191, 0.0)));
      log.info("Preloading " + postoService.save(new Posto("Posto 1", -5.8304352, -35.2258257, 0.0)));
      log.info("Preloading " + postoService.save(new Posto("Ale Sat", -5.825708113031226, -35.22986756711646, 0.0)));

      // Usuário 1
      log.info("Preloading " + usuarioService.save(new Usuario("Usuario 1", -5.8304352, -35.2258257)));

      // Combustiveis
      log.info("Preloading " + combustivelService.save(new Combustivel("Gasolina")));
      log.info("Preloading " + combustivelService.save(new Combustivel("Diesel")));
      log.info("Preloading " + combustivelService.save(new Combustivel("Etanol")));
      log.info("Preloading " + combustivelService.save(new Combustivel("GNV")));
    };
  }
}
