package org.osantos.pooclasesabstractas.form.elementos;

import org.osantos.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelecForm extends ElementoForm {

    private List<Opcion> opciones;

    public SelecForm(String nombre) {
        super(nombre);
        //Lista de tipo arreglos
        this.opciones = new ArrayList<Opcion>();
    }

    public SelecForm(String nombre, List<Opcion> opciones) {
        super(nombre);
        this.opciones = opciones;
    }

    public SelecForm addOpcion(Opcion opcion) {
        this.opciones.add(opcion);
        return this;
    }


    @Override
    public String dibujarHtml() {
        StringBuilder stringB = new StringBuilder("<select ");
        stringB.append("name= '").append(this.nombre)
                .append("'>");
        for (Opcion elemento : this.opciones) {
            stringB.append("\n<option value= '")
                    .append(elemento.getValor())
                    .append("'");
            if (elemento.isSelected()) {
                stringB.append(" selected");
                this.valor = elemento.getValor();
            }
            stringB.append(">")
                    .append(elemento.getNombre())
                    .append("</option>");
        }
        stringB.append("</select>");

        return stringB.toString();
    }
}
