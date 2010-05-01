package ru.devg.dggb

import twitter4j.Twitter;
import twitter4j.Status;

class TwitterService {

    boolean transactional = false

    static final Twitter twitter = new Twitter()
    List<Status> statuses = null

    void updateStatuses() {

        def statuses = twitter.getUserTimeline('devgru');
        statuses = statuses.grep {!it.text.startsWith('@')}.subList(0, 5)
        this.statuses = statuses 
        log.trace "statuses updated (${statuses.size()})"

    }
}