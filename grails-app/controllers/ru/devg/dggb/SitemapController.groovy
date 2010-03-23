package ru.devg.dggb

class SitemapController {
    def entries
    def index = {
        entries = EntryService.currentStorage.entries.values();
        render(view: '/sitemap')

    }
}