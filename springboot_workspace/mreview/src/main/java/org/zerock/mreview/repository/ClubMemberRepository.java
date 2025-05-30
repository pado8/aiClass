package org.zerock.mreview.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.mreview.entity.ClubMember;

public interface ClubMemberRepository extends JpaRepository<ClubMember, String>{
  @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
  @Query("select m from ClubMember m where m.fromSocial = :social and m.email = :email")
  Optional<ClubMember> findByEmail(String email, boolean social);
  
}
