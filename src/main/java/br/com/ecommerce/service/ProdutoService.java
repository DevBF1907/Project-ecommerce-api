package br.com.ecommerce.service;

import br.com.ecommerce.dto.ProdutoDTO;
import br.com.ecommerce.entity.Categoria;
import br.com.ecommerce.entity.Produto;
import br.com.ecommerce.repository.CategoriaRepository;
import br.com.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listartodos(){
        return produtoRepository.findAll();
    }

    public Produto buscarporId(long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto atualizar(Long id, Produto produtoAtualizado){
        Produto produtoExistente = buscarporId(id);

        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setPreco(produtoAtualizado.getPreco());
        produtoExistente.setDescricao(produtoAtualizado.getDescricao());

        if (produtoAtualizado.getCategoria() != null) {
            Categoria categoria = categoriaRepository.findById(produtoAtualizado.getCategoria().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            produtoExistente.setCategoria(categoria);
        }

        return produtoRepository.save(produtoExistente);
    }

    public void deletar (Long id){
        Produto produto = buscarporId(id);
        produtoRepository.delete(produto);
    }

    public List<ProdutoDTO> listarProdutos() {
        return produtoRepository.findAll()
                .stream()
                .map(produto -> new ProdutoDTO(
                        produto.getId(),
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getCategoria() != null ? produto.getCategoria().getNome() : null
                ))
                .collect(Collectors.toList());
    }
}
