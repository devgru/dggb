class ArticleBootStrap {

    def articleService
    def crawlerService

    def init = {servletContext ->

        crawlerService.initialCrawl()

    }
    def destroy = {
    }
}