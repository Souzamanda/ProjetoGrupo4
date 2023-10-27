package projetojava.grupo4.service;

import projetojava.grupo4.model.Cachorro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetojava.grupo4.repository.CachorroRepository;

import java.util.Optional;
@Service
public class CachorroService {
    @Autowired
    private CachorroRepository cachorroRepository;

    public Optional<Cachorro> buscarPorId(Long id){
        return this.cachorroRepository.findById(id);
}

    public Cachorro cadastrar(Cachorro cachorro) {
        return cachorroRepository.save(cachorro);
    }

    public Cachorro alterar(Cachorro cachorro) {
        if(cachorroRepository.existsById(cachorro.getId())){
            return cachorroRepository.save(cachorro);
        }
        return null;
    }
}
