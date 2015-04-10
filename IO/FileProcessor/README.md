# Примеры обработки файла

## [FileLineProcessor][FileLineProcessor]

Построчная обработка файла.

Пример чтения символьных данных из файла. Их обработка и запись в файл.

### Особенности

Ввод-вывод символьный, буферизированный.

Для корректного освобождения ресурсов  используется конструкция try-with-resources.

### Сборка

Для компиляции необходимо запустить скрипт `build`.

### Запуск

Для запуска необходимо запустить скрипт `run FileLineProcessor`.

## [FileDataProcessor][FileDataProcessor]

Пример чтения и записи примитивов в файл.

### Особенности

Ввод-вывод осуществляется с помощью `DataInput/DataOutputStream`.

Для корректного освобождения ресурсов  используется конструкция try-with-resources.

### Сборка

Для компиляции необходимо запустить скрипт `build`.

### Запуск

Для запуска необходимо запустить скрипт `run FileDataProcessor`.

[FileLineProcessor]: https://github.com/rumter/Java-Samples/blob/master/IO/FileProcessor/src/ru/rumter/samples/io/fileprocessor/FileLineProcessor.java

[FileDataProcessor]: https://github.com/rumter/Java-Samples/blob/master/IO/FileProcessor/src/ru/rumter/samples/io/fileprocessor/FileDataProcessor.java
