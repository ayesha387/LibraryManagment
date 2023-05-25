package com.example.LMS.repository;

import com.example.LMS.entity.Member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {

    List<Member> findByName(String memberName);
}
