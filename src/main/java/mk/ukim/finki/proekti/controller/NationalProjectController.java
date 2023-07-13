package mk.ukim.finki.proekti.controller;

import mk.ukim.finki.proekti.models.DTO.NationalProjectDto;
import mk.ukim.finki.proekti.models.NationalProject;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import mk.ukim.finki.proekti.service.NationalProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/national")
public class NationalProjectController {


    private final NationalProjectService nationalProjectService;

    public NationalProjectController(NationalProjectService nationalProjectService) {
        this.nationalProjectService = nationalProjectService;
    }


    @GetMapping("/all")
    public List<NationalProject> findAllNationalProjects() {
        return this.nationalProjectService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<NationalProject> findNationalProjectById(@PathVariable Long id) {
        return this.nationalProjectService.findById(id)
                .map(project -> ResponseEntity.ok().body(project))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/filter")
    public List<NationalProject> findAllByCallorStatus(@RequestParam(required = false) Long povik, @RequestParam(required = false) TypeStatus typeStatus) {
        return this.nationalProjectService.findByCallOrStatus(povik, typeStatus);
    }

    @PostMapping("/filterByKeyword")
    public List<NationalProject> findAllByKeyword(@RequestParam String keyword) {
        return this.nationalProjectService.findByKeyWord(keyword);
    }

    @PostMapping("/search")
    public List<NationalProject> findAllByName(@RequestParam String name) {
        return this.nationalProjectService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<NationalProject> deleteNationalProject(@PathVariable Long id) {
        this.nationalProjectService.delete(id);
        if (this.nationalProjectService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/add")
    public ResponseEntity<NationalProject> addNationalProject(@RequestBody NationalProjectDto nationalProjectDto) {
        return this.nationalProjectService.addNationalProject(nationalProjectDto)
                .map(project -> ResponseEntity.ok().body(project))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<NationalProject> edit(@PathVariable Long id, @RequestBody NationalProjectDto nationalProjectDto) {
        return this.nationalProjectService.editNationalProject(id, nationalProjectDto)
                .map(project -> ResponseEntity.ok().body(project))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}