package fr.cesi.base.tuto.numbers;

import org.junit.Assert;

import fr.cesi.base.tuto.abstracts.AbstractExercise;
import sun.jvm.hotspot.jdi.NonConcreteMethodImpl;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Dans cette exercice, il faut définir le contenu des méthodes pour
 * tester la parité ou non d'un nombre donné
 */

public class Sums extends AbstractExercise {

    /**
     * Implémentez cette méthode qui devra renvoyer la somme
     * des entiers de 1 à max pour réussir l'exercice
     * <p>
     * utilisez uniquement un for
     */
    private long sumUntilWithFor(long max) {
        throw new NoSuchMethodError();
    }

    /**
     * Implémentez cette méthode qui devra renvoyer la somme
     * des entiers de 1 à max pour réussir l'exercice
     * <p>
     * utilisez uniquement un while
     */
    private long sumUntilWithWhile(long max) {
        throw new NoSuchMethodError();
    }

    @Override
    public boolean startExercise() {
        checkEquals(20l);
        checkEquals(3423l);
        checkEquals(29248l);
        checkEquals(3525234l);
        return true;
    }

    private void checkEquals(long max) {
        System.out.println(sumFast(max) + " " + sumUntilWithFor(max));
        Assert.assertEquals(sumFast(max), sumUntilWithFor(max));
        Assert.assertEquals(sumFast(max), sumUntilWithWhile(max));
    }

    private long sumFast(long max) {
        return max * (max - 1) / 2;
    }
}
