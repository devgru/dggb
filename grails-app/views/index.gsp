<html>
<head>
    <meta name="layout" content="empty"/>
    <meta name='yandex-verification' content='5b113b11dd142ec6' />
    <link rel="openid.server" href="http://openid.yandex.ru/server/" />
    <link rel="openid2.provider" href="http://openid.yandex.ru/server/" />
    <link rel="openid.delegate" href="http://openid.yandex.ru/devg-ru/" />
    <link rel="openid2.local_id" href="http://openid.yandex.ru/devg-ru/" />

</head>
<body>

<header>
    <img src="/images/tilde.png" alt="~" />
    <hgroup>
        <h1>сайт Devgru</h1>
        <h2>заметки и всякое такое</h2>
    </hgroup>
</header>

<article>
    <header><h1>Привет!</h1></header>
    <section>
        <aside><img src="/images/iam.jpg" alt="Я"></aside>
        <p>Меня зовут Дима Тихвинский, я — немного лохматый веб-разработчик</p>
        <p>Кроме того, я java-программист и ещё я иногда пишу на groovy.</p>
        <p>Я немного умею играть на клавишных и изредка занимаюсь этим на своих Casio CTK-900 и microkorg.</p>
        <p>Кроме того, я увлекаюсь психологией и потихоньку коплю мысли для новой порции заметок.</p>
    </section>
</article>

<article>
    <header><h1>Тильда&nbsp;— знак дома</h1></header>
    <section>
        <p>Давно думал, какую взять символику для этлй версии своего сайта.
        Всякие буквы пси (как знак психологии) и модульные сеточки (как символ веб-разработки) особо не привлекали,
        а вот идея оформить сайт в виде консоли понравилась сразу.</p>
        <p>К счастью, в определённый момент от огромной чёрной плашки с моноширинным шрифтом я отказался, за что можете благодарить <a href="http://kalan.cc">Калана</a>.</p>
        <p>В итоге я остановился на тильде, как символе домашней директории и думаю что ещё долго от этого символа не откажусь. Кроме того, я оставил «миллиметровку», бледную до крайности, но тем не менее заметную.</p>
    </section>
</article>

<article class="right">
    <header><h1>Контакты</h1></header>
    <section>
        <p>Связаться со мной проще всего <a href="mailto:devgru@mail.ru">по почте</a> или <a href="xmpp:devgru@jabber.ru">через джаббер</a>.</p>
    </section>
</article>

<article>
    <header><h1>А где блог?</h1></header>
    <section>
        <p>Хочу сказать честно: блога у меня больше нет.</p>
        <p>Причина проста: формат неудобный. Блог предполагает что на момент публикации записи она уже находится в своей конечной форме, а мне больше нравится писать длинные заметки, которые можно опубликовать в полу-сыром виде, чтобы получить отзывы и интересные комментарии, а потом подшить в виде брошюры или книги.</p>
        <p>В любом случае, когда-нибудь я верну сюда те старые заметки, что устраивают меня самого.</p>
        <p>Из новых статей точно следует ждать чего-то соционического, а также, быть может, заметок по вёрстке.</p>
    </section>
</article>

<article class="right twi">
    <header><h1>Твиттер</h1></header>
    <section>
        <ul>
            <g:each in="${statuses}">
                <li>${it.text}</li>
            </g:each>
        </ul>
    </section>
</article>

<footer>
    <p>Копирайт и всё такое. 2009&thinsp;&ndash;&thinsp;2010</p>
</footer>
</body>
</html>
                                            
