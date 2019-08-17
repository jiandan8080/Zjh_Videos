package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CourseDao;
import com.qfedu.entity.Course;
import com.qfedu.service.CourseService;
import com.qfedu.vo.VvedioCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;


    @Override
    public List<Course> findAllCourse() {
        List<Course> list = courseDao.findAll();

        if (list == null) {
            throw new RuntimeException("课程不存在");
        }

        return list;
    }

    @Override
    public Map<String, Object> findAllCourse2(Integer page, Integer limit) {
        // 设置页码和每页显示的记录数，该语句后面，紧跟着数据库查询相关的语句
        PageHelper.startPage(page, limit);
        List<VvedioCourse> list = courseDao.findAll2();

        long total = ((Page) list).getTotal();
        int pages = ((Page) list).getPages();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0); // 结合layui的表格组件，0表示成功
        map.put("msg", "");
        map.put("count", total);// 表中总记录数
        map.put("data", list); // 获取到的分页数据

        return map;
    }


    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public Course findByCourseId(Integer id) {
        Course course = courseDao.findByCourssId(id);
        return course;
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public void deleteByCourseId(Integer id) {
        courseDao.deleteByCourseId(id);
    }


}
