package ru.devg.dggb

class Page {

    final Map<String, String> properties
    final Directory parent

    def Page(Map<String, String> properties, Directory parent) {

        this.properties = properties;
        this.parent = parent;
        parent.pages += this
    }
}