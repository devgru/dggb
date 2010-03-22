package ru.devg.dggb

class FileWatcherJob {
    def timeout = 60000l // execute job once in 60 seconds

    def crawlerService

    def execute() {
        crawlerService.crawl()
    }
}
