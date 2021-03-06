package ru.gb.springProject.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.gb.springProject.dto.Student;
import ru.gb.springProject.repository.StudentRepository;

@Service
public class StudentService {
  private StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getAll() {
    return studentRepository.getAll();
  }

  public void save(Student student) {
    studentRepository.save(student);
  }

  public Student findById(int id) {
    return studentRepository.findById(id);
  }

  public void deleteById(int id) {
    studentRepository.deleteById(id);
  }
}
