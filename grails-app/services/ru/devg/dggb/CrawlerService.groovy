package ru.devg.dggb

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class CrawlerService {

    boolean transactional = false

    EntryStorage preparing = new EntryStorage()

    static final File pagesHome = CH.config.dggb.pages.home as File

    synchronized void crawl() {
        preparing = new EntryStorage()
        try {
            crawlDirectory pagesHome, Directory.root

            log.trace "crawled ${preparing.entries.size()} entries"
            EntryService.currentStorage = preparing
        } catch (Exception e) {
            log.error "crawling failed"
        }
        preparing = null
    }

    void crawlDirectory(File directoryFile, Directory parent) {
        File desc = (directoryFile.absolutePath + '/desc') as File
        if (!desc.exists()) return

        Directory directory = preparing.newDirectory(directoryFile, crawlPropertiesFromFile(desc), parent)

        directoryFile.eachFile {
            if (it.hidden) return
            if (it.file && it.name != "desc")
                preparing.newPage it, crawlPropertiesFromFile(it), directory
            else if (it.directory)
                crawlDirectory it, directory
        }
    }

    static final String NEW_LINE = '\n';

    static Map<String, String> crawlPropertiesFromFile(File file) {
        StringBuilder text = new StringBuilder()
        Map<String, String> properties = [:]
        boolean rawText = false

        file.eachLine {
            String line ->

            if (line.empty) {
                if (rawText)
                    text << NEW_LINE
                else
                    rawText = true
            } else if (rawText) {
                text << line << NEW_LINE
            } else {
                List<String> strings = line.tokenize(':').collect {it.trim()}

                String key = transformKey(strings[0])
                key = key.toLowerCase()
                if (strings.size() == 2)
                    properties[key] = strings[1]
                else if (strings.size() == 1)
                    properties[key] = true
                else
                    throw new IllegalArgumentException("something unparseable @ $file: “${line}”");
            }
        }

        properties.file = file
        properties.text = text.toString()

        return properties

    }

    static String transformKey(String key) {
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
