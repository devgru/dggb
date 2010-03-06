package ru.devg.dggb;

class Directory {

    static final Map<String, Directory> directories = new HashMap<String,Directory>()
    static final Directory root = new Directory([:],null)

    Map<String, String> properties
    List<Page> pages = []
    final Directory parent
    final Set<Directory> children = []

    def Directory(Map<String, String> properties, Directory parent) {
        this.properties = properties;
        this.parent = parent;
        if(parent)parent.children.add this
    }
}