package com.example.LMS.service;

import com.example.LMS.entity.IssueBook;
import com.example.LMS.entity.Member;
import com.example.LMS.repository.MemberRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired

    private MemberRepo memberRepository;

    @Autowired
    @Lazy
    private IssueBookService issueBookService;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    public List<Member> findMembersWithOverdueBooks() {
        LocalDate currentDate = LocalDate.now();
        List<IssueBook> issuedBooks = issueBookService.findAll();

        return issuedBooks.stream()
                .filter(issueBook -> issueBook.getReturnDate().isBefore(currentDate))
                .map(IssueBook::getMember)
                .distinct()
                .collect(Collectors.toList());
    }

    public boolean hasMemberIssuedBook(String memberName) {
        List<Member> members = memberRepository.findByName(memberName);
        if (members.isEmpty()) {
            throw new RuntimeException("Member not found");
        }

        Member member = members.get(0);
        List<IssueBook> issuedBooks = issueBookService.findAll();

        return issuedBooks.stream()
                .anyMatch(issueBook -> issueBook.getMember().getId().equals(member.getId()));
    }

}
