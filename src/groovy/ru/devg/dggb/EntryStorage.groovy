package ru.devg.dggb

class EntryStorage {

    final SortedMap<String, Entry> entries = new TreeMap<String, Entry>();

    static <T extends Entry> T addEntry(T entry, Map<String, Entry> entries) {
        entries.put(entry.url, entry)
        return entry
    }

    Page newPage(File file, Map<String, String> properties, Directory parent) {
        addEntry(new Page(file, properties, parent), entries)
    }

    Directory newDirectory(File file, Map<String, String> properties, Directory parent) {
        addEntry(new Directory(file, properties, parent), entries)
    }

}
