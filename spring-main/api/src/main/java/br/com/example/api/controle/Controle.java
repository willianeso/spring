package br.com.example.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.api.modelo.Pessoa;
import br.com.example.api.repositorio.Repositorio;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    
    @GetMapping("")
    public String mensagem() {
        return "Olá, pessoa!";
    }
    
    @GetMapping("/willie")
    public String willie() {
        return "Olá, é importante você saber que Willie é linda!";
    }
    
    @GetMapping("/willie/{nome}")
    public String willie(@PathVariable String nome) {
        return "E que Willie é apaixonada por ➡ " + nome;
    }
    
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        return p;
    }
    
    @PostMapping("/apiCadastrar")
    public Pessoa cadastrar(@RequestBody Pessoa obj) {
    
        return acao.save(obj);
    }
    
    @GetMapping("/apiSelecionar")
    public List<Pessoa> selecionar() {
        return acao.findAll();
    }
    
    @GetMapping("/apiSelecionarCodigo/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo) {
        return acao.findyByCodigo(codigo);
    }

    @PutMapping("/apiEditar")
    public Pessoa editar(@RequestBody Pessoa obj) {
        
        return acao.save(obj);
    }
    
    @DeleteMapping("/apiRemover/{codigo}")
    public void remover(@PathVariable int codigo) {
        Pessoa obj = selecionarPeloCodigo(codigo);
        acao.delete(obj);
    }
    
}
