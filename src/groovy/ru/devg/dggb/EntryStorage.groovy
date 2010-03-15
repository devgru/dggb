package ru.devg.dggb

@SuppressWarnings("GroovyAssignabilityCheck")
class EntryStorage {

    final SortedMap<String, Entry> entries = new TreeMap<String, Entry>();

    Entry addEntry(Entry entry) {
        entries.put(entry.url, entry)
        return entry
    }

    Page newPage(File file, Map<String, String> properties, Directory parent) {
        addEntry(new Page(file, properties, parent))
    }

    Directory newDirectory(File file, Map<String, String> properties, Directory parent) {
        addEntry(new Directory(file, properties, parent))
    }

}
