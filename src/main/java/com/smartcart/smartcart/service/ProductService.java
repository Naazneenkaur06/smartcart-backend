package com.smartcart.smartcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcart.smartcart.model.Product;
import com.smartcart.smartcart.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product){

        Product existingProduct = productRepository.findById(id).orElse(null);

        if(existingProduct!=null){
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setImageUrl(product.getImageUrl());

            return productRepository.save(existingProduct);
        }

        return null;
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}