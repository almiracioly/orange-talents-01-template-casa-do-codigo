package br.com.zup.casacodigo.author.newauthor;

import java.util.ArrayList;
import java.util.List;

public class NewAuthorValidationErrorOutput {
    private List<String> globalErrorMessages = new ArrayList<>();
    private List<NewAuthorFieldErrorOutput> fieldsErrorOutput = new ArrayList<>();

    public void addError(String message){
        globalErrorMessages.add(message);
    }

    public void addFieldError(String field, String message){
        NewAuthorFieldErrorOutput fieldErrorOutput = new NewAuthorFieldErrorOutput(field, message);
        fieldsErrorOutput.add(fieldErrorOutput);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<NewAuthorFieldErrorOutput> getFieldsErrorOutput() {
        return fieldsErrorOutput;
    }
}
