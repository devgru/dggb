eventCompileStart = {
    def files = ['main']
    println "Running lessc on $files"
    files.each() {
        System.out << "/var/lib/gems/1.9.1/bin/lessc web-app/css/${it}.less".execute().errorStream;

    }
    println "Running lessc ok"
}
