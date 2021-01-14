package com.example.myapplication2.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ElementoViewModel extends AndroidViewModel{
    ElementoRepo elementoRepo;

    MutableLiveData<List<ElementoReceta>> listElementosMutableLiveData = new MutableLiveData<List<ElementoReceta>>();

    public ElementoViewModel(@NonNull Application application) {
        super(application);

        elementoRepo = new ElementoRepo();

        listElementosMutableLiveData.setValue(elementoRepo.obtener());
    }

    MutableLiveData<List<ElementoReceta>> obtener(){
        return listElementosMutableLiveData;
    }

    void insertar(ElementoReceta elemento){
        elementoRepo.insertar(elemento, new ElementoRepo.Callback() {

            @Override
            public void cuandoFinalice(List<ElementoReceta> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }

    void eliminar(ElementoReceta elemento){
        elementoRepo.eliminar(elemento, new ElementoRepo.Callback() {
            @Override
            public void cuandoFinalice(List<ElementoReceta> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }

    void actualizar(ElementoReceta elemento, float valoracion){
        elementoRepo.actualizar(elemento, valoracion, new ElementoRepo.Callback() {
            @Override
            public void cuandoFinalice(List<ElementoReceta> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }
}
