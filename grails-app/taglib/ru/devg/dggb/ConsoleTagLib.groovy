package ru.devg.dggb

class ConsoleTagLib {

    def namespace = 'dggb'
    def urlService
    def entryService

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

        out << "<span class=\"blue\"><a href=\"${directory.url}\">.</a></span> "
        out << "<span class=\"blue\"><a href=\"${parent.url}\">..</a></span> "
        children.each {
            if(it instanceof Directory)
                out << " <span class=\"blue\"><a href=\"${it.url}\">${it.name}</a></span> "
            else
                out << " <a href=\"${it.url}\">${it.name}</a> "
        }

    }

    def listDirectory = {
        attrs ->
        String url = urlService.getUrl(attrs)

        //noinspection GroovyAssignabilityCheck
        Directory directory = entryService.getEntry(url)
        Set<Entry> children = directory.subdirs

        children.each {
            if(it instanceof Directory)
                out << "<li class=\"blue\"><a href=\"${it.url}\">${it.name}</a></li>"
            else
                out << "<li><a href=\"${it.url}\">${it.name}</a></li>"
        }
    }
}
