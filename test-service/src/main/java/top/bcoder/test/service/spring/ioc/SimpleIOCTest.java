package top.bcoder.test.service.spring.ioc;

import org.junit.jupiter.api.Test;

public class SimpleIOCTest {
    @Test
    public void getBean() throws Exception {
       // String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        String location = "src/main/java/top/bcoder/test/service/spring/ioc/ioc.xml";
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }
}