package com.ccbft.行为型.迭代器模式;

import java.util.List;

/**
 * @author Administrator
 * @date 2022/9/18 17:38
 */
public class CourseIteratorImpl implements CourseIterator {
    private List<Course> courses;
    private int postition;

    public CourseIteratorImpl(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean hasCourse() {
        return postition < courses.size();
    }

    @Override
    public Course nextCourse() {
        return courses.get(postition++);
    }
}
