package mk.ukim.finki.proekti.controller;

import mk.ukim.finki.proekti.models.DTO.TeacherDto;
import mk.ukim.finki.proekti.models.Teacher;
import mk.ukim.finki.proekti.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Teacher> addTeacher(@RequestBody TeacherDto teacherDto) {
        return this.teacherService.addTeacher(teacherDto)
                .map(teacher -> ResponseEntity.ok().body(teacher))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Teacher> edit(@PathVariable Long id, @RequestBody TeacherDto teacherDto) {
        return this.teacherService.editTeacher(id, teacherDto)
                .map(teacher -> ResponseEntity.ok().body(teacher))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/byName")
    public List<Teacher> findTeachersByName(@RequestParam String name) {
        return teacherService.findByName(name);
    }

    @PostMapping("/bySurname")
    public List<Teacher> findTeachersBySurname(@RequestParam String surname) {
        return teacherService.findBySurname(surname);
    }
}
