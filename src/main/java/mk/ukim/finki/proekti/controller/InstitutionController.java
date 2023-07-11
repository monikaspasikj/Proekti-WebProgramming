package mk.ukim.finki.proekti.controller;

import mk.ukim.finki.proekti.models.Institution;
import mk.ukim.finki.proekti.service.InstitutionService;
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
    public Optional<Institution> findInstitutionById(@PathVariable Long id) {
        return institutionService.findById(id);
    }

    @PostMapping("/add")
    public List<Institution> addInstitution(@RequestParam String name, @RequestParam String location) {
        institutionService.addInstitution(name, location);
        return institutionService.findAll();
    }

    @PostMapping("/edit/{id}")
    public List<Institution> editInstitution(@PathVariable Long id, @RequestParam String name, @RequestParam String location) {
        deleteInstitution(id);
        return addInstitution(name, location);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInstitution(@PathVariable Long id) {
        Optional<Institution> institution = institutionService.findById(id);
        if (institution.isPresent())
            institutionService.delete(id);
    }
}
