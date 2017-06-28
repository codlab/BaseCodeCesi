package fr.cesi.base.tuto.klass;

import fr.cesi.base.tuto.abstracts.AbstractExercise;

/**
 * Created by kevinleperf on 22/06/2017.
 */

public class ClassImplements extends AbstractExercise {

    /**
     * Implémentez cette méthode qui devra utiliser l'interface IProviderVolumetric
     * pour renvoyer un objet instancié d'une classe que vous choisirez.
     * <p>
     * Cette classe devra entre autre définir au moins 2 méthodes permettant de calculer
     * le volume et la surface de cet objet
     */
    private IProvideVolumetric implementsProvideVolumetricUsingPseudoClass() {
        throw new NoSuchMethodError();
    }

    /**
     * Implémentez cette méthode qui devra utiliser l'interface IProviderVolumetric
     * pour renvoyer un objet instancié d'une pseudo classe que vous implémenterez "à chaud"
     * <p>
     * Cette pseudo classe devra entre autre définir au moins 2 méthodes permettant de calculer
     * le volume et la surface de cet objet
     */
    private IProvideVolumetric implementsProvideVolumetricWithClass() {
        throw new NoSuchMethodError();
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

    private interface IProvideVolumetric {
        double getVolume();

        double getSurface();
    }
}
