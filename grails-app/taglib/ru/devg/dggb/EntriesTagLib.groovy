package ru.devg.dggb

class EntriesTagLib {
    def namespace = 'dggb'

    def entryService
    def urlService

    def entryText = {
        attrs ->
        String url = urlService.getUrl(attrs)
        out << entryService.getEntry(url).properties['Text']
    }
}
