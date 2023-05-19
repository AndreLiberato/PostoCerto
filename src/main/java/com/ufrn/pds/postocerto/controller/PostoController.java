package com.ufrn.pds.postocerto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.model.PostoCombustivel;
import com.ufrn.pds.postocerto.service.ICombustivelService;
import com.ufrn.pds.postocerto.service.IPostoCombustivelService;
import com.ufrn.pds.postocerto.service.IPostoService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/posto")
public class PostoController implements ICrudController<Posto, Long> {

    @Autowired()
    private IPostoService postoService;
    @Autowired()
    private IPostoCombustivelService postoCombustivelService;
    @Autowired()
    private ICombustivelService combustivelService; 


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
    public ModelAndView show(@PathVariable("id") Long id) {

        //public ModelAndView show(Model model, @PathVariable("id") Long id) {
            // model.addAttribute("posto", postoService.find(id).get());
        // model.addAttribute("combustiveis",postoCombustivelService.getPostoCombustiveisByPostoId(id) );
        
        // return "posto/show";
        
        ModelAndView mv = new ModelAndView("posto/show");
        mv.addObject("postocombustivel",  new PostoCombustivel());
        mv.addObject("posto", postoService.find(id).get());

        List<PostoCombustivel> combustiveisdoposto = postoCombustivelService.getPostoCombustiveisByPostoId(id);
        mv.addObject("combustiveis",combustiveisdoposto);

        List<Combustivel> combustivelNaoAssociado = combustivelService.getAll();
        for (PostoCombustivel postoCombustivel : combustiveisdoposto) {
            combustivelNaoAssociado.remove(postoCombustivel.getCombustivel());
            
        }
        mv.addObject("listacombustivel",combustivelNaoAssociado );
        
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

    @PostMapping("{id}/adicionarcombustivel")
    public String adicionarCombustivel(@ModelAttribute PostoCombustivel postocombustivel, @PathVariable("id") Long id)
    {
        Posto posto = postoService.find(id).get();
        postocombustivel.setPosto(posto);
        postoCombustivelService.save(postocombustivel);
        //ModelAndView mv = new ModelAndView("posto/show");
        // mv.addObject("posto", posto);
        // mv.addObject("combustiveis",postoCombustivelService.getPostoCombustiveisByPostoId(id) );
        // mv.addObject("listacombustivel",combustivelService.getAll() );

        return "redirect:/posto/{id}/show";
    }
}
