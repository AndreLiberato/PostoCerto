package com.ufrn.pds.postocerto.controller;

import org.springframework.stereotype.Controller;
import com.ufrn.pds.postocerto.service.PrecoService;

@Controller
public class PrecoController {
    
    private final PrecoService service = new PrecoService();
}
