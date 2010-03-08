package ru.devg.dggb

import org.springframework.web.context.request.RequestContextHolder as RCH

class UrlService {

    boolean transactional = false

    String getRawUrl() {
        RCH.getRequestAttributes().getRequest().forwardURI
    }

    String getUrl(attrs) {
        String url = attrs['url']
        if(url == null) {
            return getUrl()
        }
        url = removeTrailingSlash(url)
        return url
    }

    String getUrl() {
        String url = getRawUrl()
        url = removeTrailingSlash(url)
        return url
    }

    private String removeTrailingSlash(String url) {
        if (url.length() > 0 && url.lastIndexOf('/') == url.length() - 1) {
            url = url.substring(0, url.length() - 1)
        }
        return url
    }
}
