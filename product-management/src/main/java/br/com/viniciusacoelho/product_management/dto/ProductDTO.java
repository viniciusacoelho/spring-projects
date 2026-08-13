package br.com.viniciusacoelho.product_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductDTO(

        @NotBlank(message = "Name shouldn't be blank.")
        @Size(min = 3, max = 50, message = "Name...")
        String name,

        @NotNull(message = "Price shouldn't be null.")
        @Positive(message = "The price should be positive.")
        BigDecimal price,

        @NotNull(message = "Name shouldn't be null.")
        @Positive(message = "The inventory should be positive.")
        Double inventory,

        @NotBlank(message = "Name shouldn't be blank.")
        @Size(min = 3, max = 50, message = "Name...")
        String category) {

}
