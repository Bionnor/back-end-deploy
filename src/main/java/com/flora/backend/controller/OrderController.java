package com.flora.backend.controller;


import com.flora.backend.dtos.Product.ProductSaveDTO;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
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
    @GetMapping
    public ResponsePageDTO<ProductView> getFilteredProducts(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "0") int pageNumber) {
        return productService.getFilteredProducts(searchTerm, categoryId, pageSize, pageNumber);
    }
    @PutMapping("/{productId}")
    public ResponseEntity<ProductView> updateProduct(@PathVariable Long productId, @RequestBody ProductSaveDTO updatedProduct) {
        ProductView result = productService.updateProduct(productId, updatedProduct);
        log.info(result.toString());
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        boolean isDeleted = productService.deleteProduct(productId);

        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @GetMapping("/search")
    public ResponsePageDTO<ProductView> searchProduct(@RequestParam(name = "keyword", defaultValue = "") String keyword,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "6") int size) {

        return productService.SearchProducts("%" + keyword + "%", page, size);
    }

    @PostMapping("/")
    public ProductSaveDTO addProduct(@RequestBody ProductSaveDTO productSaveDTO) {
        return productService.addProduct(productSaveDTO);
    }
    @GetMapping("/{id}")
    public ProductView getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }
}
