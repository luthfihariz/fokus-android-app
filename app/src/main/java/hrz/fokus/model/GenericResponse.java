package hrz.fokus.model;

/**
 * Created by Luthfi Haris on 02/10/2016.
 */

public class GenericResponse<T> {
    T items;
    Metadata metadata;

    public T getItems() {
        return items;
    }

    public Metadata getMetadata() {
        return metadata;
    }
}
