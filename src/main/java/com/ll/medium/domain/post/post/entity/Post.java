package com.ll.medium.domain.post.post.entity;

import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.global.jpa.entity.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Post extends BaseTime {
    @ManyToOne
    private Member author;
    private String title;
    private String body;
    private boolean published;
    private boolean isPaid; // 조건 1을 위한 추가 필드

    // ...

    public String getContentForMember(boolean isPaidMember) {
        if (isPaid && !isPaidMember) {
            return "이 글은 유료멤버십전용 입니다.";
        }
        return body;
    }
}
