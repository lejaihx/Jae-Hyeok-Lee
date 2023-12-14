package kr.ac.hufs.demo2.repository;

import kr.ac.hufs.demo2.domain.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.function.Function;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByNameAndEmail(String name, String email);
    Member findByIdAndEmail(Long id, String email);
}
