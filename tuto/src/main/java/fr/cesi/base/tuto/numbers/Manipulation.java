package fr.cesi.base.tuto.numbers;

import org.junit.Assert;

import fr.cesi.base.tuto.abstracts.AbstractExercise;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Dans cette exercice, il faut définir le contenu des méthodes pour
 * tester la parité ou non d'un nombre donné
 */

public class Manipulation extends AbstractExercise {

    private boolean isEven(float number) {
        throw new NoSuchMethodError();
    }

    private boolean isOdd(int number) {
        throw new NoSuchMethodError();
    }

    private boolean isEven(long number) {
        throw new NoSuchMethodError();
    }

    private boolean isOdd(double number) {
        throw new NoSuchMethodError();
    }

    @Override
    public boolean startExercise() {
        Assert.assertTrue(isEven(0));
        Assert.assertTrue(isEven(21));
        Assert.assertTrue(isOdd(41));
        Assert.assertTrue(isEven(62));
        Assert.assertFalse(isOdd(33688));
        Assert.assertTrue(isOdd(72651));

        return true;
    }
}
