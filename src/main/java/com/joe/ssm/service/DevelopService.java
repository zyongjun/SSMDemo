package com.joe.ssm.service;

import com.joe.ssm.dao.DeveloperDao;
import com.joe.ssm.model.DeveloperModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DevelopService {
    @Autowired
    DeveloperDao developerDao;

    public List<DeveloperModel> getAllDevelopers() {
        return developerDao.getAllDevelopers();
    }

    public boolean addDeveloper(DeveloperModel developer){
        return developerDao.addDeveloper(developer.getName(),developer.getSite(),developer.getAvatar());
    }

    public DeveloperModel getDeveloper(String id) {
        System.out.println("--service id---"+id);
        return developerDao.getDeveloper(id);
    }

    public boolean updateDeveloper(DeveloperModel developerModel){
        return developerDao.updateDeveloper(String.valueOf(developerModel.getId()),developerModel.getName(),developerModel.getSite(),developerModel.getAvatar());
    }

    public boolean deleteDeveloper(String id) {
        return developerDao.deleteDeveloper(id);
    }
}
