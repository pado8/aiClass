package org.zerock.mreview.entity;

import java.util.Set;

import org.hibernate.annotations.BatchSize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    // BatchSize는 100~1000이 적당.
    // user가 10000명이고 BatchSize가 100이면, 10000/100 = 100 
    @BatchSize(size = 100)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    // @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    // @OneToMany(mappedBy = "user")
    private Set<Article> articles;
    
}
