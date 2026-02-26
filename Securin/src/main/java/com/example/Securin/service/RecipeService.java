package com.example.Securin.service;



//import java.io.InputStream;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;


//mport org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import org.springframework.stereotype.Service;


import com.example.Securin.entity.Recipe;
import com.example.Securin.repository.RecipeRepo;
//import com.example.Securin.DTO.RecipeDTO;


//import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;




@Service
public class RecipeService {
    @Autowired
    private RecipeRepo rr;  

    public Recipe saveRecipe(Map<String, Object> res)
    {
       
    ObjectMapper mapper = new ObjectMapper();

    Recipe r = new Recipe();

    r.setTitle((String) res.get("title"));
    r.setCuisine((String) res.get("cuisine"));
    r.setRating(Double.valueOf(res.get("rating").toString()));
    r.setDescription((String) res.get("description"));
    Integer prep = Integer.valueOf(res.get("prep_time").toString());
    Integer cook = Integer.valueOf(res.get("cook_time").toString());

    r.setPrepTime(prep);
    r.setCookTime(cook);

    
    Object nutrientsObj = res.get("nutrients");
    r.setNutrients(mapper.writeValueAsString(nutrientsObj));
    r.setServes((String)res.get("serves"));
    if(prep != null && cook != null){
        r.setTotalTime(prep + cook);
    }

    return rr.save(r);
    }
   
   public List<Recipe> getTopRecipes(int limit){

    Pageable pageable =
            PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "rating"));

    return rr.findAll(pageable).getContent();
}



















































/*  public void bulkadd(){
        try{
               ObjectMapper mapper = new ObjectMapper();
               InputStream in=new ClassPathResource("recipes.json").getInputStream();
               Map<String,RecipeDTO> rm=mapper.readValue(in, new TypeReference<Map<String, RecipeDTO>>(){});
               
               List<Recipe> recipes = new ArrayList<>();
               for(RecipeDTO r: rm.values()){
                  if (r.getTitle() == null ) {
                               
                                 continue;
                        }
                   Recipe recipe = new Recipe();
                   recipe.setTitle(r.getTitle());
                   recipe.setCuisine(r.getCuisine());
                   recipe.setRating(r.getRating());
                   recipe.setDescription(r.getDescription());
                   Integer prep = r.getPrep_time()==null ? 0 : r.getPrep_time();
                   Integer cook = r.getCook_time()==null ? 0 : r.getCook_time();
                   
                   recipe.setPrepTime(prep);
                   recipe.setCookTime(cook);
                   recipe.setTotalTime(prep + cook);
                   recipe.setNutrients(mapper.writeValueAsString(r.getNutrients()));
                   recipes.add(recipe);
                   
               }
               rr.saveAll(recipes);
               
               
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }*/
  

    
}
