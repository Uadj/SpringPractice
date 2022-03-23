package com.example.jpa_inflearn.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
