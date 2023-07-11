package mk.ukim.finki.proekti.controller;

import jakarta.persistence.Enumerated;
import mk.ukim.finki.proekti.models.Teacher;
import mk.ukim.finki.proekti.models.enumerations.TypeTeacher;
import mk.ukim.finki.proekti.service.TeacherService;
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
    public Optional<Teacher> findTeacherById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.delete(id);
    }

    @PostMapping("/add")
    public void addTeacher(@RequestParam String name, @RequestParam String surname, @RequestParam String email,
                           @RequestParam TypeTeacher typeTeacher) {
        teacherService.addTeacher(name, surname, email, typeTeacher);
    }
}
