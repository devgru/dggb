package ru.devg.dggb

class MainController {

    String currentDirectory
    Entry entry

    def entryService
    def urlService

    def index = {
        def url = urlService.getUrl()
        entry = entryService.getEntry(url)

        if (entry instanceof Directory) {
            currentDirectory = entry.url.replaceFirst('/', '')
            render(view: 'directory')
        } else if (entry instanceof Page) {
            currentDirectory = entry.parent.url.replaceFirst('/', '')
            render(view: 'page')
        } else {
            render(view: '/error', status: 404)
        }
    }
}
