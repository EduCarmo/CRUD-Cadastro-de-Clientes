package br.clientes.casdastro.repository;

import br.clientes.casdastro.model.Cadastro;
import com.sun.jdi.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    @Query(value = "select c from Cadastro c where upper(trim(c.nome)) like %?1%")
    List<Cadastro> buscarPorNome(String nome);


}
