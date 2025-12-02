package org.osantos.pooclasesabstractas.form.validador;

public class LargoValidador extends Validador {

    protected String mensaje = "El campo %s debe tener mínimo %d caracteres y máximo %d caracteres";
    private int min;
    private int max = Integer.MAX_VALUE;

    public LargoValidador() {
    }

    public LargoValidador(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

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
        //Para asignar los valores que se definieron con los %d
        // this.mensaje = String.format(this.mensaje,this.min,this.max);
        if (valor == null) {
            return true;
        }

        int largo = valor.length();
        return (largo >= this.min && largo <= this.max);
    }

    public String getMensajeFormateado(String campo) {
        return this.mensaje = String.format(this.mensaje, campo, this.min, this.max);
    }
}
