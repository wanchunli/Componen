package com.anso.base.autoservice;

import java.util.ServiceLoader;

/**
 *
 IWebViewService iWebViewService = BaseServiceLoader.load(IWebViewService.class);
 if (iWebViewService != null) {
 iWebViewService.startWebViewActivity(MainActivity.this, "https:www.baidu.com", "百度", false);
 }
 */
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
