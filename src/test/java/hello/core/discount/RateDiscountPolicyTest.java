package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy=new RateDiscountPolicy();

    //성공 테스트 경우
    @Test
    @DisplayName("VIP는 10프로 할인이 되어야 한다")
    void vip_o(){
        //given
        Member member=new Member(1L,"membervip", Grade.VIP);

        //when
        int discount= discountPolicy.discount(member,10000);

        //then
        assertThat(discount).isEqualTo(1000);  //Alt+Enter 로 자바 static
    }


    //실패 테스트 경우
    @Test
    @DisplayName("VIP가 아닌 경우 10프로 할인 x")
    void vip_x(){
        //given
        Member member=new Member(1L,"memberbasic", Grade.BASIC);

        //when
        int discount= discountPolicy.discount(member,10000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}