package peaksoft.service;

import peaksoft.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher>getAllTeacher();

    void saveTeacher(Teacher teacher,Long coursId);

    Teacher getTeacherById(long id);

    void deleteTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher,long id);

}
