package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository(); //final=값을 수정할 수 없도록 초기값 주기
    //MemoryMemberRepository에 의존하는 문제점을 아래와 같이 해결하면 추상화에만 의존(DIP를 지킴)
    private final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) { //AppConfig에서 선언
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
