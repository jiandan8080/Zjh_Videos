package com.qfedu.service;

import com.qfedu.entity.Course;
import com.qfedu.vo.VvedioCourse;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface CourseService {
    /**
     *
     * @return
     */
    public List<Course> findAllCourse();

    /**
     *
     * @param page
     * @param limit
     * @return
     */
    public Map<String,Object> findAllCourse2(Integer page, Integer limit);

    /**
     *
     * @param course
     */
    public void addCourse(Course course);

    /**
     *
     * @param id
     * @return
     */
    public Course findByCourseId(Integer id);

    /**
     *
     * @param course
     */
    public void updateCourse(Course course);

    /**
     *
     * @param id
     */
    public void deleteByCourseId(Integer id);

}
