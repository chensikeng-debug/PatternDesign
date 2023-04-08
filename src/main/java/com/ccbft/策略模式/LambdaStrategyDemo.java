package com.ccbft.策略模式;

import com.ccbft.策略模式.model.Person;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * lambda策略模式
 * 以后遇到if else都尝试用lambda策略模式套入试一下，必须卷起来
 *
 * @author Administrator
 * @date 2022/9/15 15:32
 */

public class LambdaStrategyDemo {

    private static String MALE = "male";
    private static String FEMALE = "female";
    private static ConcurrentHashMap<String, Consumer<String>> FUN_MAP = new ConcurrentHashMap<>();

    static {
        // idea:直接把不同条件入参对应的策略包裹在容器中，无需写一堆if else垃圾代码，要用的时候直接get匹配
        FUN_MAP.put(MALE, person -> {
            maleFunction(person);

        });
        FUN_MAP.put(FEMALE, person -> {
            femaleFunc(person);
        });
    }

    private static void femaleFunc(String person) {
        System.out.println(person + "应该去女厕所");
    }

    private static void maleFunction(String person) {
        System.out.println(person + "应该去男厕所");
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setGender(MALE);
        p.setName("张三");

        // 无需写一堆if else垃圾代码，冗余，直接从容器中取出条件对应的策略
        Consumer<String> consumer = FUN_MAP.get("nvren");
        consumer.accept(p.getName());
    }
}
//输出：
//张三应该去男厕所
//张三他老婆应该去女厕所
