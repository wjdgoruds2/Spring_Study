package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent=10; //1000원 할인

    @Override
    public int discount(Member member, int price) { //Test클래스 생성법 = ctrl + shift +T
        if (member.getGrade()== Grade.VIP){ //enum은 == 타입쓰는 것이 옳다
            return price*discountPercent/100;
        }else {
            return 0;
        }
    }
}