#language:ru

@loginapi
@api
Функционал: Авторизация на сайте через API

  @login.negative
  @login.api.tk1
  @data=$loginpassword{incorrectLoginPassword}
  Сценарий: Авторизация через API. Непустые некорректные логин и пароль
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectLoginOrPassword"

  @login.negative
  @login.api.tk2
  @data=$loginpassword{loginPasswordNull}
  Сценарий: Авторизация через API. Логин и пароль null
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectLoginOrPassword"

  @login.negative
  @login.api.tk3
  @data=$loginpassword{emptyLoginPassword}
  Сценарий: Авторизация через API. Логин и пароль пустые строчки
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectLoginOrPassword"

  @login.negative
  @login.api.tk4
  @data=$loginpassword{xmlContentType}
  Сценарий: Авторизация через API. Content-Type = application/xml
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectContentType"

  @login.negative
  @login.api.tk5
  @data=$loginpassword{emptyPassword}
  Сценарий: Авторизация через API. Пароль пустой
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectLoginOrPassword"

  @login.negative
  @login.api.tk6
  @data=$loginpassword{emptyLogin}
  Сценарий: Авторизация через API. Логин пустой
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectLoginOrPassword"


  @login.negative
  @login.api.tk7
  @data=$loginpassword{textPlainContentType}
  Сценарий: Авторизация через API. Content-Type = text/plain
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectContentType"

  @login.negative
  @login.api.tk8
  @data=$loginpassword{nullPassword}
  Сценарий: Авторизация через API. Логин не null и пароль null
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectLoginOrPassword"

  @login.negative
  @login.api.tk9
  @data=$loginpassword{nullLogin}
  Сценарий: Авторизация через API. Логин null и пароль не null
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectLoginOrPassword"

  @login.negative
  @login.api.tk9
  @data=$loginpassword{sqlInj}
  Сценарий: Авторизация через API. Проверка на простейшую sql-инъекцию
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectLoginOrPassword"