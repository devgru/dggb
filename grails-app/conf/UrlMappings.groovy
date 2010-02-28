class UrlMappings {
    static mappings = {
        "/$controller/$id?" (action: 'view')

        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }




        "/" (view: "/index")
        "500" (view: '/error')
    }
}
