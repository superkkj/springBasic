package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration //스프링 컨테이너에 다 등록시키자 bean!
public class AppConfig { //DI 외부에서 의존관계주입.. 역활을 세우고 구현을 세우는.. 배우들 잘배치하자


    // bean  memberservice -> new MemoryMemberRepository
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());

    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}












//public class AppConfig {
//
//    public MemberService memberService(){
//        return new MemberServiceImpl(getMemberRepository());
//
//    }
//
//    private MemberRepository getMemberRepository() {
//        return new MemoryMemberRepository();
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
//    }
//
//    public DiscountPolicy discountPolicy(){
//        return new RateDiscountPolicy();
//    }
//}
