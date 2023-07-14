package mk.ukim.finki.proekti.controller;

import mk.ukim.finki.proekti.models.DTO.InternationalProjectDto;
import mk.ukim.finki.proekti.models.InternationalProject;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import mk.ukim.finki.proekti.service.InternationalProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/international")
public class InternationalProjectController {
    private final InternationalProjectService internationalProjectService;

    public InternationalProjectController(InternationalProjectService internationalProjectService) {
        this.internationalProjectService = internationalProjectService;
    }

    @GetMapping("/all")
    public List<InternationalProject> findAllInternationalProjects() {
        return internationalProjectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternationalProject> findInternationalProjectById(@PathVariable Long id) {
        return internationalProjectService.findById(id)
                .map(project -> ResponseEntity.ok().body(project))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/filterByType")
    public List<InternationalProject> findAllByTypeStatus(@RequestParam(required = false) TypeStatus typeStatus) {
        return internationalProjectService.findByTypeStatus(typeStatus);
    }

    @PostMapping("/filterByKeyword")
    public List<InternationalProject> findAllByKeyword(@RequestParam String keyword) {
        return internationalProjectService.findByKeyword(keyword);
    }

    @PostMapping("/search")
    public List<InternationalProject> findAllByName(@RequestParam String name) {
        return internationalProjectService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<InternationalProject> deleteInternationalProject(@PathVariable Long id) {
        internationalProjectService.delete(id);
        if (internationalProjectService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/add")
    public ResponseEntity<InternationalProject> addInternationalProject(@RequestBody InternationalProjectDto internationalProjectDto) {
        return internationalProjectService.addInternationalProject(internationalProjectDto)
                .map(project -> ResponseEntity.ok().body(project))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<InternationalProject> editInternationalProject(@PathVariable Long id, @RequestBody InternationalProjectDto internationalProjectDto) {
        return internationalProjectService.editInternationalProject(id, internationalProjectDto)
                .map(project -> ResponseEntity.ok().body(project))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
