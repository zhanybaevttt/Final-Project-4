package peaksoft.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.GroupDao;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.service.GroupService;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService {
    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @Override
    public void saveGroup(Group group,Long coursesId) {
        groupDao.saveGroup(group,coursesId);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupDao.getGroupById(id);
    }

    @Override
    public void deleteGroup(Group group) {
        groupDao.deleteGroup(group);
    }

    @Override
    public void updateGroup(Group group,Long id) {
        groupDao.updateGroup(group,id);
    }

    @Override
    public List<Course> getCoursesByGroup(Long groupId) {
        return groupDao.getCoursesByGroup(groupId);
    }
}

