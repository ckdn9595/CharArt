package charArt.charart.service;

import charArt.charart.domain.Member;
import charArt.charart.repository.MemberRepository;
import charArt.charart.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService ms;
    MemoryMemberRepository mr;
    @BeforeEach
    public void beforeEach(){
        mr = new MemoryMemberRepository();
        ms = new MemberService(mr);
    }
    @AfterEach
    public void afterEach(){
        mr.clear();
    }
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        long saveId = ms.join(member);
        //then
        Member m = ms.find(saveId).get();
        assertThat(member.getName()).isEqualTo(m.getName());
    }

    @Test
    void 중복_회원_예외() {
        Member member1 = new Member();
        member1.setName("hello");
        Member member2 = new Member();
        member2.setName("hello");
        ms.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> ms.join(member2));
        assertThat(e.getMessage()).isEqualTo("already exist");
        /*try{
            ms.join(member1);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("already exist");
        }*/
    }

    @Test
    void 회원찾기() {
    }
}