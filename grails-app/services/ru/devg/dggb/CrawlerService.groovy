package ru.devg.dggb

import org.codehaus.groovy.grails.commons.ConfigurationHolder

class CrawlerService {

    boolean transactional = false

    def initialCrawl = {
        File articlesHome = new File(ConfigurationHolder.config.dggb.articles.home)

        articlesHome.listFiles().grep {it.isDirectory()}.each {crawlCategory it}
    }

    def crawlCategory = {
        File categoryDir ->

        File desc = new File(categoryDir.getAbsolutePath() + '/desc')
        println crawlPropertiesFromFile(desc)

    }

    static def crawlPropertiesFromFile = {
        File file ->

        Map<String, String> properties = new HashMap<String, String>()
        boolean stillProperties = true

        file.readLines().each {
            String line ->

            if(!line.contains(':')) stillProperties = false;
            if(!stillProperties) return;

            String[] strings = line.split(':').each {it -> it.trim()}
            properties.put(strings[0], strings[1])
        }

        return properties

    }
}
