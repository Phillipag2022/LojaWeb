package com.lojaweb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lojaweb.backend.domain.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository <Produto,Long>{
    
    
}
