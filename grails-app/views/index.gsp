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
        <h2>с оранжево-зелёной тильдой!</h2>
    </hgroup>
</header>

<article>
    <header><h1>Привет!</h1></header>
    <section>
        <aside><img src="/images/iam.jpg" alt="Я"></aside>
        <p>Меня зовут Дима Тихвинский, я — немного лохматый веб-разработчик и джава-программист.</p>
        <p>Я немного умею играть на клавишных (учился на Casio CTK-900, а позже приобрёл microkorg). В основном импровизирую, не более того.</p>
        <p>Кроме музыки я увлекаюсь психологией, соционикой и иногда порываюсь изучать историю и философию. Я весьма серьёзно отношусь к этим гуманитарным наукам и рассматриваю их прежде всего с практической точки зрения.</p>
        <aside><img src="/images/poi.jpg" alt="Светодиодные пойки"></aside>
        <p>С недавних пор кручу пои — со стороны это показалось весьма интересным занятием, и я решил попробовать. Начал я в августе, сейчас осваиваю базовую программу в школе antispinners. Вскоре хочу собрать собственные контролируемые светодиодные пои на базе Ардуино.</p>
        <p>Помимо всего этого, я — студент <a href="http://ifmo.ru">ИТМО</a>, учусь на 4 курсе по специальности <a href="http://www.ifmo.ru/spec/25/spec_25.htm">«Информационные системы и технологии»</a>.</p>
    </section>
</article>

<article>
    <header><h1>Тильда&nbsp;&ndash; знак дома</h1></header>
    <section>
        <p>Я давно думал, какую взять символику для этой версии своего сайта.
        Всякие буквы пси (как знак психологии) и модульные сеточки (как символ веб-разработки) особо не привлекали,
        а вот идея оформить сайт в виде консоли понравилась сразу.</p>
        <p>К счастью, в определённый момент от огромной терминало-подобной чёрной плашки с моноширинным шрифтом я отказался, за что можете благодарить <a href="http://kalan.cc">Калана</a> и в итоге я остановился на тильде, как символе домашней директории и думаю что ещё долго от этого символа не откажусь. Кроме того, я оставил «миллиметровку», бледную до крайности, но тем не менее заметную.</p>
    </section>
</article>

<article class="right">
    <header><h1>Контакты</h1></header>
    <section>
        <p>Связаться со мной проще всего <a href="mailto:devgru@mail.ru">по почте</a> или <a href="xmpp:devgru@jabber.ru">через джаббер</a>.</p>
    </section>
</article>

<article>
    <header><h1>Раньше тут был блог.</h1></header>
    <section>
        <p>А сейчас блога у меня нет.</p>
        <p>Причина проста: формат неудобный. Блог предполагает что на момент публикации записи она уже находится в своей конечной форме, а мне больше нравится писать длинные заметки, которые можно опубликовать в полу-сыром виде, чтобы получить отзывы и интересные комментарии, а потом подшить в виде брошюры или книги.</p>
        <p>В любом случае, летом я верну сюда те старые заметки, что устраивают меня самого. Скорее всего я займусь этим в начале 2011.</p>
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
