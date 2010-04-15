package ru.devg.dggb

class TwitterStatusRefresherJob {
    def timeout = 60000l // execute job once in 60 seconds

    def twitterService

    def execute() {
        twitterService.updateStatuses()
    }
}
