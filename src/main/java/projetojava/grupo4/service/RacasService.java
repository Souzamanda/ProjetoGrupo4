package projetojava.grupo4.service;

import org.springframework.stereotype.Service;
import projetojava.grupo4.api.CachorrosAPI;
import projetojava.grupo4.dto.RacaDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RacasService {
    private CachorrosAPI cachorrosAPI;

    public List<List<String>> listarRacas() {


        return cachorrosAPI.listarRacas().stream().map(RacaDTO::getMessage).collect(Collectors.toList());
    }
}
