package ru.devg.dggb

import grails.test.*

class CrawlerTests extends GrailsUnitTestCase {
    CrawlerService crawlerService
    File home

    protected void setUp() {
        super.setUp()
        crawlerService = new CrawlerService()

        home = CrawlerService.pagesHome

        home.mkdir()
        home.eachFile {File it -> it.deleteDir()}
        home.eachFile { assert false }
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCrawl() {
        ((home.absolutePath + '/category') as File).mkdir()
        ((home.absolutePath + '/category/desc') as File).createNewFile()
        File page= ((home.absolutePath + '/category/1') as File)
        page.createNewFile()
        page.write "Name: a\n"
        page.write "Text: x\n\n"
        page.write 'Hello!'
        crawlerService.crawl()

        assert EntryService.currentStorage.entries.size() == 2
    }
}
