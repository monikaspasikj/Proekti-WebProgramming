package mk.ukim.finki.proekti.controller;


import mk.ukim.finki.proekti.models.DTO.PovikDto;
import mk.ukim.finki.proekti.models.Povik;
import mk.ukim.finki.proekti.service.PovikService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/povik")
public class PovikController {
    private final PovikService povikService;

    public PovikController(PovikService povikService) {
        this.povikService = povikService;
    }

    @GetMapping("/all")
    public List<Povik> findAllPovici() {
        return this.povikService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Povik> findPovikById(@PathVariable Long id) {
        return this.povikService.findById(id)
                .map(povik -> ResponseEntity.ok().body(povik))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePovik(@PathVariable Long id) {
        this.povikService.delete(id);
        if (this.povikService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Povik> addPovik(@RequestBody PovikDto povikDto) {
        return this.povikService.addPovik(povikDto)
                .map(povik -> ResponseEntity.ok().body(povik))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Povik> edit(@PathVariable Long id, @RequestBody PovikDto povikDto) {
        return this.povikService.editPovik(id, povikDto)
                .map(povik -> ResponseEntity.ok().body(povik))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
