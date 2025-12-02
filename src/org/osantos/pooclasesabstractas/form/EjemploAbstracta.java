package org.osantos.pooclasesabstractas.form;

import org.osantos.pooclasesabstractas.form.elementos.*;
import org.osantos.pooclasesabstractas.form.elementos.select.Opcion;
import org.osantos.pooclasesabstractas.form.validador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploAbstracta {
    public static void main(String[] args) {
        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelecForm lenguaje = new SelecForm("Lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP"));

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name= '" + this.nombre
                        + "' value= '" + this.valor
                        + "'>";
            }
        };

        saludar.setValor("Este valor esta deshabilitado");

        username.setValor("");
        password.setValor("contr");
        email.setValor("johngmail.com");
        edad.setValor("26l");
        experiencia.setValor("... más de 10 anios de experiencia");
        java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje, saludar);

//        List<ElementoForm> elementos = new ArrayList<>();
//        elementos.add(username);
//        elementos.add(password);
//        elementos.add(email);
//        elementos.add(edad);
//        elementos.add(experiencia);
//        elementos.add(lenguaje);

        for (ElementoForm e : elementos) {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }

        for (ElementoForm e : elementos) {
            if (!e.esValido()) {
                e.getErrores().forEach(System.out::println);
            }
        }

    }
}
