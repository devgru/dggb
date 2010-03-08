package ru.devg.dggb

class Page extends Entry {

    Page(File file, Map<String, String> properties, Directory parent) {
        super(file, properties, parent)

        parent.pages.add this
        parent.children.add this
        EntryStorage.addEntry this
    }
}