package org.osantos.pooclasesabstractas.form.validador;

public class EmailValidador extends Validador {
    protected String mensaje = "El formato de email es invalido";
    private final static String EMAIL_PATRON = "^(.+)@(.+)$";

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {

        return valor.matches(EMAIL_PATRON);
    }
}
