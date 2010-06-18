package ru.devg.dggb

import twitter4j.Status

class IndexController {

    List<Status> statuses
    def twitterService

    def index = {
        response.addDateHeader 'Last-Modified', new Date(2010, 01, 01).getTime()
        statuses = twitterService.statuses
        render(view: '/index')
    }
}