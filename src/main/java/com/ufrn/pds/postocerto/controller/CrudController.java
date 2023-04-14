package com.ufrn.pds.postocerto.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

public interface CrudController<T, ID> {

    String index(Model model);

    String create(Model model);

    String store(@ModelAttribute T entity);

    String show(Model model, @PathVariable ID id);

    String edit(Model model, @PathVariable ID id);

    String update(@ModelAttribute T entity, @PathVariable ID id);

    String delete(@PathVariable ID id);
}
