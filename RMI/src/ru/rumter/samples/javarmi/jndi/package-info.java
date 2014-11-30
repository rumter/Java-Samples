/**
 * Пример использования Java RMI с обращением к отдельно запущенному реестру через JNDI.
 * 
 * Запускаем реестр. Варианты: 
 * 1) rmiregistry (из корневого каталога class-файлов).
 * 2) rmiregistry -J-Djava.rmi.server.codebase="file:{path_to_project}/bin/" (из произвольного каталога)
 * 
 * Сервер создает экземляр сервиса, через JNDI регистрирует сервис в реестре
 * 
 * Кдиент запрашивает через JNDI у реестра сервис и делает вызов. 
 * 
 * В api - общий код клиента и сервиса.
 * 
 * @author Ilya Mitin (rumter)
 * 
 */
package ru.rumter.samples.javarmi.jndi;