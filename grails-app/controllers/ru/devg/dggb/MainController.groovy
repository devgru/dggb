package ru.devg.dggb

class MainController {

    Entry entry

    def entryService
    def urlService

    def url

    def index = {
        url = urlService.getUrl()
        entry = entryService.getEntry(url)

        response.setHeader("X-XRDS-Location", "http://openid.yandex.ru/devg-ru/yadis/")

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
