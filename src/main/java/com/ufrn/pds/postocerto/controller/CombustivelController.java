package com.ufrn.pds.postocerto.controller;

import org.springframework.stereotype.Controller;
import com.ufrn.pds.postocerto.service.CombustivelService;

@Controller
public class CombustivelController {
    
    private final CombustivelService service = new CombustivelService();
}
