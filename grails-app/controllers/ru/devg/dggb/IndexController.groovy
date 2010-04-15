package ru.devg.dggb

import twitter4j.Status;

class IndexController {

    List<Status> statuses
    def twitterService

    def index = {
        statuses = twitterService.statuses
        println statuses
        render(view: '/index')
    }
}