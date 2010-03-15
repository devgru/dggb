package ru.devg.dggb

class EntryService {

    boolean transactional = false

    static EntryStorage currentStorage

    def getEntry(String url) {
        return currentStorage?.entries[url]
    }
}
