package com.emmily.api_produtos.service;

import com.emmily.api_produtos.exceptions.RecursoNaoEncontradoException;
import com.emmily.api_produtos.model.Produto;
import com.emmily.api_produtos.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado"));
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        if(!produtoRepository.existsById(id)){
            throw  new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado");
        }

        produtoRepository.deleteById(id);
    }
}
