package com.qfedu.dao;

import com.qfedu.entity.Course;
import com.qfedu.vo.VvedioCourse;

import java.util.List;

public interface CourseDao {

    public List<Course> findAll();

    public List<VvedioCourse> findAll2();

    public void addCourse(Course course);
    public Course findByCourssId(Integer id);
    public void updateCourse(Course course);
    public void deleteByCourseId(Integer id);

}
