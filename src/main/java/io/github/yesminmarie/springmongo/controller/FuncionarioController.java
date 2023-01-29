package io.github.yesminmarie.springmongo.controller;

import io.github.yesminmarie.springmongo.model.Funcionario;
import io.github.yesminmarie.springmongo.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> obterTodos(){
        return funcionarioService.obterTodos();
    }

    @GetMapping("{codigo}")
    public Funcionario obterCodigo(@PathVariable String codigo){
        return funcionarioService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario){
        return funcionarioService.criar(funcionario);
    }

    @GetMapping("/range")
    public List<Funcionario> obterFuncionariosPorRangeDeIdade(
            @RequestParam("de") Integer de,
            @RequestParam("ate") Integer ate) {
        return funcionarioService.obterFuncionariosPorRangeDeIdade(de, ate);
    }

    @GetMapping("/por-nome")
    public List<Funcionario> obterFuncionariosPorNome(
            @RequestParam("nome") String nome) {
        return funcionarioService.obterFuncionariosPorNome(nome);
    }
}
