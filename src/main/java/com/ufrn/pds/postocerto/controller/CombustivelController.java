package com.ufrn.pds.postocerto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.service.ICombustivelService;

@Controller
@RequestMapping("/combustivel")
public class CombustivelController implements ICrudController<Combustivel, Long> {

    @Autowired
    private ICombustivelService combustivelService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("combustiveis", combustivelService.getAll());
        return "combustivel/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "/combustivel/create";
    }

    @PostMapping("/store")
    public String store(Combustivel entity) {
        combustivelService.save(entity);
        return "redirect:/combustivel/index";
    }

    @GetMapping("/{id}/show")
    public ModelAndView show(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("combustivel/show");
        mv.addObject("combustivel", combustivelService.find(id).get());
        return mv;
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("combustivel", combustivelService.find(id).get());
        return "combustivel/edit";
    }

    @PutMapping("{id}/update")
    public String update(Combustivel entity, @PathVariable("id") Long id) {
        combustivelService.update(entity, id);
        return "redirect:/combustivel/index";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        combustivelService.delete(id);
        return "redirect:/combustivel/index";
    }
}
