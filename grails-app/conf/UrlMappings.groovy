class UrlMappings {
     static excludes = ["/images/*", "/css/**", "/WEB-INF/*"]

    static mappings = {

        "/$page**"(action: 'index', controller: 'main')

        "/"(view: '/index')
        "500"(view: '/error')
        "404"(controller: 'main')

    }
}
