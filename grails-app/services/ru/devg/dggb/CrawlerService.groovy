package ru.devg.dggb

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class CrawlerService {

    boolean transactional = false

    static final File pagesHome = CH.config.dggb.pages.home as File   

    def initialCrawl() {
        pagesHome.eachDir {file -> crawlDirectory file, Directory.root}
    }

    def recrawl() {
        log.trace 'recrawling'
        log.trace EntryStorage.entries.size() + ' entries'
        remove()
        update()
        create()
        log.trace EntryStorage.entries.size() + ' entries'
    }

    def remove() {
        EntryStorage.entries.values().grep { !it.file.exists() }.each {
            log.trace "removing $it"
            it.parent.children - it
            EntryStorage.entries.remove it.url
        }
    }

    def update() {
    }

    def create() {
        pagesHome.eachDir {file -> crawlDirectory file, Directory.root}
    }

    static def crawlDirectory(File directoryFile, Directory parent) {
        File desc = (directoryFile.getAbsolutePath() + '/desc') as File

        def directory = new Directory(directoryFile, crawlPropertiesFromFile(desc), parent)

        directoryFile.eachFile {
            if (it.isDirectory())
                crawlDirectory it, directory
            else
                if (it.getName() != "desc")
                    crawlPage it, directory
        }

        return directory
    }

    static def crawlPage(File pageFile, Directory directory) {
        def properties = crawlPropertiesFromFile(pageFile)
        def page = new Page(pageFile, properties, directory)

        return page
    }

    static def crawlPropertiesFromFile(File file) {
        StringBuilder text = new StringBuilder()
        Map<String, String> properties = new HashMap<String, String>()
        boolean rawText = false

        file.eachLine {
            String line ->

            if (line.empty) {
                rawText = true;
            }else if (rawText) {
                text.append line
            } else {
                List<String> strings = line.tokenize(':').collect {it.trim()}
                if (strings.size() == 2) {
                    properties[strings[0]] = strings[1]
                } else if (strings.size() == 1) {
                    properties[strings[0]] = true
                } else {
                    throw new IllegalArgumentException("something unparseable @ $file: “${line}”");
                }
            }
        }

        properties['File'] = file
        properties['Text'] = text.toString()

        return properties

    }

}
