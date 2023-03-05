package com.bkdas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category extends Base {
    private String name;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Product> products;

    public void merge(final Category category){
        if (!StringUtils.isEmpty(category.getName()))
            this.name = category.getName();
        if (!StringUtils.isEmpty(category.getDescription()))
            this.description = category.getDescription();
    }
}
