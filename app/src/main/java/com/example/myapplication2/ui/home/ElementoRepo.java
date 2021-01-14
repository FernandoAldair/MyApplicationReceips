package com.example.myapplication2.ui.home;

import java.util.ArrayList;
import java.util.List;

public class ElementoRepo {

        List<ElementoReceta> elementos = new ArrayList<>();

        interface Callback {
            void cuandoFinalice(List<ElementoReceta> elementos);
        }

        ElementoRepo(){
            elementos.add(new ElementoReceta("Elemento químico", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción química, en otras más simples. Pueden existir dos átomos de un mismo elemento con características distintas y, en el caso de que estos posean número másico distinto, pertenecen al mismo elemento pero en lo que se conoce como uno de sus isótopos."));
            elementos.add(new ElementoReceta("Elemento de un conjunto", "En teoría de conjuntos, un elemento o miembro de un conjunto (o familia de conjuntos) es un objeto que forma parte de ese conjunto (o familia)."));
            elementos.add(new ElementoReceta("Elemento sintético", "En química, un elemento sintético es un elemento químico que no aparece de forma natural en la Tierra, y solo puede ser creado artificialmente."));
            elementos.add(new ElementoReceta("Elemento algebraico", "En matemáticas, más concretamente en álgebra abstracta y teoría de cuerpos, se dice que un elemento es algebraico sobre un cuerpo si es raíz de algún polinomio con coeficientes en dicho cuerpo. Los elementos algebraicos sobre el cuerpo de los números racionales reciben el nombre de números algebraicos."));
            elementos.add(new ElementoReceta("Elementos de la naturaleza","Los cuatro o cinco elementos de la naturaleza —normalmente agua, tierra, fuego y aire, a los que se añade la quintaesencia o éter— eran, para muchas doctrinas antiguas, los constituyentes básicos de la materia y explicaban el comportamiento de la naturaleza. El modelo estuvo vigente hasta que la ciencia moderna empezó a desentrañar los elementos y reacciones químicas."));
            elementos.add(new ElementoReceta("Elemento constructivo","Un elemento constructivo es cada uno de los componentes materiales que integran una obra de construcción. Se suelen clasificar en estructurales y compartimentadores."));
        }

        List<ElementoReceta> obtener() {
            return elementos;
        }

        void insertar(ElementoReceta elemento, Callback callback){
            elementos.add(elemento);
            callback.cuandoFinalice(elementos);
        }

        void eliminar(ElementoReceta elemento, Callback callback) {
            elementos.remove(elemento);
            callback.cuandoFinalice(elementos);
        }

        void actualizar(ElementoReceta elemento, float valoracion, Callback callback) {
            elemento.valoracion = valoracion;
            callback.cuandoFinalice(elementos);
        }

}
