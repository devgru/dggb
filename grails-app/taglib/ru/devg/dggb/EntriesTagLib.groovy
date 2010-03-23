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
        Directory parent = directory.parent

        out << "<a href=\"${parent.url}\">на уровень выше</a>"
        children.each {
            out << "<a href=\"${it.url}\">${it['title']}</a>"
        }
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
