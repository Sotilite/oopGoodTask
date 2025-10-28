package ru.oop.task3;

/**
 * Транспорт для передвижения из точки отправления до места назначения
 */
public interface Transport extends Positioned {

    /**
     * Добраться до нужного места, может не доехать до пункта назначения
     */
    void move(Person person, Position position);
}
