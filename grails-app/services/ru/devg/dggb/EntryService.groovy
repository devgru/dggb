package ru.devg.dggb

class EntryService {

    boolean transactional = false

    def getEntry(String url) {
        return EntryStorage.entries[url]
    }
}
