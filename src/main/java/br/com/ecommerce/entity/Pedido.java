package br.com.ecommerce.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataPedido;

   @ManyToOne
   @JoinColumn(name = "cliente_id")
   private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
   private List<ItemPedido> itens;

    public Pedido() {
    }

    public Pedido(Long id, LocalDateTime dataPedido, Cliente cliente, List<ItemPedido> itens) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
