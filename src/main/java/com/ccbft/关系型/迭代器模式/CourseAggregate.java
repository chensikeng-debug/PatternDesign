package com.ccbft.关系型.迭代器模式;

/**
 * @author Administrator
 * @date 2022/9/18 17:16
 */
public interface CourseAggregate {

    void add(Course course);

    void remove(Course course);

    CourseIterator getCourseIterator();
}
