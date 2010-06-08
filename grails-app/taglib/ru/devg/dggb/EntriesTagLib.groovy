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

        out << "<header><h1>${entry.properties.title}</h1>"
        out << '<span><a href="/">~</a>/' << links.join('/') << '</span>'
        String text = entry.properties.text
        if (entry['markdown']) text = markdownService.markdown(text)
        out << "</header><section>$text</section>"

    }

    def rawEntry = {
        attrs ->

        Entry entry = entryService.entry
        String text = entry.properties.text
        if (entry['markdown']) text = mp.markdown(text)
        out << text
    }

    def directoryListing = {
        attrs ->
        //noinspection GroovyAssignabilityCheck
        Directory directory = entryService.entry
        Set<Entry> children = directory.children

        out << '<article><header><h1>Список файлов</h1></header>'
        out << '<section><ul>'
        children.each {
            out << "<li><a href=\"${it.url}\">${it['title']}</a></li>"
        }
        out << '</ul></section> </article>'
    }

}
