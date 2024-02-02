package charArt.charart.repository;

import charArt.charart.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member memeber);
    Optional<Member> findById(long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
