package by.bubalehich.invoices.cache.factory;

import by.bubalehich.invoices.cache.Cache;

public interface CacheFactory<K, V> {
    Cache<K, V> create();
}
