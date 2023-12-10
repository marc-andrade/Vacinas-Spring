package com.example.vacinas.Controller;

import com.example.vacinas.model.Animal;
import com.example.vacinas.service.AnimalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/animais")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(animalService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Animal> insert(@RequestBody Animal entity) {
        Animal newCar = animalService.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(newCar.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @GetMapping
    public ResponseEntity<List<Animal>> findAllPaged(){
        return ResponseEntity.ok().body(animalService.findAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody @Valid Animal entity){
        return ResponseEntity.ok().body(animalService.update(id,entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
