package ru.devg.dggb

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class CrawlerService {

    boolean transactional = false

    def initialCrawl() {
        File articlesHome = CH.config.dggb.articles.home as File

        articlesHome.eachDir {File file -> crawlDirectory file, Directory.root}
    }

    static def crawlDirectory(File directoryFile, Directory parent) {

        File desc = new File(directoryFile.getAbsolutePath() + '/desc')

        Directory directory = new Directory(crawlPropertiesFromFile(desc), parent)

        directoryFile.eachFile {
            if (it.isDirectory())
                crawlDirectory it, directory
            else
                if(it.getName() != "desc")
                    crawlPage it, directory     
        }

        println directory
        return directory
    }

    static def crawlPage(File pageFile, Directory directory) {

        def properties = crawlPropertiesFromFile(pageFile)
        def page = new Page(properties, directory)

        println page
        return page
    }

    static def crawlPropertiesFromFile(File file) {

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

        properties['File'] = file
        properties['Text'] = text.toString()

        return properties

    }

}
