package com.qfedu.controller;


import com.qfedu.common.JsonResult;
import com.qfedu.entity.Speaker;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/list2.do")

    public Map<String,Object> findSpeaker(Integer page, Integer limit){
        Map<String, Object> map = speakerService.findAllSpeaker1(page, limit);

//    public JsonResult findAllSpeaker(Integer page, Integer limit){

        //List<Speaker> list = speakerService.findAllSpeaker(page, limit);

//        JsonResult result = new JsonResult(1, li  st);


//        return result;
        return map;

    }

    @RequestMapping("query.do")
    public JsonResult findAllSpeaker(){

        List<Speaker> list = speakerService.findAllSpeaker();

        return new JsonResult(1,list);

    }

    @RequestMapping("/add.do")
    public JsonResult addSpeaker(Speaker speaker){
        JsonResult result = new JsonResult();

        try {
            speakerService.addSpeaker(speaker);
            result.setCode(1);
            result.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());
        }

        return result;

    }

    @RequestMapping("/delete.do")
    public JsonResult deleteSpeaker(Integer id){
        JsonResult result = new JsonResult();

        try {
            speakerService.deleteSpeaker(id);
            result.setCode(1);
            result.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());
        }

        return result;
    }

    @RequestMapping("/queryById.do")
    public JsonResult findById(HttpServletRequest request){

        String id = request.getParameter("id");

        JsonResult result = new JsonResult();

        try {
            Speaker speaker = speakerService.findById(Integer.parseInt(id));
            result.setCode(1);
            result.setInfo(speaker);
        } catch (NumberFormatException n) {
            result.setCode(0);
            result.setInfo(n.getMessage());

        }
        return result;
    }


    @RequestMapping("/update.do")
    public JsonResult updateVedio(Speaker speaker, HttpServletRequest request) {

        String id = request.getParameter("id");

        JsonResult result = new JsonResult();

        try {
            speaker.setId(Integer.parseInt(id));
            speakerService.updateSpeaker(speaker);
            result.setCode(1);
            result.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());

        }
        return result;
    }

}
