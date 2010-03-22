package ru.devg.dggb

import com.sun.syndication.feed.synd.SyndContentImpl
import java.text.SimpleDateFormat

class RssController {

    def index = {
        List<Entry> entries = EntryService.currentStorage.entries.values().grep { it.properties.date != null};

        render(feedType: "rss") {
            title = "/home/devgru/"
            link = "http://home.devg.ru/rss"
            description = "/home/devgru/"
            author = "web@devg.ru"

            entries.each { Entry ntr ->

                def txt = getText(ntr);
                entry {
                    title = ntr['title']
                    link = 'http://home.devg.ru' + ntr.url
                    publishedDate = getDate(ntr)
                    content(txt)  
                }
            }
        }
    }

    static SimpleDateFormat sdf = new SimpleDateFormat('dd.MM.yyyy')

    static Date getDate(Entry entry) {
        sdf.parse entry['date']
    }
    static String getText(Entry entry) {
        entry['text'].replaceAll(/<aside>[^<>]*<\/aside>/, '')
    }
}

