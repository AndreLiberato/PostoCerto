package com.ufrn.pds.postocerto.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.model.OfertaCombustivel;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.service.ICombustivelService;
import com.ufrn.pds.postocerto.service.IOfertaCombustivelService;
import com.ufrn.pds.postocerto.service.IPostoService;

@Controller
@RequestMapping("posto/{postoId}/ofertacombustivel")
public class OfertaCombustivelController {
    
    @Autowired
    private IOfertaCombustivelService ofertaCombustivelService;

    @Autowired
    private IPostoService postoService;

    @Autowired
    private ICombustivelService combustivelService;

    private Posto posto;

    @ModelAttribute()
    public void addPostoToModel(@PathVariable("postoId") Long postoId) {
        this.posto = postoService.find(postoId).get();
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<OfertaCombustivel> ofertaCombustiveis = ofertaCombustivelService.getByPostoId(posto.getId());
        model.addAttribute("ofertaCombustiveis", ofertaCombustiveis);
        model.addAttribute("posto", this.posto);
        return "posto/ofertacombustivel/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("combustiveis", combustivelService.getAll());
        model.addAttribute("posto", this.posto);
        return "posto/ofertacombustivel/create";
    }

    @PostMapping("/store")
    public String store(@RequestParam("combustivelId") Long combustivelId, @RequestParam("preco") double preco) {
        Optional<Combustivel> combustivel = combustivelService.find(combustivelId);
        OfertaCombustivel ofertaCombustivel = new OfertaCombustivel(preco, this.posto, combustivel.get());
        ofertaCombustivelService.save(ofertaCombustivel);
        return "redirect:/posto/" + this.posto.getId() + "/ofertacombustivel/index";
    }

    @GetMapping("/{id}/show")
    public ModelAndView show(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("combustivel/show");
        Optional<OfertaCombustivel> combustivel = ofertaCombustivelService.find(id);
        mv.addObject("combustivel", combustivel.get());
        return mv;
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        Optional<OfertaCombustivel> ofertaCombustivel = ofertaCombustivelService.find(id);
        model.addAttribute("ofertaCombustivel", ofertaCombustivel.get());
        model.addAttribute("combustiveis", combustivelService.getAll());
        model.addAttribute("posto", this.posto);
        return "posto/ofertacombustivel/edit";
    }

    @PutMapping("/{id}/update")
    public String update(@RequestParam("combustivelId") Long combustivelId, @RequestParam("preco") double preco, @PathVariable("id") Long id) {
        System.out.println("Id: " + id);
        Optional<Combustivel> combustivel = combustivelService.find(combustivelId);
        OfertaCombustivel ofertaCombustivel = new OfertaCombustivel(preco, this.posto, combustivel.get());
        ofertaCombustivelService.update(ofertaCombustivel, id);
        return "redirect:/posto/" + this.posto.getId() + "/ofertacombustivel/index";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        ofertaCombustivelService.delete(id);
        return "redirect:/posto/" + this.posto.getId() + "/ofertacombustivel/index";
    }
}
