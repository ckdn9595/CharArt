package charArt.charart.repository;

import charArt.charart.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repo = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
        repo.clear();
    }
    @Test
    public void save(){
        Member m = new Member();
        m.setName("jiwoo");
        repo.save(m);
        Member m2 = repo.findById(m.getId()).get();
        //Assertions.assertEquals(m,m2);
        assertThat(m).isEqualTo(m2);
    }
    @Test
    public void findByName(){
        Member m = new Member();
        m.setName("jiwoo");
        repo.save(m);

        Member m2 = new Member();
        m2.setName("jiwoo2");
        repo.save(m2);

        Member result = repo.findByName("jiwoo2").get();

        assertThat(m2).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member m = new Member();
        m.setName("jiwoo");
        repo.save(m);

        Member m2 = new Member();
        m2.setName("jiwoo2");
        repo.save(m2);

        List<Member> members = repo.findAll();
        assertThat(members.size()).isEqualTo(2);
    }
}
