package ru.devg.dggb

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class CrawlerService {

    boolean transactional = false

    EntryStorage preparing = new EntryStorage()

    static final File pagesHome = CH.config.dggb.pages.home as File

    synchronized def crawl() {
        preparing = new EntryStorage()
        pagesHome.eachDir {file -> crawlDirectory file, Directory.root}
        EntryService.currentStorage = preparing
        preparing = null
    }

    def crawlDirectory(File directoryFile, Directory parent) {
        File desc = (directoryFile.getAbsolutePath() + '/desc') as File

        def directory = preparing.newDirectory(directoryFile, crawlPropertiesFromFile(desc), parent)

        directoryFile.eachFile {
            if (it.isDirectory())
                crawlDirectory it, directory
            else
                if (it.getName() != "desc")
                    preparing.newPage(it, crawlPropertiesFromFile(it), directory)
        }

        return directory
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
