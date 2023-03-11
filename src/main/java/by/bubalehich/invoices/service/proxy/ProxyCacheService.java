package by.bubalehich.invoices.service.proxy;

import by.bubalehich.invoices.cache.Cache;
import by.bubalehich.invoices.entity.base.BaseEntity;
import by.bubalehich.invoices.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@AllArgsConstructor
public class ProxyCacheService {
    protected ServiceInterface<Number, BaseEntity> service;
    protected Cache<Number, BaseEntity> cache;

    public BaseEntity get(Number id){
        var entity = cache.get(id);

        if(entity != null){
            return entity;
        }

        entity =  service.get(id);
        cache.put(entity.getId(), entity);
        return entity;
    }

    public void delete(Number id){
        service.delete(id);
        cache.remove(id);
    }

    public BaseEntity update (BaseEntity type){
        type = service.update(type);

        cache.remove(type.getId());
        cache.put(type.getId(), type);

        return type;
    }

    public BaseEntity create (BaseEntity type){
        var entity = service.create(type);
        cache.put(entity.getId(), entity);

        return entity;
    }
}
