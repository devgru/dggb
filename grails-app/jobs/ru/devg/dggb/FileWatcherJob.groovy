package ru.devg.dggb

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class FileWatcherJob {
    def timeout = 20000l // execute job once in 5 seconds

    def crawlerService

    def execute() {
        crawlerService.recrawl()
    }
}
