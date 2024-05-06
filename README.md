# Sprint_7

# Запуск тестов

`mvn clean test`

# Запуск отчета Allure в браузере

`mvn allure:serve`

# Комментарии
* Два теста упадут:
** Courier with the same login is creating - из-за некорректного текста ошибки
** Courier login without password - из-за некорректного статус кода
* В LoginTest в отчете Allure задублировались шаги по созданию курьера, так как я переиспользую созданных курьеров из CourierTest# Sprint_7
