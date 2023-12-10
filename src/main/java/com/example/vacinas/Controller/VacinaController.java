package com.example.vacinas.Controller;

import com.example.vacinas.model.Animal;
import com.example.vacinas.model.Vacina;
import com.example.vacinas.service.VacinaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vacinas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VacinaController {
    private final VacinaService vacinaService;

    @GetMapping("/{id}")
    public ResponseEntity<Vacina> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(vacinaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Vacina> insert(@RequestBody Vacina entity) {
        Vacina newCar = vacinaService.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id")
                .buildAndExpand(newCar.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @GetMapping
    public ResponseEntity<List<Vacina>> findAllPaged(){
        return ResponseEntity.ok().body(vacinaService.findAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Vacina> update(@PathVariable Long id, @RequestBody @Valid Vacina entity){
        return ResponseEntity.ok().body(vacinaService.update(id,entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        vacinaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
