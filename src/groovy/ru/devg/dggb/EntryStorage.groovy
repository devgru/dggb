package ru.devg.dggb

class EntryStorage {
    static final SortedMap<String, Entry> entries = new TreeMap<String,Entry>();

    static def addEntry(Entry entry) {
        entries.put(entry.url, entry)
    }
}
