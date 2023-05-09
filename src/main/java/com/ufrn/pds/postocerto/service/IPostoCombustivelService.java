package com.ufrn.pds.postocerto.service;

import java.util.List;


import com.ufrn.pds.postocerto.model.PostoCombustivel;

public interface IPostoCombustivelService extends ICrudService<PostoCombustivel, Long>{

   // @Query("select c from PostoCombustivel pc where pc.posto.id=?1")
    public List<PostoCombustivel> getPostoCombustiveisByPostoId(Long posto_id);
  

}
