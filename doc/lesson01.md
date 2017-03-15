# Урок 2. Материалы

*Инструкция к WildFly*

1. `${JBOSS_HOME}/bin/add_user.bat` - добавить management пользователя для
    управления сервером приложений.
2. `${JBOSS_HOME}/bin/standalone.bat` - запустить сервер приложений.
3. `localhost:8080` - для доступа к серверу приложений. Перейдите по ссылке
    в `administrationConsole` (`localhost:9990/console`).
4. Создать `datasource`. Для этого перейти во вкладку `Configuration -> SubSystems ->
    datasources -> Non-XA -> Add`.
    - Выбрать: `H2 Datasource`.
    - Проставить правильный `JNDI NAME` в значение `java:/H2DS`. Это имя будет
    использоваться в приложении для доступа к ресурсу.
    - `Detected Driver` выбрать `h2`.
    - `ConnectionURL` необходимо проставить значение `file` вместо `mem`: 
    `jdbc:h2:file:/home/db;DB_CLOSE_DELAY=-1`.
    - Нажать `Finish` и проверить, что в папке `C:/home` появились `db` файлы.
    База данных готова.
5. Теперь можно деплоить приложения в `Deployemnts -> ADD`. Наше приложение 
    собирается в папке `assembly/target`. Проверьте в консоли, что выводятся
    скрипты создания базы при деплое приложения.

*Материалы*

1. [JPA Tutorial](https://www.tutorialspoint.com/jpa/). Советую почитать разделы
`Introduction` и `Entity Relationships`.
2. Разберитесь с аннотациями `@Entity, @Table, @Basic, @Id, @Column, @OneToMany,
    @ManyToOne, @Column, @JoinColumn`.
    