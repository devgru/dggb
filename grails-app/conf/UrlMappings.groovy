class UrlMappings {
    static mappings = {
        "/$controller/$id?" (action: 'index')

         "/$page"(action: 'index', controller: 'main')

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/error')

    }
}
