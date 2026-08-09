package br.com.viniciusacoelho.project_name.exceptions;

public class AlreadyCreatedException extends RuntimeException {

    public AlreadyCreatedException(String attribute) {
        super(attribute + " já cadastrado.");
    }

}
