package com.bkdas.controller;

import com.bkdas.entity.Category;
import com.bkdas.model.request.ApiRequest;
import com.bkdas.model.response.ApiResponse;
import com.bkdas.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/categories", consumes = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/{id}")
    public @ResponseBody ApiResponse<Category> read(@PathVariable("id") final Long id){
        return new ApiResponse<>(categoryService.read(id));
    }

    @PostMapping
    public @ResponseBody ApiResponse<Category> create(@RequestBody final ApiRequest<Category> request){
        return new ApiResponse<>(categoryService.create(request.getPayload()));
    }

    @PutMapping
    public @ResponseBody ApiResponse<Category> update(@RequestBody final Category category){
        return new ApiResponse<>(categoryService.update(category));
    }

    @PatchMapping("/{id}")
    public @ResponseBody ApiResponse<Category> update(@PathVariable("id") final Long id, @RequestBody final Category category){
        return new ApiResponse<>(categoryService.update(id,category));
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ApiResponse<Boolean> delete(@PathVariable("id") final Long id){
        return new ApiResponse<>(categoryService.delete(id));
    }

    @GetMapping
    public @ResponseBody ApiResponse<List<Category>> all(){
        return new ApiResponse<>(categoryService.all());
    }
}
