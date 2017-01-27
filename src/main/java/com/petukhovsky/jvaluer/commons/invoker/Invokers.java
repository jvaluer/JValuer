package com.petukhovsky.jvaluer.commons.invoker;

import java.util.Map;

/**
 * Created by arthur on 24.12.16.
 */
public class Invokers {
    private final Invoker def;
    private final Map<String, Invoker> map;

    public Invokers(Map<String, Invoker> map, Invoker def) {
        this.map = map;
        this.def = def;
    }

    public Invoker get(String name) {
        return map.get(name);
    }

    public Invoker getDefault() {
        return def;
    }
}
