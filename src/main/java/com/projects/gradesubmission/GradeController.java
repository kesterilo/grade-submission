package com.projects.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GradeController {
  
  List<Grade> studentGrades = new ArrayList<>();
  //   new Grade("Harry", "Potions", "C-"), new Grade("Hermione", "Arithmancy", "A+"), new Grade("Neville", "Charms", "A-")
  // );
  
  
  @GetMapping("/")
  public String getForm(Model model) {
    model.addAttribute("grade", new Grade());
    return "form";
  }
  
  @PostMapping("/handleSubmit")
  public String submitForm(Grade grade) {
    studentGrades.add(grade);
    return "redirect:/grades";
  }
  
  @GetMapping("/grades")
  public String getGrades(Model model) {
    model.addAttribute("grades", studentGrades);
    return "grades";
  }
  
}