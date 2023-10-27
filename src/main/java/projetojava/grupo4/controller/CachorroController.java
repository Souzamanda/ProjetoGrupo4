package projetojava.grupo4.controller;

import lombok.AllArgsConstructor;
import projetojava.grupo4.model.Cachorro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetojava.grupo4.service.CachorroService;

import java.util.Optional;

@RestController
@RequestMapping("/cachorro")
@AllArgsConstructor
public class CachorroController {

    private final CachorroService cachorroService;

    @GetMapping("/{id}")
    public ResponseEntity<Cachorro> buscarPorId(@PathVariable long id){
        Optional<Cachorro> cachorro = cachorroService.buscarPorId(id);
        return cachorro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Cachorro> cadastrar(@RequestBody Cachorro cachorro){
        Cachorro response = cachorroService.cadastrar(cachorro);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<Cachorro> alterar(@RequestBody Cachorro cachorro){
        Cachorro response = cachorroService.alterar(cachorro);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

}