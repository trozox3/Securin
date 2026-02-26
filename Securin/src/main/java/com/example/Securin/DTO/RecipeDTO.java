package com.example.Securin.DTO;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
     private String title;
    private String cuisine;
    private Double rating;
    @JsonProperty("prep_time")
    private Integer prep_time;
    @JsonProperty("cook_time")
    private Integer cook_time;
    private String description;
    private Map<String,String> nutrients;
    private String serves;
}
