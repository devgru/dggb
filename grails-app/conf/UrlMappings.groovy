class UrlMappings {
    static mappings = {

        "/$page"(action: 'index', controller: 'main')
        "/articles/*"(action: 'index', controller: 'main')
        "/articles/*/*"(action: 'index', controller: 'main')

        "/$controller/$id?"(action: 'index')

        "/"(view: '/index')
        "500"(view: '/error')
        "404"(controller: 'main')

    }
}
