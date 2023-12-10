package com.example.vacinas.Controller;

import com.example.vacinas.model.Raca;
import com.example.vacinas.service.RacaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/racas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RacaController {

    private final RacaService racaService;

    @GetMapping("/{id}")
    public ResponseEntity<Raca> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(racaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Raca> insert(@RequestBody Raca entity) {
        Raca newCar = racaService.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(newCar.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @GetMapping
    public ResponseEntity<List<Raca>> findAllPaged(){
        return ResponseEntity.ok().body(racaService.findAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Raca> update(@PathVariable Long id, @RequestBody @Valid Raca entity){
        return ResponseEntity.ok().body(racaService.update(id,entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        racaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
