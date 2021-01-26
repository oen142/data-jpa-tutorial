package com.jpa.datajpatutorial;

import com.jpa.datajpatutorial.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;


    /*
     * 테스트에 있으면 DB끝나고 롤백을 한다.
     * 반복적인 테스트를 못하기 때문이다.
     * */
    @Test
    @Transactional
    @Rollback(false)
    @DisplayName("테스트를 한다.")
    void name() {

        Member member = new Member();
        member.setName("memberA");

        Long savedId = memberRepository.save(member);

        Member findMember = memberRepository.find(savedId);
        Assertions.assertThat(findMember).isEqualTo(member);

    }
}