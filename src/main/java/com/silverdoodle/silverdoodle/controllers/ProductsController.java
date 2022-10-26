package com.silverdoodle.silverdoodle.controllers;

import com.silverdoodle.silverdoodle.dtos.ProductDto;
import com.silverdoodle.silverdoodle.services.ProductService;
import com.silverdoodle.silverdoodle.models.Product; 
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/products")
public class ProductsController {
    
    final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public ResponseEntity<Page<Product>> getAllParkingSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll(pageable));
    }
    
    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ProductDto productDto){
       
        var productModel = new Product();
        BeanUtils.copyProperties(productDto, productModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productModel));
    }

}
