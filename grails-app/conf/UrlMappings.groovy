class UrlMappings {
    static excludes = ["/images/*", "/css/*", "/fonts/*", "/WEB-INF/*", "js/*"]

    static mappings = {

        "/$page**"(action: 'index', controller: 'main')

        "/"(view: '/index')
        "500"(view: '/error')
        "404"(controller: 'main')

    }
}
