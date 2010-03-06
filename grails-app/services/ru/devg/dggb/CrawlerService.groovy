package ru.devg.dggb

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class CrawlerService {

    boolean transactional = false

    def initialCrawl = {
        File articlesHome = CH.config.dggb.articles.home as File

        articlesHome.eachDir {crawlDirectory it, Directory.root}
    }

    static def crawlDirectory = {
        File directoryFile, Directory parent ->

        File desc = new File(directoryFile.getAbsolutePath() + '/desc')
        Map<String, String> properties = crawlPropertiesFromFile(desc)

        Directory directory = new Directory(properties, [], parent)

        directoryFile.eachFile {
            if (it.isDirectory())
                crawlDirectory it, directory
            else
                crawlPage it, directory
        }

    }

    static def crawlPropertiesFromFile = {
        File file ->

        StringBuilder text = new StringBuilder()
        Map<String, String> properties = new HashMap<String, String>()
        boolean rawText = false

        file.eachLine {
            String line ->

            if (line.empty) rawText = true;
            if (rawText) {
                text.append line
            } else {
                List<String> strings = line.tokenize(':').each {String it -> it.trim()}
                if (strings.size() == 2) {
                    properties[strings[0]] = strings[1]
                } else if (strings.size() == 1) {
                    properties[strings[0]] = true
                } else {
                    throw new IllegalArgumentException("something unparseable @ $file: “${line}”");
                }
            }
        }

        properties['Text'] = text.toString()

        return properties

    }

    static def crawlPage = {
        File pageFile, Directory directory ->


    }
}
