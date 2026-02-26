package com.example.Securin.entity;




import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipes")

public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String cuisine;
    @Column(nullable = true)
    private Double rating;

    @JsonProperty("prep_time")
    @Column(nullable = false)
    private Integer prepTime;

    @JsonProperty("cook_time")
    @Column(nullable = false)
    private Integer cookTime;

    @JsonProperty("total_time")
    private Integer totalTime;

    @Column(columnDefinition = "TEXT")
    private String description;

    @JsonRawValue
    @Column(columnDefinition = "LONGTEXT")
    private String nutrients;

    private String serves;


    
}
