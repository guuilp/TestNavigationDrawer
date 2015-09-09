package br.com.lp.guilherme.testnavigationdrawer;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guilherme on 06-Sep-15.
 */
public class HomeService {

    public static List<Home> getCarros(Context context){
        List<String> materia = new ArrayList<String>();
        materia.add("Português");
        materia.add("História");
        materia.add("Geografia");
        List<Home> materias = new ArrayList<Home>();
        for (int i = 0; i < 3; i++) {
            Home c = new Home();
            c.nome = "Disciplina: " + materia.get(i);
            c.nota = "Nota: " + i;
            materias.add(c);
        }
        return materias;
    }
}