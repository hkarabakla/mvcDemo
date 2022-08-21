package com.example.mvcdemo.repository;

import com.example.mvcdemo.model.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
}
