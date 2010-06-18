package ru.devg.dggb

class MainController {

    Entry entry

    def entryService
    def urlService

    def url

    def index = {
        url = urlService.getUrl()
        entry = entryService.entry

        if(entry == null) {
            render(view: '/error', status: 404)
            return
        }

        response.addDateHeader 'Last-Modified' , entry.file.lastModified()
        if (entry['custom layout']) {
            render(view: 'empty')
        } else if (entry instanceof Directory) {
            render(view: 'directory')
        } else if (entry instanceof Page) {
            render(view: 'page')
        }
    }
}
