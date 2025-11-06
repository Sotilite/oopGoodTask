package ru.oop.task3;

import java.util.List;

/**
 * <b>Задача 3:</b><br>
 * То же самое, что и задача 2, но добраться нужно с пересадками<br>
 * Можно определить транспортные средства списком:<br>
 * {@code List.of(new Car(person), new Bus("43", person),
 *        new Bus("50", person));}
 * <ul>
 *   <li>Код не должен превышать 12 строк</li>
 *   <li>Запрещено реализовывать конструкторы и методы, кроме moveTo(...)</li>
 *   <li>Запрещено добавлять новые методы в класс Main</li>
 *   <li>Разрешено создавать новые классы и интерфейсы</li>
 *   <li>Все добавленные интерфейсы, классы и методы должны иметь JavaDoc!</li>
 * </ul>
 *
 * @author vpyzhyanov
 * @since 21.10.2020
 */
public class MainTask3 {

    /**
     * Переехать из текущего места в заданную точку
     * на любом транспорте
     * @param person человек
     * @param destination пункт назначения
     * @param transports набор транспорта для передвижения
     */
    public void moveTo(Person person, Position destination, List<Transport> transports) {
        // Мое понимание: человек идет до транспорта, на нем едет до второго.
        // Если первый не доехал, то человек идет пешком до второго.
        // Доходит до второго, на нем едет до третьего и т.д.
        for(int i = 0; i < transports.size() - 1; i++) {
            Transport currentTransport = transports.get(i);
            Transport nextTransport = transports.get(i + 1);
            person.walk(currentTransport.getPosition());
            currentTransport.move(person, nextTransport.getPosition());
        }
        Transport lastTransport = transports.getLast();
        person.walk(lastTransport.getPosition());
        lastTransport.move(person, destination);
        person.walk(destination);
        assert person.getPosition() == destination;
    }
}
