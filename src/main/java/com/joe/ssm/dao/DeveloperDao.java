package com.joe.ssm.dao;

import com.joe.ssm.model.DeveloperModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeveloperDao {
    List<DeveloperModel> getAllDevelopers();
    DeveloperModel getDeveloper(String developerId);

    boolean addDeveloper(@Param("name") String name,@Param("site") String site,@Param("avatar") String avatar);
    //多个参数要用@Param
    boolean updateDeveloper(@Param("id")String id,@Param("name")String name,@Param("site")String site,@Param("avatar")String avatar);
    boolean deleteDeveloper(String developerId);
}
