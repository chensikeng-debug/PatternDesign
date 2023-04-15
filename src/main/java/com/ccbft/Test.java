package com.ccbft;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2022/9/19 11:05
 */
public class Test {
    public static void main(String[] args) {
        /*ArrayList<String> list = new ArrayList<>();
        list.add("null");
        Iterator<String> iterator = list.iterator();
        if(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next.toString());
        }*/

       /* String line = "a1|@|a2|@|a3";
        String lineEnd = "a1|@|a2|@|a3|@|";
        String splitSep = "|@|".replaceAll("\\|", "\\\\|");
        String[] split = line.split(splitSep, -1);
        String[] splitEnd = lineEnd.split(splitSep, -1);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            System.out.println("第" +i+"个是：" +  s);
        }
        for (int i = 0; i < splitEnd.length; i++) {
            String s = splitEnd[i];
            System.out.println("第" +i+"个是：" +  s);
        }
        System.out.println("line Length :" + split.length);
        System.out.println("lineEnd Length :" + splitEnd.length);*/

       /* ArrayList allRows = new ArrayList<String>();
        allRows.add("aa|&|bb");
        allRows.add("5|&|18");
        String join = StringUtils.join(allRows, "\n");
        String join1 = StringUtils.join(allRows , "|&|\n");
        System.out.println(join);
        System.out.println("--------------");
        System.out.println(join1);*/
        // 期望字段个数关系.原始字段个数和读取出来的个数
//        String line = "ck|&||&|";
//        String s = "|&|".replaceAll("\\|", "\\\\|");
//        String[] split = line.split(s, -1);
//        System.out.println(split.length);
        // 3是正确的分割结果

//        String line = "ck,aa,dd";
//        String s = ",".replaceAll("\\|", "\\\\|");
//        System.out.println(s);
//        String[] split = line.split(s, -1);
//        System.out.println(split.length);
//        for (
//        String s1 : split) {
//            System.out.println(s1);
//        }

        String s = null;
        boolean blank = StringUtils.isBlank(s);
        System.out.println(blank);
    }
}
/**
 * 第0个是：a1
 * 第1个是：a2
 * 第2个是：a3
 * 第0个是：a1
 * 第1个是：a2
 * 第2个是：a3
 * 第3个是：
 * line Length :3
 * lineEnd Length :4
 */