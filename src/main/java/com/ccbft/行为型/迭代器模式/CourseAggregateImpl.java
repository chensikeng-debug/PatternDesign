package com.ccbft.行为型.迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2022/9/18 17:24
 */
public class CourseAggregateImpl implements CourseAggregate {

    // 初始化数据集合
    private List<Course> courses = new ArrayList<>();

    @Override
    public void add(Course course) {
        courses.add(course);
    }

    @Override
    public void remove(Course course) {
        courses.remove(course);
    }

    @Override
    public CourseIterator getCourseIterator() {
        return new CourseIteratorImpl(courses);
    }
}
