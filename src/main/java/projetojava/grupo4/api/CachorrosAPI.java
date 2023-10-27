package projetojava.grupo4.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import projetojava.grupo4.dto.RacaDTO;

import java.util.List;

@FeignClient(name = "cachorro-client", url="https://dog.ceo")
public interface CachorrosAPI {
    @GetMapping("/api/breeds/list/all")
    public List<RacaDTO> listarRacas();
}