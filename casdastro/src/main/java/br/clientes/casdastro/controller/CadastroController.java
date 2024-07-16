package br.clientes.casdastro.controller;

import br.clientes.casdastro.model.Cadastro;
import br.clientes.casdastro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CadastroController {

    @Autowired
    private CadastroRepository cadastroRepository;


    /*Listar todos os cadastros do banco*/
    @GetMapping(value = "listaCastros")
    @ResponseBody
    public ResponseEntity<List<Cadastro>> listaCastros(){
        List<Cadastro> cadastros = cadastroRepository.findAll();
        return new ResponseEntity<List<Cadastro>>(cadastros, HttpStatus.OK);
    }

    /*Salvar dados no banco*/
    @PostMapping (value = "salvarCadastro")
    @ResponseBody
    public ResponseEntity<Cadastro> salvarCadastro(@RequestBody Cadastro cadastro){
        Cadastro cad =  cadastroRepository.save(cadastro);
        return new ResponseEntity<Cadastro>(cad, HttpStatus.CREATED);
    }


    /*Deletar Cadastro por ID*/
    @DeleteMapping(value = "deletarCadastro")
    @ResponseBody
    public ResponseEntity<String> deletarCadastro(@RequestParam Long idCadastro){
        cadastroRepository.deleteById(idCadastro);

        return new ResponseEntity<String>("Castro deletado com sucesso", HttpStatus.OK);
    }


    /*Editar Cadastro*/
    @PutMapping(value = "editarCadastro")
    @ResponseBody
    public ResponseEntity<?> editarCadastro(@RequestBody Cadastro cadastro){
        if(cadastro.getId() == null){
            return new ResponseEntity<String>("Não foi informado o ID para a atualizaçap",HttpStatus.OK);
        }
        Cadastro cad =  cadastroRepository.saveAndFlush(cadastro);
        return new ResponseEntity<Cadastro>(cad, HttpStatus.OK);
    }

    /*Buscar cadastro por nome*/
    @GetMapping(value = "buscarCadastro")
    @ResponseBody
    public ResponseEntity<List<Cadastro>> buscarCadastro(@RequestParam (name = "name") String name){
        List<Cadastro> cadastros = cadastroRepository.buscarPorNome(name.trim().toUpperCase());
        return new ResponseEntity<List<Cadastro>>(cadastros, HttpStatus.OK);
    }

    /*Buscar cadastro po ID*/
    @GetMapping(value = "buscarCadastroId")
    @ResponseBody
    public ResponseEntity<Cadastro> buscarCadastroId(@RequestParam Long buscaCadastroID){
        Cadastro cad = cadastroRepository.findById(buscaCadastroID).get();
        return new ResponseEntity<Cadastro>(cad, HttpStatus.OK);
    }

    @RequestMapping(value = "/msg/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public String mensagem (@PathVariable String nome){
        return "Olá " + nome;
    }

}


