package ru.devg.dggb;

class Article {

    final Map<String, String> properties
    final String body

    def Article = {
        Map<String, String> properties,
        String body ->

        this.properties = properties;
        this.body = body;
    }
}