package mk.ukim.finki.proekti.service.impl;

import mk.ukim.finki.proekti.models.DTO.TeacherDto;
import mk.ukim.finki.proekti.models.Teacher;
import mk.ukim.finki.proekti.models.enumerations.TypeTeacher;
import mk.ukim.finki.proekti.models.exceptions.TeacherNotFoundException;
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
        Teacher teacher=this.findById(id).orElseThrow(TeacherNotFoundException::new);
        this.teacherRepository.delete(teacher);
    }

    @Override
    public Optional<Teacher> addTeacher(TeacherDto teacherDto) {
        Teacher teacher=new Teacher(teacherDto.getName(), teacherDto.getSurname(), teacherDto.getEmail(), teacherDto.getTypeTeacher());
        return  Optional.of(this.teacherRepository.save(teacher));
    }

    @Override
    public Optional<Teacher> editTeacher(Long id, TeacherDto teacherDto) {
        Teacher teacher=this.findById(id).orElseThrow(TeacherNotFoundException::new);
        teacher.setName(teacherDto.getName());
        teacher.setSurname(teacherDto.getSurname());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setTypeTeacher(teacherDto.getTypeTeacher());
        return Optional.of(this.teacherRepository.save(teacher));
    }

    @Override
    public List<Teacher> findByName(String name) {
        return teacherRepository.findAllByName(name);
    }

    @Override
    public List<Teacher> findBySurname(String surname) {
        return teacherRepository.findAllBySurname(surname);
    }

}
