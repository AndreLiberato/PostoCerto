package com.ufrn.pds.postocerto.controller;

import org.springframework.web.servlet.ModelAndView;
import com.ufrn.pds.postocerto.model.Posto;

import org.springframework.ui.Model;

public interface IOfertaCombustivelCrudController<T, ID> {

    String index(Posto posto, Model model);

    String create(Posto posto, Model model);

    String store(Posto posto, Long combustivelId,double preco);

    ModelAndView show(ID id);

    String edit(Model model, ID id);

    String update(T entity, ID id);

    String delete(ID id);
}
