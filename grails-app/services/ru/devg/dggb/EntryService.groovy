package ru.devg.dggb

class EntryService {

    def urlService

    boolean transactional = false

    static EntryStorage currentStorage

    Entry getEntry() {
        currentStorage?.entries?.get(urlService.url)
    }

}
