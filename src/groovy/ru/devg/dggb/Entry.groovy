package ru.devg.dggb

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class Entry implements Comparable<Entry> {
    final Map<String, String> properties
    final Directory parent
    final File file
    final String url
    Date updateDate

    Entry(File file, Map<String, String> properties, Directory parent) {
        this.file = file;
        this.properties = properties;
        this.parent = parent;

        updateDate = new Date(file.lastModified())

        String url = file.absolutePath
        File home = (CH.config.dggb.pages.home as File)
        url = url.replace(home.absolutePath, '')
        this.url = url
    }

    String toString() {
        return "Entry $file $properties"
    }

    String getName() {
        return file.name
    }

    int compareTo(Entry o) {
        return name.compareTo(o.name)
    }

    int hashCode() {
        return name.hashCode()
    }

}
