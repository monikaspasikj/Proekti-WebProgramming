package mk.ukim.finki.proekti.service;

import mk.ukim.finki.proekti.models.DTO.TeacherDto;
import mk.ukim.finki.proekti.models.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> findAll();

    Optional<Teacher> findById(Long id);

    void delete(Long id);

    Optional<Teacher> addTeacher(TeacherDto teacherDto);

    Optional<Teacher> editTeacher(Long id, TeacherDto teacherDto);

    List<Teacher> findByName(String name);

    List<Teacher> findBySurname(String surname);
}
