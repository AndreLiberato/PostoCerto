package com.ufrn.pds.postocerto.controller;

import com.ufrn.pds.postocerto.model.Usuario;
import com.ufrn.pds.postocerto.service.IUsuarioService;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController implements ICrudController<Usuario, Long> {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("usuarios", usuarioService.getAll());
        return "usuario/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "/usuario/create";
    }

    @PostMapping("/store")
    public String store(Usuario entity) {
        usuarioService.save(entity);
        return "redirect:/usuario/index";
    }

    @GetMapping("/{id}/show")
    public String show(Model model, @PathVariable("id") Long id) {
        model.addAttribute("usuario", usuarioService.find(id).get());
        return "usuario/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("usuario", usuarioService.find(id).get());
        return "usuario/edit";
    }

    @PutMapping("{id}/update")
    public String update(Usuario entity, @PathVariable("id") Long id) {
        usuarioService.update(entity, id);
        return "redirect:/usuario/index";
    }

    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        usuarioService.delete(id);
        return "redirect:/usuario/index";
    }
}
