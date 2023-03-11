package by.bubalehich.invoices.cache.factory;

import by.bubalehich.invoices.cache.Cache;
import by.bubalehich.invoices.cache.impl.LFUCache;
import by.bubalehich.invoices.cache.impl.LRUCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class CacheFactory<K, V> {

    @Value("${cache.algorithm}")
    private String algorithm;

    @Value("${cache.size.max}")
    private int size;

    public Cache<K, V> create() {
        switch (algorithm) {
            case "LFU" -> new LFUCache<>(size);
            case "LRU" -> new LRUCache<>(size);
            default -> throw new RuntimeException();
        }
        throw new RuntimeException("Wrong cache algorithm.");
    }
}
