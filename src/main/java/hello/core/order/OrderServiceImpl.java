package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    //private final MemberRepository memberRepository=new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy=new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy=new RateDiscountPolicy();

    //위 DIP위반을 해결하기 위해서
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {//전혀 구체적인 클래스 모름
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice= discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
