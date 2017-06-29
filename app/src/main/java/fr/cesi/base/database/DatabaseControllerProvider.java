package fr.cesi.base.database;

import java.util.HashMap;

/**
 * Cette classe permet d'instancier simplement des "provider" de gestionnaire de modeles
 *
 * Exemple avec les Tempo :
 * BarController controller = DatabaseControllerProvider.getController(BarController.class);
 *
 * List<TempoModel> tempo_list = controller.listAll();
 */

public class DatabaseControllerProvider {

    private static DatabaseControllerProvider sInstance = new DatabaseControllerProvider();

    public static DatabaseControllerProvider getInstance() {
        return sInstance;
    }

    private HashMap<Class, AbstractModelController> mHashMap;

    private DatabaseControllerProvider() {
        mHashMap = new HashMap<>();
    }

    public <T extends AbstractModelController> T getController(Class<T> klass) {
        T item = (T) mHashMap.get(klass);
        if(item == null) try {
            item = klass.newInstance();
            mHashMap.put(klass, item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

}
