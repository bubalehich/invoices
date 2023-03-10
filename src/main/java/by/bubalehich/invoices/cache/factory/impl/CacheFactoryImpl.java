package by.bubalehich.invoices.cache.factory.impl;

import by.bubalehich.invoices.cache.Cache;
import by.bubalehich.invoices.cache.factory.CacheFactory;
import by.bubalehich.invoices.cache.impl.LFUCache;
import by.bubalehich.invoices.cache.impl.LRUCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class CacheFactoryImpl<K, V> implements CacheFactory<K, V> {

    @Value("${cache.algorithm}")
    private String algorithm;

    @Value("${cache.size.max}")
    private int size;

    @Override
    public Cache<K, V> create() {
        switch (algorithm) {
            case "LFU" -> new LFUCache<>(size);
            case "LRU" -> new LRUCache<>(size);
            default -> throw new RuntimeException();
        }
        throw new RuntimeException("Wrong cache algorithm.");
    }
}
