package com.qfedu.controller;


import com.qfedu.common.JsonResult;
import com.qfedu.entity.Course;
import com.qfedu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/query.do")
    public JsonResult findAll(){

        List<Course> list = courseService.findAllCourse();

        return new JsonResult(1,list);

    }


    @RequestMapping("/list.do")
    public Map<String,Object> findAll2(Integer page, Integer limit){
        Map<String, Object> map = courseService.findAllCourse2(page, limit);

        return map;
    }


    @RequestMapping("/add.do")
    public JsonResult addCourse(Course course){
        JsonResult result = new JsonResult();

        try {
            courseService.addCourse(course);
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
    public JsonResult deleteCourse(Integer id){
        JsonResult result = new JsonResult();

        try {
            courseService.deleteByCourseId(id);
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
    public JsonResult findByCourseId(HttpServletRequest request){
        String id = request.getParameter("id");
        JsonResult result = new JsonResult();

        try {
            Course course = courseService.findByCourseId(Integer.parseInt(id));
            result.setCode(1);
            result.setInfo(course);
        } catch (Exception e) {
            result.setCode(0);
            result.setInfo(e.getMessage());

        }
        return result;
    }

    @RequestMapping("/update.do")
    public JsonResult updateCourse(Course course,HttpServletRequest request){
        String id = request.getParameter("id");
        JsonResult result = new JsonResult();

        try {
            course.setId(Integer.parseInt(id));
            courseService.updateCourse(course);
            result.setCode(1);
            result.setInfo(course);
        } catch (Exception e) {
            result.setCode(0);
            result.setInfo(e.getMessage());

        }
        return result;

    }


}
