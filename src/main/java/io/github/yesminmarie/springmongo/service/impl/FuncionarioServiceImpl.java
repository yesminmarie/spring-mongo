package io.github.yesminmarie.springmongo.service.impl;

import io.github.yesminmarie.springmongo.model.Funcionario;
import io.github.yesminmarie.springmongo.repository.FuncionarioRepository;
import io.github.yesminmarie.springmongo.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> obterTodos() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return funcionarioRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não existe"));
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {

        Funcionario chefe = funcionarioRepository
                .findById(funcionario.getChefe().getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Chefe inexistente."));

        funcionario.setChefe(chefe);

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate) {
        return funcionarioRepository.obterFuncionariosPorRangeDeIdade(de, ate);
    }

    @Override
    public List<Funcionario> obterFuncionariosPorNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }
}
