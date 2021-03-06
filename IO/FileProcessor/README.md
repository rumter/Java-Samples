# Примеры чтения и записи файла

## Компиляция и запуск примеров

Для компиляции необходимо запустить скрипт `build`.

Для выполнения необходимо запустить скрипт `run` и указать ему в качестве первого аргумента название класса примера.

Пример: `run FileLineProcessor`.

## [FileLineProcessor][FileLineProcessor]

Построчная обработка файла.

Пример чтения символьных данных из файла. Их обработка и запись в файл.

Ввод-вывод символьный, буферизированный.

Для корректного освобождения ресурсов используется конструкция try-with-resources.

## [FileDataProcessor][FileDataProcessor]

Пример чтения и записи примитивов в файл.

Ввод-вывод осуществляется с помощью `DataInput/OutputStream`.

Для корректного освобождения ресурсов  используется конструкция try-with-resources.

## [FileWholeProcessor][FileWholeProcessor]

Чтение файла целиком в строку и запись строки в файл.

Ввод-вывод символьный, буферизированный.

Для корректного освобождения ресурсов используется конструкция try-with-resources.

## [FileObjectProcessor][FileObjectProcessor]

Запись объекта в файл, чтение из файла и сравнение с первоначальным состоянием до записи.

Сериализация/десериализация выполняется с помощью ObjectInput/OutputStream.

Для корректного освобождения ресурсов используется конструкция try-with-resources.

## [FileRandomAccessProcessor][FileRandomAccessProcessor]

Запись в файл, начиная сопределенного места.

Чтение записанных данных.

Ввод-вывод байтовый.

## [FilePrependProcessor][FilePrependProcessor]

Запись данных в начало файла.

Используется RandomAccessFile.

## [FileAppendProcessor][FileAppendProcessor]

Запись данных в конец файла.

Ввод-вывод символьный.

[FileLineProcessor]: https://github.com/rumter/Java-Samples/blob/master/IO/FileProcessor/src/ru/rumter/samples/io/fileprocessor/FileLineProcessor.java

[FileDataProcessor]: https://github.com/rumter/Java-Samples/blob/master/IO/FileProcessor/src/ru/rumter/samples/io/fileprocessor/FileDataProcessor.java

[FileWholeProcessor]: https://github.com/rumter/Java-Samples/blob/master/IO/FileProcessor/src/ru/rumter/samples/io/fileprocessor/FileWholeProcessor.java

[FileObjectProcessor]: https://github.com/rumter/Java-Samples/blob/master/IO/FileProcessor/src/ru/rumter/samples/io/fileprocessor/FileObjectProcessor.java

[FileRandomAccessProcessor]: https://github.com/rumter/Java-Samples/blob/master/IO/FileProcessor/src/ru/rumter/samples/io/fileprocessor/FileRandomAccessProcessor.java

[FilePrependProcessor]: https://github.com/rumter/Java-Samples/blob/master/IO/FileProcessor/src/ru/rumter/samples/io/fileprocessor/FilePrependProcessor.java

[FileAppendProcessor]: https://github.com/rumter/Java-Samples/blob/master/IO/FileProcessor/src/ru/rumter/samples/io/fileprocessor/FileAppendProcessor.java
