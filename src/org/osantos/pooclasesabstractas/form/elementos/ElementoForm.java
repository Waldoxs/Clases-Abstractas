package org.osantos.pooclasesabstractas.form.elementos;

import org.osantos.pooclasesabstractas.form.validador.LargoValidador;
import org.osantos.pooclasesabstractas.form.validador.Validador;
import org.osantos.pooclasesabstractas.form.validador.mensaje.IMensajeFormateable;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm {
    protected String valor;
    protected String nombre;

    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm addValidador(Validador validador){
        //Nota el ArrayList tiene el metodo de add() para guardar elementos de forma dinámica
        this.validadores.add(validador);
        return this; //Retorna el tipo mismo de clase
    }

    public List<String> getErrores() {
        return errores;
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean esValido(){
        for(Validador v: validadores){
            if(!v.esValido(valor)){
                if(v instanceof IMensajeFormateable){
                    this.errores.add(((IMensajeFormateable) v).getMensajeFormateado(this.nombre));
                }else {
                    this.errores.add(String.format(v.getMensaje(),this.nombre));
                }

            }
        }
        return this.errores.isEmpty();
    }

    abstract public String dibujarHtml();

}
