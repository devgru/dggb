class BootStrap {

    def crawlerService

    def init = {servletContext ->
        crawlerService.crawl()
    }

    def destroy = {
    }
}
