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

    public DeveloperModel getDeveloper(String id) {
        return developerDao.getDeveloper(id);
    }

    public boolean updateDeveloper(String id,String name,String site,String avatar){
        return developerDao.updateDeveloper(id,name,site,avatar);
    }

    public boolean deleteDeveloper(String id) {
        return developerDao.deleteDeveloper(id);
    }
}
