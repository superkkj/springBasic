package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final 붙은 필드를 파라미터를 받는 만들어준다
public class OrderServiceImpl implements OrderService {

//       private  DiscountPolicy discountPolicy = new FixDiscountPolicy(); //ex 여배우를 직접 남배우가 선택하는것과 같다
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // 생성자 주입시 파이널 키워드를 넣을수잇다 불변!

    private final MemberRepository memberRepository;
      private final DiscountPolicy discountPolicy; //final 무조건 값이 있어야

//    new OrderServiceIml(memberRepository ,discountPolicy)
     //생성자에 넣어주자됨 생성자가 1개면 오토와이어드 생략해도됨
    public OrderServiceImpl(MemberRepository memberRepository,  @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy; //2개이상 빈일때 rateDiscountPolicy 이런식으로 바꿔줘야됨 파라미터 명 변경 식으로
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice); // 주문은 주문만 할인은 내관할이 아니야! 결과만 나한테 던져줘 할인이잘못됫으면 할인부분을 고쳐 단일책임의정

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

//    //test 아래는 다 테스트
//    public MemberRepository getMemberRepository() {
//        return memberRepository;
//    }
//
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
}