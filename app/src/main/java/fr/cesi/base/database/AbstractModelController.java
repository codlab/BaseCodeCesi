package fr.cesi.base.database;

import android.support.v4.util.LruCache;

import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Cette classe permet d'abstraire un peu plus la récupération et le stocjage avec un cache
 * des objets d'une classe T qui étendrait BaseModel
 *
 * la notation T permet de génériser le code à l'ensemble des modeles qui pourraient être écris.
 *
 * Les modèles pouvent être par exemple :
 * - des enregistrements d'horaires,
 * - des tempos
 * - des notes
 * - des utilisateurs
 * etc...
 *
 * Cette classe ext abstraite pour notamment obliger à définir :
 * - la colonne qui sert de clé primaire
 * - un objet "class" qui lui permettra de créer de nouvelles instances dynamiquement
 */

public abstract class AbstractModelController<T extends BaseModel> {

    private LruCache<Long, T> mCache;

    protected AbstractModelController() {
        mCache = new LruCache<>(200);
    }

    public T getItemFrom(long id) {
        T object = getItemFromCache(id);

        if (object == null) {
            object = getItemFromDatabase(id);
            if (object != null) putItemInCache(id, object);
        }

        return object;
    }


    public void saveItem(long id, T object) {
        putItemInCache(id, object);
        object.save();
    }

    public void deleteObject(long id, T object) {
        mCache.remove(id);
        object.delete();
    }

    protected abstract Property getColumnId();

    protected abstract Class<? extends BaseModel> getTableClass();

    public List<T> listAll() {
        return (List<T>) new Select()
                .from(getTableClass())
                .queryList();
    }

    protected void putItemInCache(long id, T object) {
        mCache.put(id, object);
    }

    protected T getItemFromCache(long id) {
        return mCache.get(id);
    }

    protected T getItemFromDatabase(long id) {
        return (T) new Select()
                .from(getTableClass())
                .where(getColumnId().eq(id))
                .querySingle();
    }
}
