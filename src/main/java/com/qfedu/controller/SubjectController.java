package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Subject;
import com.qfedu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/query.do")
    public JsonResult findAllSubject(){
        JsonResult jsonResult = new JsonResult();
        try {
            List<Subject> list = subjectService.findAllSubject();
            jsonResult.setCode(1);
            jsonResult.setInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(0);
            jsonResult.setInfo(e.getMessage());
        }
        return jsonResult;
    }

}
