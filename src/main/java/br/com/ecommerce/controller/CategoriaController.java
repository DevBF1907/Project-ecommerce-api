package br.com.ecommerce.controller;

import br.com.ecommerce.dto.CategoriaDTO;
import br.com.ecommerce.entity.Categoria;
import br.com.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired // Injeta o service
    private CategoriaService categoriaService;

    // Buscar todas as categorias
    @GetMapping
    public List<Categoria> listarTodas() {
        return categoriaService.listarTodas();
    }
    @GetMapping("/dto")
    public ResponseEntity<List<CategoriaDTO>> listarDTO() {
        return ResponseEntity.ok(categoriaService.listarCategoriasDTO());
    }

    // Buscar uma categoria por id
    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    // Criar nova categoria
    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
    }

    // Atualizar categoria
    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.atualizar(id, categoria);
    }

    // Deletar categoria
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
    }


}
