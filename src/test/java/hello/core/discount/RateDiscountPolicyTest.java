package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 는  10% 할인이 적용 되어야 한다 ")
    void vip_o(){
        //given

        Member member = new Member(1L,"MEMBERVIP" , Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);
        //wehn
        assertThat(discount).isEqualTo(1000);
        //then
    }


    @Test
    @DisplayName("VIP가 아니면 할인이 적용 되지 않아야 한다. ")
    void vip_x(){
        //given
        Member member = new Member(1L,"test" , Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);

    }

}