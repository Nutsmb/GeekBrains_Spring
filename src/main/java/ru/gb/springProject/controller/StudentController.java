package ru.gb.springProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.springProject.dto.Student;
import ru.gb.springProject.service.StudentService;

@Controller
public class StudentController {

  private StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  // MVC
  // http://localhost:8080/app/all GET
  @GetMapping("/all")
  public String getAllStudents(Model model) {
    model.addAttribute("studends", studentService.getAll());
    return "student_list";
  }

  // http://localhost:8080/app/info/3 GET
  @GetMapping("/info/{id}")
  public String getStudentInfo(@PathVariable Integer id, Model model) {
    model.addAttribute("student", studentService.findById(id));
    return "student_info";
  }

  // http://localhost:8080/app/add GET
  @GetMapping("/add")
  public String getStudentAddFrom() {
    return "student_form";
  }

  // http://localhost:8080/app/add POST
  @PostMapping("/add")
  public String saveStudent(Student student) {
    studentService.save(student);
    return "redirect:/all";
  }

  @PostMapping("/delete/{id}")
  public String saveStudent(@PathVariable Integer id) {
    studentService.deleteById(id);
    return "redirect:/all";
  }
}
