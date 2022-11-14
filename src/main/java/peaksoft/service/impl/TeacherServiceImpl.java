package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.TeacherDao;
import peaksoft.entity.Teacher;
import peaksoft.service.TeacherService;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherdao;

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherdao) {
        this.teacherdao = teacherdao;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherdao.getAllTeachers();
    }

    @Override
    public void saveTeacher(Teacher teacher, Long id) {
        teacherdao.saveTeacher(teacher,id);

    }

    @Override
    public Teacher getTeacherById(long id) {
        return teacherdao.getTeacherById(id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherdao.deleteTeacher(teacher);

    }

    @Override
    public void updateTeacher(Teacher teacher, long id) {
        teacherdao.updateTeacher(teacher,id);

    }
}
