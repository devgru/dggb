import ru.devg.dggb.ArticleCrawler

class ArticleBootStrap {

    def articleService

    def init = {servletContext ->

        articleService.sayHello()
        new ArticleCrawler().initialCrawl() 
    }
    def destroy = {
    }
}