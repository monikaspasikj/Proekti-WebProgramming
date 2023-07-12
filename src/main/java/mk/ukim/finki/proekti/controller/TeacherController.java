package mk.ukim.finki.proekti.controller;

import jakarta.persistence.Enumerated;
import mk.ukim.finki.proekti.models.Teacher;
import mk.ukim.finki.proekti.models.enumerations.TypeTeacher;
import mk.ukim.finki.proekti.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public List<Teacher> findAllTeachers() {
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable Long id) {
        return this.teacherService.findById(id)
                .map(teacher -> ResponseEntity.ok().body(teacher))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable Long id) {
        this.teacherService.delete(id);
        if (this.teacherService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher(@RequestParam String name, @RequestParam String surname, @RequestParam String email,
                                              @RequestParam TypeTeacher typeTeacher) {
        return this.teacherService.addTeacher(name, surname, email, typeTeacher)
                .map(teacher -> ResponseEntity.ok().body(teacher))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Teacher> edit(@PathVariable Long id, @RequestParam String name, @RequestParam String surname, @RequestParam String email,
                                        @RequestParam TypeTeacher typeTeacher) {
        return this.teacherService.editTeacher(id, name, surname, email, typeTeacher)
                .map(teacher -> ResponseEntity.ok().body(teacher))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
