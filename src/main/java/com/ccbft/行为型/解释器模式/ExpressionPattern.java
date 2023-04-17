package com.ccbft.行为型.解释器模式;

import java.util.ArrayList;
import java.util.List;

// 将用户输入的 SQL 语句进行解析，并转换成对应的数据库操作。
public class ExpressionPattern {
    public static void main(String[] args) {
        String sql = "SELECT id, name FROM users WHERE age > 18 and grade is not null";

        List<AbstractExpression> expressions = new ArrayList<>();
        String[] segments = sql.split(" ");

        for (int i = 0; i < segments.length; i++) {
            String keyword = segments[i].toUpperCase();

            switch (keyword) {
                case "SELECT":
                    expressions.add(new SelectExpression(segments[++i]));
                    break;
                case "FROM":
                    expressions.add(new FromExpression(segments[++i]));
                    break;
                case "WHERE":
                    StringBuilder conditionBuilder = new StringBuilder();
                    while (++i < segments.length) {
                        if (segments[i].equalsIgnoreCase("AND")) {
                            conditionBuilder.append(" && ");
                        } else if (segments[i].equalsIgnoreCase("OR")) {
                            conditionBuilder.append(" || ");
                        } else {
                            conditionBuilder.append(" " + segments[i]);
                        }
                    }
                    expressions.add(new WhereExpression(conditionBuilder.toString()));
                    break;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (AbstractExpression expression : expressions) {
            builder.append(expression.interpret());
            builder.append(" ");
        }

        System.out.println(builder.toString());
    }
}

// 抽象表达式类
abstract class AbstractExpression {
    public abstract String interpret();
}

// 具体的表达式类
class SelectExpression extends AbstractExpression {
    private String column;

    public SelectExpression(String column) {
        this.column = column;
    }

    @Override
    public String interpret() {
        return "SELECT " + column;
    }
}

class FromExpression extends AbstractExpression {
    private String table;

    public FromExpression(String table) {
        this.table = table;
    }

    @Override
    public String interpret() {
        return "FROM " + table;
    }
}

class WhereExpression extends AbstractExpression {
    private String condition;

    public WhereExpression(String condition) {
        this.condition = condition;
    }

    @Override
    public String interpret() {
        return "WHERE " + condition;
    }
}
