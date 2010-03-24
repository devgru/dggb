package ru.devg.dggb

class MainController {

    Entry entry

    def entryService
    def urlService

    def url

    def index = {
        url = urlService.getUrl()
        entry = entryService.getEntry(url)

        if (entry && entry['custom layout']) {
            render(view: 'empty')
        } else if (entry instanceof Directory) {
            render(view: 'directory')
        } else if (entry instanceof Page) {
            render(view: 'page')
        } else {
            render(view: '/error', status: 404)
        }
    }
}
