package kr.ac.hufs.demo2.service;

import kr.ac.hufs.demo2.domain.Member;
import kr.ac.hufs.demo2.dto.PostUserRequest;
import kr.ac.hufs.demo2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    final MemberRepository memberRepository;

    public void registerMember(PostUserRequest postUserRequest) {

        if (memberRepository.findByNameAndEmail(postUserRequest.getName(), postUserRequest.getEmail()) != null) {
            return;
        }

        System.out.println(postUserRequest.toString());
        Member member = new Member(postUserRequest.getName(), postUserRequest.getEmail());
        member.setAddress(postUserRequest.getAddress());

        System.out.println(member.toString());

        memberRepository.save(member);
    }

    public void modifyMember(PostUserRequest postUserRequest) {
        Member member = memberRepository.findByNameAndEmail(postUserRequest.getName(), postUserRequest.getEmail());

        if ( member == null) {
            return;
        }

        member.setAddress(postUserRequest.getAddress());
        member.setPassword(postUserRequest.getPassword());

        memberRepository.save(member);
    }

    public void deleteMember(Long id, String email) {
        Member member = memberRepository.findByIdAndEmail(id, email);

        if (member == null) {
            return;
        }

        memberRepository.deleteById(id);
    }

    public List<Member> getMemberAll() {
        List<Member> members = memberRepository.findAll();

        return members;

    }

    public Member getMember(Long id, String email) {
        return memberRepository.findByIdAndEmail(id, email);
    }
}
