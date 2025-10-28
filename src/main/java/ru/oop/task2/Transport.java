package ru.oop.task2;

/**
 * Транспорт для передвижения от точки отправления до пункта назначения
 */
public interface Transport extends Positioned {

    /**
     * Добраться до нужного места, может не доехать до пункта назначения
     */
    public void move(Person person, Position destination);
}
