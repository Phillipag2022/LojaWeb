package com.lojaweb.backend.dto;

import org.springframework.beans.BeanUtils;
import com.lojaweb.backend.domain.Cidade;
import com.lojaweb.backend.domain.Pessoa;
import lombok.Data;

@Data
public class PessoaClienteDTO{

    private String nome;
    private String cpf; 
    private String email; 
    private String endereço;
    private String cep; 
    private Cidade cidade; 

    public Pessoa convertPessoa(PessoaClienteDTO pessoaClienteDTO){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClienteDTO, pessoa);
        return pessoa;
    }
}
