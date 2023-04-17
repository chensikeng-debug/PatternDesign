package com.ccbft.行为型.解释器模式;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExpresessionPattern2 {
    public static void main(String[] args) {
    }
}

class XmlToObjectDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("src/main/java/com/ccbft/行为型/解释器模式/person.xml");

        // 创建 DocumentBuilderFactory 和 DocumentBuilder 对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // 使用 DocumentBuilder 解析 XML 文件，并得到 Document 对象
        Document document = builder.parse(file);

        // 遍历所有 <person> 元素，将其转换成 Person 对象并加入列表中
        List<Person> persons = new ArrayList<>();
        NodeList nodeList = document.getElementsByTagName("person");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String id = element.getAttribute("id");
            String name = element.getElementsByTagName("name").item(0).getTextContent();
            int age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());
            String gender = element.getElementsByTagName("gender").item(0).getTextContent();
            persons.add(new Person(id, name, age, gender));
        }

        // 输出所有 Person 对象
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}

class Person {
    private String id;
    private String name;
    private int age;
    private String gender;

    public Person(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}