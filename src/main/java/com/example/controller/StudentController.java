package com.example.controller;


import com.example.entity.Organization;
import com.example.entity.Student;
import com.example.service.OrganizationService;
import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public String listStudent(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "create_student";

    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable  Long id,
                                @ModelAttribute("student") Student student,
                                Model model){
        //get from db by id
        Student existingstudent=studentService.getStudentById(id);
        //existingstudent.setId(id);
        existingstudent.setName(student.getName());
        existingstudent.setSurname(student.getSurname());
        existingstudent.setEmail(student.getEmail());
        existingstudent.setCoarses(student.getCoarses());
        studentService.updateStudent(existingstudent);
        return "redirect:/students";

    }
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }


}
