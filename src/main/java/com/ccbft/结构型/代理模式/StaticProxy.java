package com.ccbft.结构型.代理模式;
//代理模式[控制对对象的访问]，通常是因为原始对象无法满足某些特定要求或安全限制。
//优点：可以做到在符合开闭原则的情况下对目标对象进行功能扩展。

public class StaticProxy {
    public static void main(String[] args) {
        Website proxyWebsite1 = new ProxyWebsite("www.jd.com");
        proxyWebsite1.access();
    }
}

interface Website {
    void access();
}

class RealWebsite implements Website {
    private String url;

    public RealWebsite(String url) {
        this.url = url;
        load();
    }

    @Override
    public void access() {
        System.out.println("Accessing real website " + url);
    }

    private void load() {
        System.out.println("Loading real website " + url);
    }
}

class ProxyWebsite implements Website {
    private RealWebsite website;
    private String url;

    public ProxyWebsite(String url) {
        this.url = url;
    }

    @Override
    public void access() {
        if (website == null) {
            website = new RealWebsite(url);
        }
        website.access();
    }
}
