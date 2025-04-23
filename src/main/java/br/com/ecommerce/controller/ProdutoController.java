package br.com.ecommerce.controller;


import br.com.ecommerce.dto.ProdutoDTO;
import br.com.ecommerce.entity.Produto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.ecommerce.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
   @Autowired
    private ProdutoService produtoService;

  @PostMapping
   public Produto salvar (  @RequestBody @Valid Produto produto){
      return produtoService.salvar(produto);
  }

    @GetMapping
    public List<Produto> ListarTodos(){
      return produtoService.listartodos();
    }


    @GetMapping("/dto")
    public ResponseEntity<List<ProdutoDTO>> listarTodos() {
        List<ProdutoDTO> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscarporId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody @Valid Produto produto) {
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }

}
