package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService=new MemberServiceImpl();
    @Test
    void join(){ //테스트 코드 작성으로 findmember 와 member가 동일한지 콘솔에 출력하지 않고 확인 가능
        //given
        Member member=new Member(1L,"memberA",Grade.VIP);
        //when
        memberService.join(member);
        Member findmember=memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findmember);

    }
}
