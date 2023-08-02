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
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @GetMapping("/")
    public ResponsePageDTO<ProductView> ShowProducts(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "6") int size) {

        return productService.showProducts(page, size);
    }
    @GetMapping("/by-category")
    public ResponsePageDTO<ProductView> ShowProductsByCategory(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "category_id") Long categoryId,
            @RequestParam(name = "size", defaultValue = "6") int size) {

        return productService.findByCategory(page, size,categoryId);
    }



    @GetMapping("/search")
    public ResponsePageDTO<ProductView> searchProduct(@RequestParam(name = "keyword", defaultValue = "") String keyword,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "6") int size) {

        return productService.SearchProducts("%" + keyword + "%", page, size);
    }

}
