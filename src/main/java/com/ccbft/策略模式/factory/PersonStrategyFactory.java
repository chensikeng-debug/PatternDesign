package com.ccbft.策略模式.factory;

import com.ccbft.策略模式.model.SexEnum;
import com.ccbft.策略模式.strategy.FemalePersonStrategy;
import com.ccbft.策略模式.strategy.MalePersonStrategy;
import com.ccbft.策略模式.strategy.PersonStrategy;
import com.ccbft.策略模式.strategy.UnknowPersonStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略选择器，通过get方法获取不同类型对应的策略
 * 只返回对应类型的策略，策略的具体执行由策略自身来执行
 *
 * @author Administrator
 * @date 2022/9/16 15:12
 */
public class PersonStrategyFactory {

    private static Map<String, PersonStrategy> map = new HashMap<String, PersonStrategy>();

    static {
        map.put(SexEnum.FEMALE.getCode(), new FemalePersonStrategy());
        map.put(SexEnum.MALE.getCode(), new MalePersonStrategy());
        map.put(SexEnum.UNKNOWNPERSON.getCode(), new UnknowPersonStrategy());
    }

    public static PersonStrategy getPersonStrategy(String sex) {
        return map.get(sex);
    }

   /* private MalePersonStrategy malePersonStrategy = new MalePersonStrategy();
    private FemalePersonStrategy femalePersonStrategy = new FemalePersonStrategy();
    private UnknowPersonStrategy unknowPersonStrategy = new UnknowPersonStrategy();

    public PersonStrategy getPersonStrategy(SexEnum sex) {
        if (SexEnum.FEMALE.getCode().equals(sex.getCode())) {
            return femalePersonStrategy;
        } else if (SexEnum.MALE.getCode().equals(sex.getCode())) {
            return malePersonStrategy;
        } else {
            return unknowPersonStrategy;
        }
    }*/

}
