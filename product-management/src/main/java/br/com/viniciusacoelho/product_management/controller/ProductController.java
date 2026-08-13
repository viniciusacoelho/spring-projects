package br.com.viniciusacoelho.product_management.controller;

import br.com.viniciusacoelho.product_management.dto.ProductDTO;
import br.com.viniciusacoelho.product_management.dto.ProductUpdateDTO;
import br.com.viniciusacoelho.product_management.entity.Product;
import br.com.viniciusacoelho.product_management.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.create(productDTO));
    }

    @GetMapping("/read")
    public ResponseEntity<List<Product>> read() {
        return ResponseEntity.ok(productService.read());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductUpdateDTO productUpdateDTO) {
        return ResponseEntity.ok(productService.update(id, productUpdateDTO));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") String id, @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.delete(id, productDTO));
    }

    @GetMapping("{name}")
    public ResponseEntity<List<Product>> findByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(productService.findByName(name));
    }

}
