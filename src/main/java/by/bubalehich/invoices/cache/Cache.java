package by.bubalehich.invoices.cache;

public interface Cache<K, V> {
    V get(K key);

    void put (K key, V value);

    V remove(K key);
}
