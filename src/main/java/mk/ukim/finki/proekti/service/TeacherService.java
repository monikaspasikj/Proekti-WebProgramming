package mk.ukim.finki.proekti.service;

import mk.ukim.finki.proekti.models.Teacher;
import mk.ukim.finki.proekti.models.enumerations.TypeTeacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> findAll();

    Optional<Teacher> findById(Long id);

    void delete(Long id);

    Optional<Teacher> addTeacher(String name, String surname, String email, TypeTeacher typeTeacher);

    Optional<Teacher> editTeacher(Long id, String name, String surname, String email, TypeTeacher typeTeacher);
}
