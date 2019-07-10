package utfpr.arquitetura1.antecipacao.exceptions;

public class EmptyFieldException extends Exception {

    public EmptyFieldException(String field) {
        super(field + " cannot be empty");
    }
}
