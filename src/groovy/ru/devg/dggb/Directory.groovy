package ru.devg.dggb;


import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class Directory extends Entry {

    static final Directory root = new Directory((CH.config.dggb.pages.home as File), [:], null)

    final Set<Page> pages = []
    final Set<Directory> subdirs = []

    Directory(File file, Map<String, String> properties, Directory parent) {
        super(file, properties, parent)
        if (parent) parent.subdirs.add this
    }

    String toString() {
        def names = children.each { it.file.name}
        return super.toString()//    + names
    }

    Set<Entry> getChildren() {
        return new TreeSet<Entry>(pages + subdirs);
    }
}
