package com.example.spring.cloud.contract.producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class MovieEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String genre;
    private String year;
}