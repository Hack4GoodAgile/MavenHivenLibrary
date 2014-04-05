package loaders;

public interface Loader<Type> {
    public Type load();
    public Type load(String string);
}
