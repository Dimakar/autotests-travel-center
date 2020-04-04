#language:ru

@loginapi
@api
Функционал: Авторизация на сайте через API

  @login.negative
  @login.api.tk1
  @data=$loginpassword{incorrect}
  Сценарий: Авторизация через API. Непустые некорректные логин и пароль
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectLoginOrPassword"

  @login.negative
  @login.api.tk2
  @data=$loginpassword{null}
  Сценарий: Авторизация через API. Логин и пароль null
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectLoginOrPassword"

  @login.negative
  @login.api.tk3
  @data=$loginpassword{empty}
  Сценарий: Авторизация через API. Логин и пароль пустые строчки
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectLoginOrPassword"

  @login.negative
  @login.api.tk4
  @data=$loginpassword{incorrectContentType}
  Сценарий: Авторизация через API. Недопустимый Content-Type
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
  @data=$loginpassword{emptyContentType}
  Сценарий: Авторизация через API. Пустой Content-Type
    * пользователь отправляет запрос "login" с параметрами
      | login        | ${login}        |
      | password     | ${password}     |
      | Content-Type | ${contentType}  |
    * система возвращает ответ "incorrectContentType"