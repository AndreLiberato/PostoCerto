package com.ufrn.pds.postocerto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.pds.postocerto.repository.PrecoRepository;

@Service
public class PrecoService {
  
  @Autowired
	private PrecoRepository precoRepository;
}
