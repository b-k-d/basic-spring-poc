package com.bkdas.service;

import com.bkdas.entity.Product;
import com.bkdas.repository.ProductBaseRepository;

@org.springframework.stereotype.Service
public class ProductService extends Service<Product,Long> {

    ProductBaseRepository productBaseRepository;

    public ProductService(ProductBaseRepository productBaseRepository) {
        super(productBaseRepository);
        this.productBaseRepository = productBaseRepository;
    }

    public Product create(final Product product){
        product.setDeleted(false);
        return productBaseRepository.save(product);
    }

    public Product update(final Long id, final Product product){
        final Product fromDb = read(id);
        fromDb.merge(product);
        return update(fromDb);
    }
}
