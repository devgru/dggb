package ru.devg.dggb

class EntriesTagLib {
    def namespace = 'dggb'

    def markdownService
    def entryService
    def urlService

    def entry = {
        Entry entry = entryService.entry
        def urlTokens = urlService.url.tokenize('/')
        def prevUrl = '/'
        def links = urlTokens.collect {'<a href="' + (prevUrl += it + '/') + "\">$it</a>"}

        out << "<header><h1>${entry['title']}</h1>"
        out << '<span><a href="/">~</a>/' << links.join('/') << '</span>'
        String text = entry['text']
        if (entry['markdown']) text = markdownService.markdown(text)
        out << "</header><section>$text</section>"

    }

    def rawEntry = {
        attrs ->

        Entry entry = entryService.entry
        String text = entry['text']
        if (entry['markdown']) text = markdownService.markdown(text)
        out << text
    }

    def directoryListing = {
        attrs ->
        out << '<article><header><h1>Список файлов</h1></header>'
        out << '<section><ul>'
        entryService.entry.children.each {
            out << "<li><a href=\"${it.url}\">${it['title']}</a></li>"
        }
        out << '</ul></section> </article>'
    }

}
