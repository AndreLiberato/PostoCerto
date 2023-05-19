package com.ufrn.pds.postocerto.service;

import java.util.List;
import com.ufrn.pds.postocerto.model.OfertaCombustivel;

public interface IOfertaCombustivelService extends ICrudService<OfertaCombustivel, Long>{

    public List<OfertaCombustivel> getByPostoId(Long posto_id);

    public String resolveViewPath(String viewName, Long postoId,  boolean isRedirect);
  
}
