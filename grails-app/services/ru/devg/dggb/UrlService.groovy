package ru.devg.dggb

import org.springframework.web.context.request.RequestContextHolder as RCH

class UrlService {

    boolean transactional = false

    String getRawUrl() {
        RCH.getRequestAttributes().getRequest().forwardURI
    }

    String getUrl() {
        return removeTrailingSlash(getRawUrl())
    }
    String getUrl(attrs) {
        String url
        if(attrs == null || attrs['url'] == null) {
            url = getRawUrl()
        } else {
            url = attrs['url']
        }
        return removeTrailingSlash(url)
    }

    private String removeTrailingSlash(String url) {
        if (url.length() > 0 && url.lastIndexOf('/') == url.length() - 1) {
            url = url.substring(0, url.length() - 1)
        }
        return url
    }
}
