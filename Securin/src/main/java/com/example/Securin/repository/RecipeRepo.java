package com.example.Securin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.Securin.entity.Recipe;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe,Long> {
     List<Recipe> findAllByOrderByRatingDesc();
    
}
