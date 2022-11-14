package peaksoft.controller;

import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CompanyService companyService;
    private final CourseService coursesService;

    @Autowired
    public CourseController(CompanyService companyService, CourseService coursesService) {
        this.companyService = companyService;
        this.coursesService = coursesService;
    }
    @ModelAttribute("companyList")
    public List<Company>getAllCompany(){
        return companyService.getAllCompanies();
    }


    @GetMapping()
    public String getAllCourses( Model model){
        model.addAttribute("courses",coursesService.getAllCourse());
        return "course/courses";

    }

    @GetMapping("/addCourse")
    public String addCourse(Model model){
        model.addAttribute("course",new Course());
        return "course/addCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course){
        coursesService.addCourse(course,course.getCompanyId());
        return "redirect:/courses";
    }

    @GetMapping("/updateCourse/{id}")
    public String updateCourse(@PathVariable("id") Long id, Model model){
        Course course =  coursesService.getCourseById(id);
        model.addAttribute("course", course);
        return "course/updateCourse";
    }

    @PostMapping("/saveUpdate/{id}")
    public String saveUpdateCourse(@PathVariable Long id, @ModelAttribute("course") Course course){
        System.out.println("Update Course");
        coursesService.updateCourse(course, id);
        return "redirect:/courses";
    }

    @DeleteMapping("/deleteCourse")
    public String deleteCourse( @RequestParam("companyId") Long id){
        coursesService.deleteCourse(coursesService.getCourseById(id));
        return "redirect:/courses";
    }
}

