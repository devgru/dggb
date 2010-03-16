package ru.devg.dggb

class EntryService {

    boolean transactional = false

    static EntryStorage currentStorage

    Entry getEntry(String url) {
        return currentStorage?.entries?.get(url)
    }
}
