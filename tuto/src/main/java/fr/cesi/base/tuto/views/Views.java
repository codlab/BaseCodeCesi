package fr.cesi.base.tuto.views;

import org.junit.Assert;

import fr.cesi.base.tuto.abstracts.AbstractExercise;

/**
 * Dans cette exercice, il faut définir le contenu des méthodes pour
 * tester la parité ou non d'un nombre donné
 */

public class Views extends AbstractExercise {

    private View mainView;
    private View subView;
    private View unlinkedView;

    /**
     * Implementez dans cette méthode, la logique qui va vous permettre d'initialiser une vue
     * On imagine dans cet exercice, qu'il vous est donné un framework vous permettant de manipuler
     * un objet DOM directement depuis java
     * <p>
     * pour information, voici une partie de la hiérarchie de cet object DOM :
     * <body>
     * <div id="mainView">
     * <form>
     * <input type="button" id="subView" />
     * </form>
     * </div>
     * <div id="unlinkedView">
     * </div>
     * </body>
     * <p>
     * L'exercice sera résolu lorsque les variables de l'instance de la classe seront définies correctes
     */
    public void create() {

    }

    @Override
    public boolean startExercise() {

        //editez le contenu de cette méthode :
        create();

        Assert.assertNotNull(mainView);
        Assert.assertNotNull(subView);
        Assert.assertNotNull(unlinkedView);
        return true;
    }


    public class View {
        public boolean isValid() {
            return true;
        }
    }

    private View inflate(String name) {
        switch (name) {
            case "mainView":
                return new View();
            case "unlinkedView":
                return new View();
        }
        return null;
    }

    private View retrieveView(View root, String name) {
        switch (name) {
            case "subView":
                return new View();
        }
        return null;
    }

}
