package ru.devg.dggb;

class Page {

    final Map<String, String> properties
    final String body
    final Directory parent

    def Article = {
        Map<String, String> properties,
        String body,
        Directory parent->

        this.properties = properties;
        this.body = body;
        this.parent = parent;
    }
}