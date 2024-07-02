package br.com.empresa.vendamais.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.vendamais.entity.Produto;
import br.com.empresa.vendamais.repository.ProdutoRepository;
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        return produtoRepository.findById(id).orElse(null);
    }
    public Produto insertNew(Produto produto){
        return produtoRepository.save(produto);
    }
    public Produto update(Long id, Produto produtoAlterado){
        Produto produtoAtual= findById(id);
        produtoAtual.setNome(produtoAlterado.getNome());
        produtoAtual.setQuantidade(produtoAlterado.getQuantidade());
       return produtoRepository.save(produtoAtual);
    }
    public Boolean deleteById(Long id){
        Produto produto = findById(id);
        if (produto == null){
            return false;
        }else{
            produtoRepository.deleteById(id);
            return true;
        }
    }


}
