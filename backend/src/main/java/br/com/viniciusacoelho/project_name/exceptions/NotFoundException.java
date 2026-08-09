package br.com.viniciusacoelho.project_name.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String entity) {
        super(entity + " não encontrado.");
    }

}
