class BootStrap {

    def crawlerService
    def twitterService

    def init = {servletContext ->
        crawlerService.crawl()
        twitterService.updateStatuses()
    }

    def destroy = {
    }
}
