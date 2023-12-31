package mk.ukim.finki.proekti.controller;

import mk.ukim.finki.proekti.models.DTO.NationalProjectDto;
import mk.ukim.finki.proekti.models.NationalProject;
import mk.ukim.finki.proekti.models.enumerations.TypeStatus;
import mk.ukim.finki.proekti.service.NationalProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

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


    @GetMapping("/pagination")
    public List<NationalProject> findAllWithPagination(Pageable pageable)
    {
        return this.nationalProjectService.findAllByPagination(pageable).getContent();
    }


    @GetMapping("/{id}")
    public ResponseEntity<NationalProject> findNationalProjectById(@PathVariable Long id) {
        return this.nationalProjectService.findById(id)
                .map(project -> ResponseEntity.ok().body(project))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/filterByCallOrStatus")
    public List<NationalProject> findAllByCallOrStatus(@RequestParam(required = false) Long callId, @RequestParam(required = false) TypeStatus typeStatus) {
        return this.nationalProjectService.findByCallOrStatus(callId, typeStatus);
    }

    @PostMapping("/filterByKeyword")
    public List<NationalProject> findAllByKeyword(@RequestParam String keyword) {
        return this.nationalProjectService.findByKeyWord(keyword);
    }

    @PostMapping("/searchByName")
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

    @GetMapping("/approved")
    public List<NationalProject> findAllApproved() {
        return nationalProjectService.findAllApproved();
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<NationalProject> approveProject(@PathVariable Long id) {
        return this.nationalProjectService.makeApproved(id).map(project -> ResponseEntity.ok().body(project))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}