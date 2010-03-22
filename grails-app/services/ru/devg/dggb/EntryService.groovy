package ru.devg.dggb

class EntryService {

    boolean transactional = false

    static EntryStorage currentStorage

    Entry getEntry(String url) {
        if(url=='') url='/'
        currentStorage?.entries?.get(url)
    }
}
