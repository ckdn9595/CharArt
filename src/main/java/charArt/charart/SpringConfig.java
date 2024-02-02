package charArt.charart;

import charArt.charart.aop.TimeTraceAop;
import charArt.charart.repository.JpaMemberRepository;
import charArt.charart.repository.MemberRepository;
import charArt.charart.repository.SpringDataJpaMemberRepository;
import charArt.charart.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    private EntityManager entityManager;
    private MemberRepository mr;

    @Autowired
    public SpringConfig(MemberRepository mr) {
//        this.dataSource = dataSource;
//        this.entityManager = entityManager;
        this.mr = mr;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(mr);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository() {
//        //     return new JpaMemberRepository<M, Number>(entityManager);
////        return new MemoryMemberRepository();
//
//    }
}
