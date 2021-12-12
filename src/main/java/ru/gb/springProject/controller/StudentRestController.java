package ru.gb.springProject.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.springProject.dto.Student;
import ru.gb.springProject.service.StudentService;

@RestController
@RequestMapping("/rest")
public class StudentRestController {

  private StudentService studentService;

  public StudentRestController(StudentService studentService) {
    this.studentService = studentService;
  }

  // MVC
  // http://localhost:8080/app/rest/all GET
  @GetMapping("/all")
  public List<Student> getAllStudents(Model model) {
    return studentService.getAll();
  }

  // http://localhost:8080/app/rest/info/3 GET
  @GetMapping("/info/{id}")
  public Student getStudentInfo(@PathVariable Integer id, Model model) {
    return studentService.findById(id);
  }

  // http://localhost:8080/app/rest/add POST
  @PostMapping("/add")
  public Student saveStudent(@RequestBody Student student) {
    studentService.save(student);
    return student;
  }

}
