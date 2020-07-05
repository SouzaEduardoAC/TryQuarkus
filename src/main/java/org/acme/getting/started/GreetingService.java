package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class GreetingService {
    public String greeting(String name) {
        return "hello " + name;
    }
}
