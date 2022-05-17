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
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //역할
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
   //<---------------------------------------------------------------------------------->
    //구현
   @Bean
    public MemberRepository memberRepository() {//MemberRepository의 구체적인 구현을 볼 수 있게 역할과 구현 분리 refactoring
        return new MemoryMemberRepository();
    }


    @Bean
    public DiscountPolicy discountPolicy() {//DiscountPolicy의 구체적인 구현을 볼 수 있게 역할과 구현 분리 refactoring
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}

