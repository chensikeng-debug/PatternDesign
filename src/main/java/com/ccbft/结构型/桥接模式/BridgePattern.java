package com.ccbft.结构型.桥接模式;


/**
 * 举个例子，截图里面画形状，形状有圆形，方形 等
 * shape可以有下面属性随意组合构造
 * 颜色有红色，蓝色...
 * 画图工具有笔，铅笔...
 */
public class BridgePattern {
    public static void main(String[] args) {
        DrawingTool pen = new Pen();
        ColorStyle redColor = new RedColor();
        Shape redCircle = new Circle(pen, redColor);
        redCircle.draw();
    }
}

// 画图工具接口
interface DrawingTool {
    void draw();
}


// 颜色样式接口
interface ColorStyle {
    String getColor();
}

// 我要画一个形状
abstract class Shape {
    protected DrawingTool drawingTool;
    protected ColorStyle colorStyle;

    public Shape(DrawingTool drawingTool, ColorStyle colorStyle) {
        this.drawingTool = drawingTool;
        this.colorStyle = colorStyle;
    }

    public abstract void draw();
}

// 具体画图工具实现类
class Pen implements DrawingTool {
    @Override
    public void draw() {
        System.out.print("Using Pen to draw ");
    }
}

class Pencil implements DrawingTool {
    @Override
    public void draw() {
        System.out.print("Using Pencil to draw ");
    }
}

// 具体颜色样式实现类
class RedColor implements ColorStyle {
    @Override
    public String getColor() {
        return "in Red";
    }
}

class BlueColor implements ColorStyle {
    @Override
    public String getColor() {
        return "in Blue";
    }
}

class Circle extends Shape {

    public Circle(DrawingTool drawingTool, ColorStyle colorStyle) {
        super(drawingTool, colorStyle);
    }

    @Override
    public void draw() {
        drawingTool.draw();
        System.out.println("a Circle " + colorStyle.getColor());
    }
}

class Rectangle extends Shape {

    public Rectangle(DrawingTool drawingTool, ColorStyle colorStyle) {
        super(drawingTool, colorStyle);
    }

    @Override
    public void draw() {
        drawingTool.draw();
        System.out.println("a Rectangle " + colorStyle.getColor());
    }
}

class Triangle extends Shape {

    public Triangle(DrawingTool drawingTool, ColorStyle colorStyle) {
        super(drawingTool, colorStyle);
    }

    @Override
    public void draw() {
        drawingTool.draw();
        System.out.println("a Triangle " + colorStyle.getColor());
    }
}