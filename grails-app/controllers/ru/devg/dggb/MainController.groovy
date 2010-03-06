package ru.devg.dggb

class MainController {

    def uri

    def index = {
        uri = request.forwardURI
        
    }
}
