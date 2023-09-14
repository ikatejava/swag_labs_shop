# Проект по автоматизации тестирования для [Swag Labs](https://www.saucedemo.com/)

> [Swag Labs](https://www.saucedemo.com/) - тренировочная платформа для QA-студентов и инженеров.
____

> ## :ballot_box_with_check: <a name="Содержание">**Содержание:**</a>

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск тестов из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>

* <a href="#telegram">Уведомление в Telegram с помощью бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>

____

<a id="tools"></a>
> ## :ballot_box_with_check: <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p  align="center"

<code><a href="https://www.java.com/"><img width="5%" title="Java" src="media/logos/Java.svg"></a></code>
<code><a href="https://www.jetbrains.com/idea/"><img width="5%" title="IntelliJ IDEA" src="media/logos/Intellij_IDEA.svg"></a></code>
<code><a href="https://gradle.org/"><img width="5%" title="Gradle" src="media/logos/Gradle.svg"></code></a>
<code><a href="https://junit.org/junit5/"><img width="5%" title="JUnit5" src="media/logos/JUnit5.svg"></a></code>
<code><a href="https://selenide.org/"><img width="5%" title="Selenide" src="media/logos/Selenide.svg"></a></code>
<code><a href="https://aerokube.com/selenoid/"><img width="5%" title="Selenoid" src="media/logos/Selenoid.svg"></a></code>
<code><a href="https://github.com/"><img width="5%" title="GitHub" src="media/logos/GitHub.svg"></a></code>
<code><a href="https://github.com/allure-framework"><img width="5%" title="Allure Report" src="media/logos/Allure.svg"></a></code>
<code><a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/logos/Allure_TO.svg"></a></code>
<code><a href="https://www.jenkins.io"><img width="5%" title="Jenkins" src="media/logos/Jenkins.svg"></a></code>
<code><a href="https://www.atlassian.com/software/jira"><img width="5%" title="Jira" src="media/logos/Jira.svg"></a></code>
<code><a href="https://web.telegram.org"><img width="5%" title="Telegram" src="media/logos/Telegram.svg"></a></code>

</p>

- В данном проекте автотесты написаны на <code>Java</code> с использованием фреймворков [Selenide](https://selenide.org/) и [JUnit 5](https://junit.org/junit5/).
- Для сборки проекта был использован [Gradle](https://gradle.org/).
- При удаленном запуске тестов браузер запускается в [Selenoid](https://selenoid.autotests.cloud/).
- Удаленный запуск реализован в [Jenkins](https://jenkins.autotests.cloud/) с формированием <code>Allure</code>-отчета.
- Подключена отправка уведомлений о результатах запуска сборки в <code>Telegram</code> при помощи бота.
- Осуществлена интеграция с [Allure TestOps](https://allure.autotests.cloud/) и [Jira](https://jira.autotests.cloud/).

Содержание Allure-отчета:

* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

____

<a id="cases"></a>
> ## :ballot_box_with_check: <a name="Примеры автоматизированных тест-кейсов">Примеры автоматизированных тест-кейсов:</a>

- Параметризованный тест на проверку возможности авторизации зарегистрированных пользователей с корректными логином и паролем;
- Параметризованный тест на проверку невозможности авторизации зарегистрированных пользователей с неверным паролем;
- Проверка невозможности авторизации заблокированного пользователя;
- Параметризованный тест на проверку невозможности авторизации незарегистрированных пользователей;
- Параметризованный тест на добавление товаров в корзину;
- Параметризованный тест на проверку невозможности для пользователя "problem_user" добавить в корзину некоторые товары;
- Параметризованный тест на удаление товаров из корзины: 1) со страницы товаров 2) в корзине;
- Параметризованный тест на проверку невозможности для пользователя "problem_user" удалить товары из корзины со страницы товаров;
- Параметризованный смоук-тест на авторизацию, добавление товара в корзину, проверку его соответствия своим характеристикам в магазине,
заполнение личной информации пользователя для оформления покупки, покупку товара и получение подтверждающей информации о покупке товара и его доставке;
- Параметризованный смоук-тест на проверку невозможности для пользователя "problem_user" завершить покупку на этапе заполнения личной информации.

____

<a id="jenkins"></a>
> ## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logos/Jenkins.svg"> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/swag_labs_shop/)

Для запуска сборки необходимо перейти в раздел <code>Собрать с параметрами</code> и нажать кнопку <code>Собрать</code>.

<p align="center">
<img title="Jenkins Build" src="media/screens/jenkins_build.png">
</p>

### **Параметры сборки:**

* <code>BASE_URL</code> – главная страница веб-сайта.
* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором запускаются тесты.
* <code>BROWSER</code> – браузер, в котором выполняются тесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера. По-умолчанию - <code>1920x1080</code>.

После выполнения сборки в блоке <code>История сборок</code> напротив номера сборки появляются значки <code>Allure
Report</code> и <code>Allure TestOps</code>, при клике на которые открываются страницы со сформированным html-отчетом и
тестовой документацией соответственно.
____

<a id="console"></a>
> ## :ballot_box_with_check: <a name="Запуск тестов из терминала">**Запуск тестов из терминала:**</a>

### Команда для терминала IDE для локального запуска тестов:

```
gradle clean test
```

### Команда для терминала IDE для удаленного запуска тестов в [Selenoid](https://selenoid.autotests.cloud/):

```
gradle clean test -Denv=remote
```

Также можно переопределить параметры запуска:

```
clean
${TASK}
-DbaseUrl=${BASE_URL}
-DremoteUrl=${REMOTE_URL}
-Dbrowser=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
```

____

<a id="allure"></a>
> ## <img alt="Allure" height="25" src="media/logos/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [Report](https://jenkins.autotests.cloud/job/swag_labs_shop/11/allure/)</a>

### Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/screens/allure_main.png" width="850">  
</p>  

### Тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/screens/allure_locked_out_user_failed_auth_case.png" width="850">  

<img title="Allure Tests" src="media/screens/allure_add_to_cart_success_case.png" width="850">
</p>

### Графики

<p align="center">  
<img title="Allure Graphics" src="media/screens/allure_graph1.png" width="850">

<img title="Allure Graphics" src="media/screens/allure_graph2.png" width="850">  
</p>

____

<a id="allure-testops"></a>
> ## <img src="media/logos/Allure_TO.svg" title="Allure TestOps" width="4%"/> </a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/launch/29468">Allure TestOps</a>

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

## Allure TestOps Dashboard

<p align="center">  
<img title="Allure TestOps Dashboard" src="media/screens/allure_to_dashboards.png" width="850">
</p>  

## Тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/screens/allure_to_successful_removing_product_from_cart_case.png" width="850">  

<img title="Allure Tests" src="media/screens/allure_to_successful_smoke_case.png" width="850">  
</p>

____

<a id="jira"></a>

> ## <img src="media/logos/Jira.svg" title="Jira" width="4%"/> </a> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-863">Jira</a>

<p align="center">  
<img title="Jira" src="media/screens/jira_plus_allure_to.png" width="850"> 
</p>

____

<a id="telegram"></a>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logos/Telegram.svg"> Уведомления в Telegram с помощью бота

После завершения сборки созданный в <code>Telegram</code> бот автоматически обрабатывает результаты и отправляет
уведомление со ссылкой на отчет.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/tg_notification_msg.png">
</p>

____

<a id="video"></a>

## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео его выполнения.
<p align="center">
<img title="Selenoid Video" src="media/videos/successful_smoke.gif" width="750" height="450" alt="video">
</p>
