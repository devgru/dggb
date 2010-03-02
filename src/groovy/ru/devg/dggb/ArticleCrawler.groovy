package ru.devg.dggb

class ArticleCrawler {

    def initialCrawl = {
        File articlesHome = new File(ConfigurationHolder.config.dggb.articles.home)

        articlesHome.listFiles().grep {it.isDirectory()}.each {crawlCategory it}
    }

    def crawlCategory = {
        File categoryDir ->

        File desc = new File(categoryDir.getAbsolutePath() + '/desc')
        println categoryDir.absolutePath

    }

}

