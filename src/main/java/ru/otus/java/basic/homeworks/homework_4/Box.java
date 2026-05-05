package ru.otus.java.basic.homeworks.homework_4;

public class Box {

    private final int length;
    private final int width;
    private final int height;
    private String color;
    private boolean isOpen;
    private String item;

    public Box(int length, int width, int height, String color) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isOpen = false;
        this.item = null;
    }

    public void open() {
        if (isOpen) {
            System.out.println("Коробка уже открыта");
        } else {
            isOpen = true;
            System.out.println("Коробка открыта");
        }
    }

    public void close() {
        if (!isOpen) {
            System.out.println("Коробка уже закрыта");
        } else {
            isOpen = false;
            System.out.println("Коробка закрыта");
        }
    }

    public void repaint(String newColor) {
        color = newColor;
        System.out.println("Коробка перекрашена в цвет: " + color);
    }

    public void printInfo() {
        System.out.println("Размер коробки: " + length + " x " + width + " x " + height);
        System.out.println("Цвет: " + color);
        System.out.println("Состояние: " + (isOpen ? "открыта" : "закрыта"));
        System.out.println("Предмет внутри: " + (item == null ? "отсутствует" : item));
    }

    public void putItem(String item) {
        if (!isOpen) {
            System.out.println("Нельзя положить предмет: коробка закрыта");
            return;
        }

        if (this.item != null) {
            System.out.println("Нельзя положить предмет: коробка уже заполнена");
            return;
        }

        this.item = item;
        System.out.println("В коробку положили предмет: " + item);
    }

    public void removeItem() {
        if (!isOpen) {
            System.out.println("Нельзя достать предмет: коробка закрыта");
            return;
        }

        if (item == null) {
            System.out.println("В коробке нет предмета");
            return;
        }

        System.out.println("Из коробки достали предмет: " + item);
        item = null;
    }

}
