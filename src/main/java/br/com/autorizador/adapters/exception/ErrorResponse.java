package br.com.autorizador.adapters.exception;

public class ErrorResponse {

    private Object object;

    public ErrorResponse() {
    }

    public ErrorResponse(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
