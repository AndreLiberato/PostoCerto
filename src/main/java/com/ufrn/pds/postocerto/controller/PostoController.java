package com.ufrn.pds.postocerto.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.ufrn.pds.postocerto.exception.EntityNotFoundException;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.service.IPostoService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/posto")
public class PostoController implements ICrudController<Posto, Long> {

    @Autowired()
    private IPostoService postoService;

    // @Autowired()
    // private IOfertaCombustivelService ofertaCombustivelService;
    
    // @Autowired()
    // private ICombustivelService combustivelService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("postos", postoService.getAll());
        return "posto/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("posto", new Posto());
        return "posto/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Posto entity) {
        postoService.save(entity);
        return "redirect:/posto/index";
    }

    @GetMapping("/{id}/show")
    public ModelAndView show(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("posto/show");
        try {
            Optional<Posto> posto = postoService.find(id);
            mv.addObject("posto", posto.get());
        } catch (EntityNotFoundException e) {
            mv.setViewName("error");
            mv.addObject("message", "Ocorreu um erro ao exibir o posto: " + e.getMessage());
        }
        return mv;
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("posto", postoService.find(id).get());
        return "posto/edit";
    }

    @PutMapping("/{id}/update")
    public String update(@ModelAttribute Posto entity, @PathVariable("id") Long id) {
        postoService.update(entity, id);
        return "redirect:/posto/index";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        postoService.delete(id);
        return "redirect:/posto/index";
    }

}
