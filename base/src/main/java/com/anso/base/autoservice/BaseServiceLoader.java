package com.anso.base.autoservice;

import java.util.ServiceLoader;

public final class BaseServiceLoader {
    private BaseServiceLoader() {
    }

    public static <T> T load(Class<T> service) {
        try {
            return ServiceLoader.load(service).iterator().next();
        } catch (Exception e) {
            return null;
        }
    }
}
