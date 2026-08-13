package br.com.viniciusacoelho.product_management.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductUpdateDTO(

        @Size(min = 3, max = 50, message = "Name...")
        String name,

        @Size(min = 3, max = 50, message = "Price...")
        @Positive(message = "The price should be positive.")
        BigDecimal price,

        @Size(min = 3, max = 50, message = "Price...")
        @Positive(message = "The price should be positive.")
        Double inventory,

        @Size(min = 3, max = 50, message = "Price...")
        String category) {

}
