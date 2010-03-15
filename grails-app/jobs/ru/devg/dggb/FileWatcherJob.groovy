package ru.devg.dggb

class FileWatcherJob {
    def timeout = 20000l // execute job once in 20 seconds

    def crawlerService

    def execute() {
        crawlerService.crawl()
    }
}
