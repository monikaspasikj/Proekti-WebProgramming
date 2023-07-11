package mk.ukim.finki.proekti.service.impl;

import mk.ukim.finki.proekti.models.Teacher;
import mk.ukim.finki.proekti.models.enumerations.TypeTeacher;
import mk.ukim.finki.proekti.repository.TeacherRepository;
import mk.ukim.finki.proekti.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        Optional<Teacher> teacher = findById(id);
        teacher.ifPresent(teacherRepository::delete);
    }

    @Override
    public void addTeacher(String name, String surname, String email, TypeTeacher typeTeacher) {
        Teacher teacher = new Teacher(name, surname, email, typeTeacher);
        teacherRepository.save(teacher);
    }
}
