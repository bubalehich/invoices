package by.bubalehich.invoices;

import by.bubalehich.invoices.cache.Cache;
import by.bubalehich.invoices.cache.factory.CacheFactory;
import by.bubalehich.invoices.entity.base.BaseEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InvoicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(InvoicesApplication.class, args);
    }

    @Bean
    public Cache<Number, BaseEntity> getCache(){
        return new CacheFactory<Number,BaseEntity>().create();
    }
}
