package hello.core.singletone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);

        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);
        //ThreadA 1
        int userAPrice = statefulService1.order("userA",100000);

        //ThreadA 2
        int userBPrice = statefulService2.order("userB",200000);


        //ThreadA
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);

        assertThat(userAPrice).isEqualTo(100000);
    }

    static class  TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}