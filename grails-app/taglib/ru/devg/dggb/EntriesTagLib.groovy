package ru.devg.dggb

import com.petebevin.markdown.MarkdownProcessor

class EntriesTagLib {
    def namespace = 'dggb'

    def entryService
    def urlService

    MarkdownProcessor mp = new MarkdownProcessor();

    def entry = {
        attrs ->
        String url = urlService.getUrl(attrs)
        Entry entry = entryService.getEntry(url)

        def urlTokens = url.tokenize('/')

        def prevUrl = '/'
        def links = urlTokens.collect {"<a href=\"" + (prevUrl += it + '/') + "\">$it</a>"}

        out << "<header><h1>${entry.properties.title}</h1>"
        out << '<span><a href="/">~</a>/' << links.join('/') << '</span>'
        String text = entry.properties.text
        if (entry['markdown']) text = mp.markdown(text)
        out << "</header><section>$text</section>"

    }

    def breadcrumbs = {
        attrs ->
        String url = urlService.getUrl(attrs)

        def urlTokens = url.tokenize('/')

        def prevUrl = '/'
        def links = urlTokens.collect {"<a href=\"" + (prevUrl += it + '/') + "\">$it</a>"}

        out << '<span class="blue">'
        out << '<a href="/">~</a>'
        if(links){
            out << '/'
            out << links.join('/')
        }
        out << '</span>'
        out << '$'

    }

    def directoryListing = {
        attrs ->
        String url = urlService.getUrl(attrs)

        //noinspection GroovyAssignabilityCheck
        Directory directory = entryService.getEntry(url)
        Set<Entry> children = directory.children

        out << '<article><header><h1>Список файлов</h1></header>'
        out << '<section><ul>'
        children.each {
            out << "<li><a href=\"${it.url}\">${it['title']}</a></li>"
        }
        out << '</ul></section> </article>'
    }

    def listDirectory = {
        attrs ->
        String url = urlService.getUrl(attrs)

        //noinspection GroovyAssignabilityCheck
        Directory directory = entryService.getEntry(url)
        directory.subdirs.each {
            out << "<li class=\"blue\"><a href=\"${it.url}\">${it['title']}</a></li>"
        }
    }
}
