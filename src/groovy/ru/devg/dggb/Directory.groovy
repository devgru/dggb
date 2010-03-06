package ru.devg.dggb;

class Directory {

    static final Map<String, Directory> directories = new HashMap<String,Directory>()
    static final Directory root = new Directory([],[],null)

    final Map<String, String> properties
    final List<Page> pages = new LinkedList<Page>()
    final Directory parent



    def Directory(properties, pages, parent) {
        this.properties = properties;
        this.pages = pages;
        this.parent = parent;
    }
}