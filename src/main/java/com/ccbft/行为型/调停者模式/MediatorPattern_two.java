package com.ccbft.行为型.调停者模式;

import java.util.ArrayList;
import java.util.List;

public class MediatorPattern_two {
    public static void main(String[] args) {

        // 定义中介者
        MarriageAgency marriageAgency = new MarriageAgencyImpl();

        // 第一位男嘉宾
        Person 张三 = new Person("Michael", 18, Sex.MALE, 18, marriageAgency);

        // 四位女嘉宾
        Person 迪丽热巴 = new Person("迪丽热巴", 25, Sex.FEMALE, 18, marriageAgency);
        Person 杨幂 = new Person("杨幂", 25, Sex.FEMALE, 18, marriageAgency);
        Person 高圆圆 = new Person("迪丽热巴", 25, Sex.FEMALE, 18, marriageAgency);
        Person 李四 = new Person("李四", 18, Sex.FEMALE, 18, marriageAgency);

        marriageAgency.register(张三);
        marriageAgency.register(迪丽热巴);
        marriageAgency.register(杨幂);
        marriageAgency.register(高圆圆);
        marriageAgency.register(李四);

        // 缘分一线牵
        marriageAgency.pair(张三);

    }
}

/**
 * 中介者
 * 婚姻中介所
 */
interface MarriageAgency {
    // 为person配对
    void pair(Person person);

    // 注册会员
    void register(Person person);
}

class MarriageAgencyImpl implements MarriageAgency {

    List<Person> personList = new ArrayList<>();

    @Override
    public void pair(Person person) {
        for (Person p : personList) {
            if (p.age == person.requestAge && p.sex != person.sex) {
                System.out.println("将 " + person.name + " 与" + p.name + "送入洞房！");
            }
        }
    }

    @Override
    public void register(Person person) {
        personList.add(person);
    }
}

class Person {
    String name; // 姓名
    int age; // 年龄
    Sex sex; // 性别
    int requestAge; // 要求对象的年龄，对对象只有这一个要求

    MarriageAgency agency;

    public Person(String name, int age, Sex sex, int requestAge, MarriageAgency agency) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.requestAge = requestAge;
        this.agency = agency;
        agency.register(this); // 注册会员，进入会员库
    }

    // 给当前的person寻找对象
    public void findPartner() {
        agency.pair(this);
    }

}

enum Sex {
    MALE, FEMALE;
}
