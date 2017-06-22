package fr.cesi.base.tuto;

import java.util.ArrayList;
import java.util.List;

import fr.cesi.base.tuto.abstracts.AbstractExercise;
import fr.cesi.base.tuto.array.ArrayManipulation;
import fr.cesi.base.tuto.array.ArrayObjectManipulation;
import fr.cesi.base.tuto.klass.ClassAbstract;
import fr.cesi.base.tuto.klass.ClassImplements;
import fr.cesi.base.tuto.numbers.Manipulation;
import fr.cesi.base.tuto.numbers.Sums;
import fr.cesi.base.tuto.views.Views;

/**
 * Created by kevinleperf on 22/06/2017.
 */

public class MainClass {

    public static void main(String[] argv) {
        List<AbstractExercise> list = new ArrayList<>();
        System.out.println("tuto started ...");

        //definition des exercices à charger
        list.add(new Sums());
        list.add(new Manipulation());
        list.add(new ClassAbstract());
        list.add(new ClassImplements());
        list.add(new Views());
        list.add(new ArrayManipulation());
        list.add(new ArrayObjectManipulation());


        //itération pour les valider
        for (AbstractExercise exercise : list) {
            exercise.startExercise();
        }

        System.out.println("tuto ended ...");
    }
}
