package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind(){
       AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

       PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
       prototypeBean1.addcount();
       assertThat(prototypeBean1.getCount()).isEqualTo(1);

       PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
       prototypeBean2.addcount();
       assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }


    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class,ClientBean.class);
        ClientBean ClientBean1 = ac.getBean(ClientBean.class);
        ClientBean ClientBean2 = ac.getBean(ClientBean.class);

        int count1 = ClientBean1.logic();
        assertThat(count1).isEqualTo(1);

        int count2 = ClientBean2.logic();
        assertThat(count2).isEqualTo(1);
    }
    @Scope("singleton")
    static class ClientBean {
//        private final PrototypeBean prototypeBean; //생성시점에 이미주입됨

        @Autowired
//        private ObjectProvider<PrototypeBean> prototypeBeanObjectProvider; //프로토타입빈 찾아주는 기능
//        private ObjectFactory<PrototypeBean> prototypeBeanObjectProvider; //프로토타입빈 찾아주는 기능
          private Provider<PrototypeBean> prototypeBeanProvider;


//        @Autowired
//        public ClientBean(PrototypeBean prototypeBean){
//            this.prototypeBean = prototypeBean;
//        }

        public int logic(){
//            PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class);
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addcount();
            int count = prototypeBean.getCount();
            return count;
        }
    }



    @Scope("prototype")
    static class  PrototypeBean {
        private int count =0;

        public void addcount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init");
        }
        @PreDestroy
        public void destorY(){
            System.out.println("PrototypeBean.destory");
        }
    }
}
