package com.ufrn.pds.postocerto.controller;

import org.springframework.stereotype.Controller;
import com.ufrn.pds.postocerto.service.PostoService;

@Controller
public class PostoController {
  
    private final PostoService service = new PostoService();
}
