package com.joe.ssm.controller;

import com.joe.ssm.model.DeveloperModel;
import com.joe.ssm.model.ResultModel;
import com.joe.ssm.service.DevelopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public ResultModel getDeveloper(String developerId) {
        ResultModel resultModel = new ResultModel();
        DeveloperModel developerModel = developService.getDeveloper(developerId);
        if (developerModel != null) {
            resultModel.setSuccess();
            resultModel.setData(developerModel);
        }else{
            resultModel.setFail();
        }
        return resultModel;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel updateDeveloper(@RequestParam("id")String id,@RequestParam("name")String name,
                                       @RequestParam("site")String site,@RequestParam("avatar")String avatar){
        ResultModel resultModel = new ResultModel();
        if(developService.updateDeveloper(id,name,site,avatar)){
            resultModel.setSuccess();
            resultModel.setData(true);
        }else{
            resultModel.setFail();
        }
        return resultModel;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public ResultModel deleteDeveloper(@RequestParam("id")String id){
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
