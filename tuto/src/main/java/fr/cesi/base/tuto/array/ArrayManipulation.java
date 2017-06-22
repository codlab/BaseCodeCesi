package fr.cesi.base.tuto.array;

import org.junit.Assert;

import fr.cesi.base.tuto.abstracts.AbstractExercise;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by kevinleperf on 22/06/2017.
 */

public class ArrayManipulation extends AbstractExercise {


    /**
     * Modifiez cette méthode pour que le tableau array ait une taille égale à length
     */
    private int[] instantiateArrayExercice(int length) {
        int[] array = null;

        throw new NotImplementedException();
    }

    /**
     * Modifiez cette méthode pour que le tableau que vous souhaitiez faire possède
     * à une case donnée une valeur égale à son index
     */
    private int[] instantiateArrayWithValues(int length) {
        int array[] = null;
        //mettre la réponse ici

        throw new NotImplementedException();
    }

    @Override
    public boolean startExercise() {

        int[] array = instantiateArrayExercice(40);
        Assert.assertEquals(array.length, 40);


        array = instantiateArrayWithValues(100);
        Assert.assertEquals(0, array[0]);
        for(int i = 1; i < 100; i++) {
            Assert.assertEquals(array[i - 1] + 1, array[i]);
        }


        return true;
    }
}
