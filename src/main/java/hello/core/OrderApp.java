package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrderApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService  orderService = new OrderServiceImpl(null, null);
//        AppConfig appConfig = new AppConfig();
//
//
//        MemberService memberService =appConfig.memberService();
//        OrderService  orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //스프링이 빈에등록된거 다관리해줌..
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService  orderService = applicationContext.getBean("orderService",OrderService.class);

        Long memberId= 1L;
        Member member = new Member(memberId,"MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",20000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());


    }
}


//public class OrderApp {
//
//    public static void main(String[] args) {
////        MemberService memberService = new MemberServiceImpl(null);
////        OrderService  orderService = new OrderServiceImpl(null, null);
//        AppConfig appConfig = new AppConfig();
//
//
//        MemberService memberService =appConfig.memberService();
//        OrderService  orderService = appConfig.orderService();
//
//        Long memberId= 1L;
//        Member member = new Member(memberId,"MemberA", Grade.VIP);
//        memberService.join(member);
//
//        Order order = orderService.createOrder(memberId,"itemA",20000);
//
//        System.out.println("order = " + order);
//        System.out.println("order = " + order.calculatePrice());
//
//
//    }
//}
