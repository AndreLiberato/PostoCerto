package com.ufrn.pds.postocerto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.service.IPostoService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/posto")
public class PostoController implements ICrudController<Posto, Long> {

    @Autowired()
    private IPostoService postoService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("postos", postoService.getAll());
        return "posto/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "/posto/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Posto entity) {
        postoService.save(entity);
        return "redirect:/posto/index";
    }

    @GetMapping("/{id}/show")
    public String show(Model model, @PathVariable("id") Long id) {
        model.addAttribute("posto", postoService.find(id).get());
        return "posto/show";
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
