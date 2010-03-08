package ru.devg.dggb;


import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class Directory extends Entry {

    static final Map<String, Directory> directories = new HashMap<String, Directory>()
    static final Directory root = new Directory((CH.config.dggb.pages.home as File), [:], null)

    final Set<Page> pages = []
    final SortedSet<Entry> children = new TreeSet<Entry>()
    final Set<Directory> subdirs = []

    Directory(File file, Map<String, String> properties, Directory parent) {
        super(file, properties, parent)
        if (parent) parent.children.add this
        if (parent) parent.subdirs.add this
        EntryStorage.addEntry this
    }

    String toString() {
        return super.toString() +
                "{\n$children\n}"
    }
}