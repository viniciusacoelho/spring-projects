package br.com.viniciusacoelho.product_management.service;

import br.com.viniciusacoelho.product_management.dto.ProductDTO;
import br.com.viniciusacoelho.product_management.dto.ProductUpdateDTO;
import br.com.viniciusacoelho.product_management.entity.Product;
import br.com.viniciusacoelho.product_management.exceptions.NotFoundException;
import br.com.viniciusacoelho.product_management.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.name())
                .price(productDTO.price())
                .inventory(productDTO.inventory())
                .category(productDTO.category())
                .build();
        return productRepository.save(product);
    }

    public List<Product> read() {
        if (isCount()) {
            return productRepository.findAll();
        }
        return null;
    }

    public Product update(String id, ProductUpdateDTO productUpdateDTO) {
        Product product = findById(id);

        hasProduct(id);

        product = Product.builder()
                .id(product.getId())
                .name(productUpdateDTO.name())
                .price(productUpdateDTO.price())
                .inventory(productUpdateDTO.inventory())
                .category(productUpdateDTO.category())
                .build();
        return productRepository.save(product);
    }

    public Product delete(String id, ProductDTO productDTO) {
        Product product = findById(id);
        hasProduct(id);
        productRepository.delete(product);
        return product;
    }

    private Product findById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Product.class.getName()));
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    private boolean isCount() {
        return productRepository.count() > 0;
    }

    private void hasProduct(String id) {
        if (!productRepository.existsById(id)) {
            throw new NotFoundException(Product.class.getName());
        }
    }

}
