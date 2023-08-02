package com.flora.backend.controller;


import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ProductController {
    private ProductService productService;

    @GetMapping("/products")
    public ResponsePageDTO<ProductView> ShowProducts(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "6") int size) {

        return productService.listProducts(page, size);
    }

}
