import ru.devg.dggb.EntryService

class BootStrap {

    def crawlerService
    def twitterService

    def init = {servletContext ->
        if(!EntryService.currentStorage) crawlerService.crawl()
        if(!twitterService.statuses) twitterService.updateStatuses()
    }

    def destroy = {
    }
}
