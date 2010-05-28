package ru.devg.dggb

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class CrawlerService {

    boolean transactional = false

    EntryStorage preparing = new EntryStorage()

    static final File pagesHome = CH.config.dggb.pages.home as File

    synchronized def crawl() {
        preparing = new EntryStorage()
        crawlDirectory(pagesHome, Directory.root)
        EntryService.currentStorage = preparing
        log.trace "crawled ${preparing.entries.size()} entries"
        preparing = null
    }

    def crawlDirectory(File directoryFile, Directory parent) {
        if(directoryFile.name[0] == '.') return
        File desc = (directoryFile.getAbsolutePath() + '/desc') as File

        def directory = preparing.newDirectory(directoryFile, crawlPropertiesFromFile(desc), parent)

        directoryFile.eachFile {
            if (it.isDirectory())
                crawlDirectory it, directory
            else
                if (it.name != "desc" && !it.name.contains('.'))
                    preparing.newPage(it, crawlPropertiesFromFile(it), directory)
        }

        return directory
    }

    static def crawlPropertiesFromFile(File file) {
        StringBuilder text = new StringBuilder()
        Map<String, String> properties = [:]
        boolean rawText = false

        file.eachLine {
            String line ->

            if (line.empty) {
                rawText = true;
            } else if (rawText) {
                text.append line
                text.append "\n"
            } else {
                List<String> strings = line.tokenize(':').collect {it.trim()}

                String key = transformKey(strings[0])
                key = key.toLowerCase() 
                if (strings.size() == 2) {
                    properties[key] = strings[1]
                } else if (strings.size() == 1) {
                    properties[key] = true
                } else {
                    throw new IllegalArgumentException("something unparseable @ $file: “${line}”");
                }
            }
        }

        properties.file = file
        properties.text = text.toString()

        return properties

    }

    static def transformKey(String key) {
        switch (key) {
            case 'Заголовок':
                return 'Title'
            case 'Дата':
                return 'Date'
            case 'Черновик':
                return 'Draft'
            case 'Теги':
                return 'Tags'
            case 'Произвольная разметка':
                return 'Custom layout'
            default:
                return key
        }
    }

}
