package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class PessoaService {

    private AtomicInteger contador = new AtomicInteger(0);

    private Map<String, Pessoa> mapPessoas = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        mapPessoas.put("Eduardo", new Pessoa(contador.incrementAndGet(),
                "eduardooal", "Eduardo Alcantara de Souza",
                "eduardoalcantara.008@gmail.com", "(11) 96661-6922", LocalDate.parse("2006-03-13")));

        mapPessoas.put("Henrique", new Pessoa(contador.incrementAndGet(),
                "Rickzzs", "Henrique Gonçalves Espíndola",
                "h.espindola2007@outook.com", "(11) 93326-8264", LocalDate.parse("2004-07-20")));

        mapPessoas.put("Flavio", new Pessoa(contador.incrementAndGet(),
                "flaviosb", "Flavio da Silva Batista",
                "flaviosiilva004@gmail.com", "(11) 99498-7350", LocalDate.parse("2004-11-15")));
    }

    public List<Pessoa> obterPessoas() {
        return new ArrayList<>(mapPessoas.values());
    }

    public Optional<Pessoa> obterPessoa(String username) {
        return Optional.ofNullable(mapPessoas.get(username));
    }
}
