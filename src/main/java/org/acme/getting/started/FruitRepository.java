package org.acme.getting.started;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public final class FruitRepository implements PanacheRepository<Fruit> {
    public List<Fruit> findBySeason(String season) {
        return find("season", season).list();
    }
}
