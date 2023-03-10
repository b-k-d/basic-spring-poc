package com.bkdas.controller;

import com.bkdas.entity.Category;
import com.bkdas.entity.Product;
import com.bkdas.mapper.ProductMapper;
import com.bkdas.model.request.ApiRequest;
import com.bkdas.model.request.ProductCreateRequest;
import com.bkdas.model.response.ApiResponse;
import com.bkdas.service.CategoryService;
import com.bkdas.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private ProductService productService;

    private CategoryService categoryService;

    private ProductMapper productMapper;

    @GetMapping("/{id}")
    public @ResponseBody ApiResponse<Product> read(@PathVariable("id") final Long id){
        return new ApiResponse<>(productService.read(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ApiResponse<Product> create(@RequestBody final ApiRequest<ProductCreateRequest> request){
        final Category category = categoryService.read(request.getPayload().getCategoryId());
        final Product product = productMapper.MapToEntity(request.getPayload());
        product.setCategory(category);
        return new ApiResponse<>(productService.create(product));
    }

    @PutMapping
    public @ResponseBody ApiResponse<Product> update(@RequestBody final Product product){
        return new ApiResponse<>(productService.update(product));
    }

    @PatchMapping("/{id}")
    public @ResponseBody ApiResponse<Product> update(@PathVariable("id") final Long id, @RequestBody final Product product){
        return new ApiResponse<>(productService.update(id,product));
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ApiResponse<Boolean> delete(@PathVariable("id") final Long id){
        return new ApiResponse<>(productService.delete(id));
    }

    @GetMapping
    public @ResponseBody ApiResponse<List<Product>> all(){
        return new ApiResponse<>(productService.all());
    }
}

