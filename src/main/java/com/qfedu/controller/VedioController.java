package com.qfedu.controller;


import com.qfedu.common.JsonResult;
import com.qfedu.entity.Vedio;
import com.qfedu.service.VedioService;
import com.qfedu.vo.Vvedio;
import com.qfedu.vo.Vvedio2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/vedio")
public class VedioController {

    @Autowired
    private VedioService vedioService;

    @RequestMapping("/list.do")
//    public Map<String, Object> listVedio(String speakerName, String courseTitle, Integer page, Integer limit) {
    public Map<String, Object> listVedio(String speakerName, String courseTitle,String title, Integer page, Integer limit) {

//        Map<String, Object> map = vedioService.findAllVedioManage(speakerName, courseTitle, page, limit);
        Map<String, Object> map = vedioService.findAllVedioManage(speakerName, courseTitle,title, page, limit);

        return map;
    }


    @RequestMapping("/add.do")
    public JsonResult addVedio(Vedio vedio) {

        JsonResult result = new JsonResult();

        try {
            vedioService.addvedio(vedio);
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
    public JsonResult deleteById(Integer id) {

        JsonResult result = new JsonResult();
        try {
            vedioService.deleteById(id);
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
    public JsonResult findById(HttpServletRequest request) {

        String id = request.getParameter("id");

        JsonResult result = new JsonResult();

        try {
            List<Vvedio2> list = vedioService.findById(Integer.parseInt(id));
            result.setCode(1);
            result.setInfo(list);
        } catch (Exception e){
            result.setCode(0);
            result.setInfo(e.getMessage());
            e.printStackTrace();
        }

        return result;

    }


    @RequestMapping("/update.do")
    public JsonResult updateVedio(Vedio vedio, HttpServletRequest request) {

        String id = request.getParameter("id");

        JsonResult result = new JsonResult();

        try {
            vedio.setId(Integer.parseInt(id));
            vedioService.updateVedio(vedio);
            result.setCode(1);
            result.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());

        }
        return result;
    }

    @RequestMapping("/deleteAll.do")
    public JsonResult deleteManyVideo(String ids) {

//        System.err.println(ids);

        String[] idArr = ids.split(",");
        int[] id = new int[idArr.length];
        for (int i = 0; i <idArr.length;i++ ){
            id[i] = Integer.parseInt(idArr[i]);
        }
        vedioService.deleteManyVideo(id);

        return new JsonResult(1, null);

    }



}
