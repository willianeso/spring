package br.com.example.api.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.api.modelo.Pessoa;

@RestController
public class Controle {

    @GetMapping("")
    public String  mensagem(){
        return"Olá, pessoa!";
    }

    @GetMapping("/willie")
    public String  willie(){
        return"Olá, é importante você saber que Willie é linda!";
    }
    
    @GetMapping("/willie/{nome}")
    public String  willie(@PathVariable String nome){
        return"E que Willie é apaixonada por ➡ "+nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }

}
