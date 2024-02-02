package charArt.charart.service;

import charArt.charart.domain.Member;
import charArt.charart.repository.JpaMemberRepository;
import charArt.charart.repository.MemberRepository;
import charArt.charart.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello3");
        //when
        long saveId = memberService.join(member);
        //then
        Member m = memberService.find(saveId).get();
        assertThat(member.getName()).isEqualTo(m.getName());
    }

    @Test
    void 중복_회원_예외() {
        Member member1 = new Member();
        member1.setName("hello");
        Member member2 = new Member();
        member2.setName("hello");
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("already exist");

    }

    @Test
    void 회원찾기() {
    }
}
