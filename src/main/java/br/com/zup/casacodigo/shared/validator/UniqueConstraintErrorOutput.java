package br.com.zup.casacodigo.shared.validator;

public class UniqueConstraintErrorOutput {
    private String message;

    public UniqueConstraintErrorOutput(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
