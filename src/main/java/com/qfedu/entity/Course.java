package com.qfedu.entity;

public class Course {

    private Integer id;
    private String courseTitle;
    private String courseDesc1;
    private Integer subjectId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc1() {
        return courseDesc1;
    }

    public void setCourseDesc1(String courseDesc1) {
        this.courseDesc1 = courseDesc1;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseDesc1='" + courseDesc1 + '\'' +
                ", subjectId=" + subjectId +
                '}';
    }
}
