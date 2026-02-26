package com.example.Securin.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.Securin.entity.Recipe;
import com.example.Securin.service.RecipeService;

@RestController
@RequestMapping("/api/recipe")
public class ReciperController {

    @Autowired
    private RecipeService rs;

    @PostMapping("/add")
    public ResponseEntity<Recipe> saveRecipe(@RequestBody Map<String, Object> r)throws Exception{
        Recipe sr = rs.saveRecipe(r);
        return new ResponseEntity<>(sr,HttpStatus.CREATED);
        
    }
   /*  @PostMapping("/bulkadd")
    public ResponseEntity<String> bulkadd(){
        rs.bulkadd();
        return new ResponseEntity<>("Bulk add successful",HttpStatus.CREATED);
    }*/
    @GetMapping("/top")
public ResponseEntity<List<Recipe>> getTopRecipes(
        @RequestParam(defaultValue = "5") int limit){

    return new ResponseEntity<>(rs.getTopRecipes(limit),HttpStatus.OK);
}



    
}
