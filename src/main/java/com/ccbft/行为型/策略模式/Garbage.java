package com.ccbft.行为型.策略模式;

import com.ccbft.行为型.策略模式.model.Person;

import java.util.Objects;

/**
 * 反面例子
 *
 * @author Administrator
 * @date 2022/9/15 15:23
 */
public class Garbage {

    private static String MALE = "male";
    private static String FEMALE = "female";

    public static void main(String[] args) {
        Person p = new Person();
        p.setGender(MALE);
        p.setName("张三");

        if (Objects.equals(p.getGender(), MALE)) {
            System.out.println(p.getName() + "应该去男厕所");
        }

        if (Objects.equals(p.getGender(), FEMALE)) {
            System.out.println(p.getName() + "应该去女厕所");
        }

    }
}
