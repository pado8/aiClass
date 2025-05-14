package org.zerock.mreview.club.entity;


import lombok.*;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import org.zerock.mreview.entity.BaseEntity;

@Entity
@AllArgsConstructor
@Getter
@ToString
public class ClubMember extends BaseEntity {

    @Id
    private String email;

    private String password;

    private String name;

    private boolean fromSocial;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<ClubMemberRole> roleSet = new HashSet<>();

    public void addMemberRole(ClubMemberRole clubMemberRole){
        roleSet.add(clubMemberRole);
    }

}