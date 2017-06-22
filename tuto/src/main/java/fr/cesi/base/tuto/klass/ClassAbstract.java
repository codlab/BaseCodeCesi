package fr.cesi.base.tuto.klass;

import fr.cesi.base.tuto.abstracts.AbstractExercise;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by kevinleperf on 22/06/2017.
 */

public class ClassAbstract extends AbstractExercise{

    /**
     * Implémentez cette méthode qui devra utiliser la classe abstraite AbstractProviderVolumetric
     * pour renvoyer un objet instancié d'une classe que vous choisirez.
     *
     * Cette classe devra entre autre définir au moins 2 méthodes permettant de calculer
     * le volume et la surface de cet objet
     */
    private IProvideVolumetric implementsProvideVolumetricUsingPseudoClass() {
        throw new NotImplementedException();
    }

    /**
     * Implémentez cette méthode qui devra utiliser la classe abstraite AbstractProviderVolumetric
     * pour renvoyer un objet instancié d'une pseudo classe que vous implémenterez "à chaud"
     *
     * Cette pseudo classe devra entre autre définir au moins 2 méthodes permettant de calculer
     * le volume et la surface de cet objet
     */
    private IProvideVolumetric implementsProvideVolumetricWithClass() {
        throw new NotImplementedException();
    }

    @Override
    public boolean startExercise() {

        IProvideVolumetric instance = null;

        instance = implementsProvideVolumetricWithClass();
        System.out.println("volume 1 := " + instance.getVolume());
        System.out.println("surface 1 := " + instance.getSurface());

        instance = implementsProvideVolumetricUsingPseudoClass();
        System.out.println("volume 2 := " + instance.getVolume());
        System.out.println("surface 2 := " + instance.getSurface());

        return true;
    }

    private abstract class IProvideVolumetric {
        abstract double getVolume();

        abstract double getSurface();
    }
}
