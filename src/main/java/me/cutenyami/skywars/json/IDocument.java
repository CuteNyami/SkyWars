package me.cutenyami.skywars.json;

public interface IDocument<D extends IDocument<?>> {

    D append(String key, Object value);

    D depend(String key);

    <T> T get(String key, Class<T> clazz);
}
