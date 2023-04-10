package com.ccbft.关系型.迭代器模式;

import lombok.Data;

/**
 * @author Administrator
 * @date 2022/9/18 17:15
 */
@Data
public class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

}

