package com.ccbft.行为型.策略模式.model;

import lombok.Getter;

/**
 * 定义一个枚举类，里面包括所有可以选择的类型
 * 枚举挺好的，可以定义code和description描述，省去了写多余的注释
 *
 * @author chensikeng
 * @create 2022/9/16 15:09
 **/
@Getter
public enum SexEnum {
    MALE("male", "男性"),
    FEMALE("female", "男性"),
    UNKNOWNPERSON("unknownperson", "未知类型人类");

    private String code;
    private String sex;

    SexEnum(String code, String sex) {
        this.code = code;
        this.sex = sex;
    }
}
