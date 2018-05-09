package bitcamp.java106.step01;

import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean("c1")
    public Car getCar() {
        Car c = new Car();
        c.setModel("소나타");
        c.setMaker("비트자동차");
        c.setCc(1980);
        return c;
    }
}
