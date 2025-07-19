package es.cresdev.patterns.command.controlremoto;

import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
public class ControlRemoto {

    private final ArrayList<Comando> comandoPrevio = new ArrayList<>();
    private final Map<Integer, Comando> comandos;

    public ControlRemoto() {
        this.comandos = new HashMap<>();
    }

    public void asignarComando(Integer boton, Comando comando) {
        this.comandos.put(boton, comando);
    }

    public void quitarComando(Integer boton) {
        this.comandos.remove(boton);
    }

    public String presionarBoton(Integer boton) {
        if (!comandos.containsKey(boton)) {
            throw new IllegalArgumentException("No se ha programado el boton " + boton);
        }
        this.comandoPrevio.add(this.comandos.get(boton));
        return this.comandos.get(boton).ejecutar();
    }

    public String deshacerUltimoComando() {
        if (comandoPrevio.isEmpty()) {
            throw new IllegalStateException("No hay comando previo");
        }
        return comandoPrevio.remove(comandoPrevio.size() - 1).deshacer();
    }

}
