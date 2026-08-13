package br.com.viniciusacoelho.product_management.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String name) {
        super(name + " not found.");
    }

}
