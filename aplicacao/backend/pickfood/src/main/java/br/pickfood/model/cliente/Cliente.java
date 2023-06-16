package br.pickfood.model.cliente;

import java.util.List;

import br.pickfood.model.BaseEntity;
import br.pickfood.model.dto.cliente.ClienteDTO;
import br.pickfood.model.dto.user.UserDTO;
import br.pickfood.model.endereco.Endereco;
import br.pickfood.model.pedido.Pedido;
import br.pickfood.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente extends BaseEntity {

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;


    @OneToMany
    private List<Endereco> endereco;

    @OneToMany
    private List<Pedido> pedidos;


    @Override
    public ClienteDTO convertToDto() {
        return ClienteDTO.builder()
                .id(this.id)
                .userId(this.getUser().getId())
                .nome(this.nome)
                .cpf(this.cpf)
                .telefone(this.telefone)
                .build();
    }

    
}
