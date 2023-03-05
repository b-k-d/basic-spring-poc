package com.bkdas.mapper;

import com.bkdas.entity.Product;
import com.bkdas.model.request.ProductCreateRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductMapper {

    @Autowired
    private final ModelMapper mapper;

    public Product MapToEntity(final ProductCreateRequest request){
        final Product product = mapper.map(request, Product.class);
        return product;
    }
}
