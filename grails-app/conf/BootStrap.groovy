class BootStrap {

    def crawlerService

    def init = {servletContext ->

        crawlerService.initialCrawl()

    }
    def destroy = {
    }
}
