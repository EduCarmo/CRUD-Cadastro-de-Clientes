package br.clientes.casdastro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cadastro")
@SequenceGenerator(name = "seq_cadastro", sequenceName = "seq_cadastro", allocationSize = 1, initialValue = 1)
public class Cadastro implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cadastro")
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String pessoaContato;

}
