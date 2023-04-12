package com.ufrn.pds.postocerto.controller;

import com.ufrn.pds.postocerto.service.UsuarioService;
import org.springframework.stereotype.Controller;

@Controller
public class UsuarioController {

    private final UsuarioService service = new UsuarioService();
}
