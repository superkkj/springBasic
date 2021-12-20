package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){

        ApplicationContext ac = new AnnotationConfigApplicationContext((TestBean.class));
    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){ //spring bean에 없는거? false 이기때문에 의존관계가없어서 아에 호출이안됌
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired(required = true)
        public void setNoBean2(@Nullable Member noBean2){ //spring bean에 없는거?
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired(required = true)
        public void setNoBean3(Optional<Member> noBean3){ //spring bean에 없는거?
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
