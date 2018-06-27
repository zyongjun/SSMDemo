package com.joe.ssm.controller;

import com.joe.ssm.model.DeveloperModel;
import com.joe.ssm.model.ResultModel;
import com.joe.ssm.service.DevelopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/developer")
public class DeveloperController {
    @Autowired
    private DevelopService developService;


    DeveloperController(DevelopService developService) {
        this.developService = developService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "hello";
    }

    @RequestMapping(value = "/api/all",method = RequestMethod.GET)
    @ResponseBody
    public ResultModel getAllDevelopers() {
        ResultModel resultModel = new ResultModel();
        List<DeveloperModel> developerModels = developService.getAllDevelopers();
        if (developerModels != null && developerModels.size() > 0) {
            resultModel.setSuccess();
            resultModel.setData(developerModels);
        }else{
            resultModel.setFail();
        }
        return resultModel;
    }

    @RequestMapping(value = "/api/get",method = RequestMethod.GET)
    @ResponseBody
    public ResultModel getDeveloper(String id) {
        System.out.println("--------"+id);
        ResultModel resultModel = new ResultModel();
        DeveloperModel developerModel = developService.getDeveloper(id);
        if (developerModel != null) {
            resultModel.setSuccess();
            resultModel.setData(developerModel);
        }else{
            resultModel.setFail();
        }
        return resultModel;
    }

    @RequestMapping(value = "/api/add",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel addDeveloper(DeveloperModel developer){
        ResultModel resultModel = new ResultModel();
        if(developService.addDeveloper(developer)){
            resultModel.setSuccess();
            resultModel.setData(developer);
        }else{
            resultModel.setFail();
        }
        return resultModel;
    }

    @RequestMapping(value = "/api/update",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel updateDeveloper(DeveloperModel developerModel){
        ResultModel resultModel = new ResultModel();
        if(developService.updateDeveloper(developerModel)){
            resultModel.setSuccess();
            resultModel.setData(true);
        }else{
            resultModel.setFail();
        }
        return resultModel;
    }

    @RequestMapping(value = "/api/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultModel deleteDeveloper(@PathVariable("id")String id){
        ResultModel resultModel = new ResultModel();
        if (developService.deleteDeveloper(id)) {
            resultModel.setSuccess();
            resultModel.setData(true);
        }else{
            resultModel.setFail();
        }
        return resultModel;
    }
}
