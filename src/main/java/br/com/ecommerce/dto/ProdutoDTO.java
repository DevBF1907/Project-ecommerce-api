package br.com.ecommerce.dto;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private double preco;
    private String categoriaNome;

    public ProdutoDTO(Long id, String nome, double preco,String categoriaNome) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoriaNome = categoriaNome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }
}
