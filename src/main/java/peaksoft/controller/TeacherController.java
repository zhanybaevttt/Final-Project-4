package peaksoft.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Course;
import peaksoft.entity.Teacher;
import peaksoft.service.CourseService;
import peaksoft.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final CourseService courseService;

    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }


    @ModelAttribute("teacherList")
    public List<Teacher> findAllTeachers() {
        return teacherService.getAllTeacher();
    }

    @ModelAttribute("courseList")
    public List<Course> findAllCourses(){
        return courseService.getAllCourse();
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("teachers",teacherService.getAllTeacher());
        return "teacher/teachers";
    }

    @GetMapping("/addTeacher")
    public String saveTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher/addTeacher";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher,teacher.getCourseId());
        return "redirect:/teachers";
    }


    @GetMapping("/{id}/update")
    public String updateTeacher(Model model, @PathVariable("id") long id) {
        model.addAttribute("teacherUpdate", teacherService.getTeacherById(id));
        return "teacher/updateTeacher";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("teacherUpdate") Teacher teacher,
                         @PathVariable("id") long id) {
        teacherService.updateTeacher(teacher, id);
        return "redirect:/teachers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        teacherService.deleteTeacher(teacherService.getTeacherById(id));
        return "redirect:/teachers";
    }
}

