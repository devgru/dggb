import org.codehaus.groovy.grails.commons.ConfigurationHolder

class ArticleBootStrap {

    def articleService

    def init = {servletContext ->

        File categories = new File(ConfigurationHolder.config.dggb.articles.home)

        println categories.listFiles()

    }
    def destroy = {
    }
}