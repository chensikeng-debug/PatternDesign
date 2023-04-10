package com.ccbft.关系型.迭代器模式;

/**
 * 迭代器模式
 * <p>
 * 提供了一种方法，顺序访问集合对象中的每一个元素，而又不暴露该对象的内部标识
 * 适用场景：访问一个集合对象的内容而无需暴露它的内部表示，为遍历不同的集合结构提供一个统一的接口
 * 优点:分离了集合对象的遍历行为
 *
 * 在集合之上又封装了一层 CourseAggregateImpl中包含集合的增删改查
 * </p>
 *
 * @author Administrator
 * @date 2022/9/18 17:14
 */
public class MainTest {
    public static void main(String[] args) {
        CourseAggregateImpl courseAggregate = new CourseAggregateImpl();
        courseAggregate.add(new Course("1-Course"));
        courseAggregate.add(new Course("2-Course"));
        courseAggregate.add(new Course("3-Course"));
        courseAggregate.add(new Course("4-Course"));
        CourseIterator courseIterator = courseAggregate.getCourseIterator();
        while (courseIterator.hasCourse()) {
            Course course = courseIterator.nextCourse();
            System.out.println(course);
        }
    }
}
