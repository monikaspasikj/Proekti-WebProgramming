package mk.ukim.finki.proekti.controller;

import mk.ukim.finki.proekti.models.DTO.InstitutionDto;
import mk.ukim.finki.proekti.models.Institution;
import mk.ukim.finki.proekti.service.InstitutionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects/institutions")
public class InstitutionController {
    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/all")
    public List<Institution> findAllInstitutions() {
        return institutionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institution> findInstitutionById(@PathVariable Long id) {
        return this.institutionService.findById(id)
                .map(institution -> ResponseEntity.ok().body(institution))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Institution> addInstitution(@RequestBody InstitutionDto institutionDto) {
        return this.institutionService.addInstitution(institutionDto)
                .map(institution -> ResponseEntity.ok().body(institution))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Institution> editInstitution(@PathVariable Long id, @RequestBody InstitutionDto institutionDto) {
        return this.institutionService.editInstitution(id, institutionDto)
                .map(institution -> ResponseEntity.ok().body(institution))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Institution> deleteInstitution(@PathVariable Long id) {
        this.institutionService.delete(id);
        if (this.institutionService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
