package ru.devg.dggb

import org.springframework.web.context.request.RequestContextHolder as RCH

class UrlService {

    boolean transactional = false

    String getUrl() {
        String url = RCH.getRequestAttributes().getRequest().forwardURI
        removeTrailingSlash(url)
    }

    private String removeTrailingSlash(String url) {
        if (url.length() > 1 && url.lastIndexOf('/') == url.length() - 1) {
            url = url.substring(0, url.length() - 1)
        }
        url
    }
}
