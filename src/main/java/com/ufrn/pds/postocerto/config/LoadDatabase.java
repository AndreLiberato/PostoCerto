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
      UsuarioRepository usuarioRep, CombustivelRepository combustivelRep,PrecoRepository precoRep) {
	  	
    return args -> {
      log.info("Preloading " + repository.save(new Posto("Posto Senador",-5.822940123720272 , -35.23003062936271, 0.0)));
      log.info("Preloading " + repository.save(new Posto("Posto longe", -5.6401759797421676, -35.42623003161191, 0.0)));
      log.info("Preloading " + repository.save(new Posto("Posto 1", -5.8304352, -35.2258257, 0.0)));
      log.info("Preloading " + repository.save(new Posto("Ale Sat", -5.825708113031226, -35.22986756711646, 0.0)));
      log.info("Preloading " + usuarioRep.save(new Usuario("Usuario 1", -5.8304352, -35.2258257)));
//      log.info("Preloading " + combustivelRep.save(new Combustivel("Gasolina")));
//      log.info("Preloading " + precoRep.save(new Preco(20.0, now.toString())));
    };
  }
}
