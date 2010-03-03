eventCompileStart = {
    println "Running lessc"
    ['main'].each() {
        "/var/lib/gems/1.9.1/bin/lessc web-app/css/${it}.less".execute().
                getErrorStream().readLines().each { println it }

    }
    println "Running lessc ok"
}