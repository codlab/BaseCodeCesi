package fr.cesi.base.tuto.array;

import org.junit.Assert;

import fr.cesi.base.tuto.abstracts.AbstractExercise;
import fr.cesi.base.tuto.views.Views;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by kevinleperf on 22/06/2017.
 */

public class ArrayObjectManipulation extends AbstractExercise {


    /**
     * Modifiez cette méthode pour que le tableau array ait une taille égale à length
     * et quil possède des objets View valides !
     */
    private Views.View[] instantiateArrayExercice(int length) {
        Views.View array[] = null;

        //mettre la réponse ici
        throw new NotImplementedException();
    }

    @Override
    public boolean startExercise() {

        Views.View[] array = instantiateArrayExercice(40);


        Assert.assertFalse(array == null || array.length == 0);
        Assert.assertEquals(array.length, 40);
        for (Views.View view : array){
            Assert.assertTrue(view.isValid());
        }

        return true;
    }
}
