package ru.gb.springProject.repository;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.gb.springProject.dto.Student;

@Component
public class StudentRepository {

  private List<Student> studentList;

  @PostConstruct
  public void init() {
    studentList = new ArrayList<>();
    studentList.add(new Student(1, "Иван", 90));
    studentList.add(new Student(2, "Михаил", 100));
    studentList.add(new Student(3, "Андрей", 85));
  }

  public List<Student> getAll() {
    return List.copyOf(studentList);
  }

  public void save(Student student) {
    studentList.add(student);
  }

  public Student findById(int id) {
    return studentList.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
  }

  public void deleteById(int id) {
    studentList.stream().filter(student -> student.getId() == id).findFirst().ifPresent(studentList::remove);
  }
}
