package org.acme.getting.started;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class FruitRepository implements PanacheRepository<Fruit> {
    public List<Fruit> findBySeason(String season) {
        return find("season", season).list();
    }
}
