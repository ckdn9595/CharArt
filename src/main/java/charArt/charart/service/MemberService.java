package charArt.charart.service;

import charArt.charart.repository.MemberRepository;
import charArt.charart.repository.MemoryMemberRepository;
import charArt.charart.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private final MemberRepository _repo;

    public MemberService(MemberRepository _repo) {
        this._repo = _repo;
    }

    public long join (Member member){
        checkExist(member);
        _repo.save(member);
        return member.getId();
    }

    public List<Member> findMembers(){
        return _repo.findAll();
    }

    public Optional<Member> find(long memberId){
        return _repo.findById(memberId);
    }
    private void checkExist(Member member) {
        _repo.findByName(member.getName())
            .ifPresent( m -> {
                throw new IllegalStateException("already exist");
            });
    }

}
