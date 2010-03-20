package ru.devg.dggb

class EntriesTagLib {
    def namespace = 'dggb'

    def entryService
    def urlService

    def entry = {
        attrs ->
        String url = urlService.getUrl(attrs)
        Entry entry = entryService.getEntry(url)

        def urlTokens = url.tokenize('/')

        def prevUrl = '/'
        def links = urlTokens.collect {"<a href=\"" + (prevUrl += it + '/') + "\">$it</a>"}

        out << "<header><h1>${entry.properties.title}</h1>"
        out << '<span><a href="/">~</a>/' << links.join('/') << '</span>'
        out << "</header><section>${entry.properties.text}</section>"


    }
}
