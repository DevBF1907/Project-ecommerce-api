package br.com.ecommerce.service;

import br.com.ecommerce.dto.CategoriaDTO;
import br.com.ecommerce.entity.Categoria;
import br.com.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Salvar categoria
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Listar todas as categorias
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    // Buscar por ID
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    // Atualizar categoria
    public Categoria atualizar(Long id, Categoria categoriaAtualizada) {
        Categoria categoriaExistente = buscarPorId(id);
        categoriaExistente.setNome(categoriaAtualizada.getNome());
        return categoriaRepository.save(categoriaExistente);
    }

    // Deletar categoria
    public void deletar(Long id) {
        Categoria categoria = buscarPorId(id);
        categoriaRepository.delete(categoria);
    }

    // Listar categorias com DTO
    public List<CategoriaDTO> listarCategoriasDTO() {
        return categoriaRepository.findAll().stream()
                .map(categoria -> new CategoriaDTO(
                        categoria.getId(),
                        categoria.getNome()
                )).collect(Collectors.toList());
    }
}
