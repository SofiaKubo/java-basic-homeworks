package ru.otus.java.basic.homeworks.homework_7;

public class Main {
    public static void main(String[] args) {
        runDetailedDemo();
        runTransportInterfaceDemo();
    }

    private static void runDetailedDemo() {
        Human ivan = new Human("Иван");

        Car car = new Car("Toyota", 100);
        AllTerrainVehicle allTerrainVehicle =
                new AllTerrainVehicle("Argo Frontier", 250);
        Bicycle bicycle = new Bicycle("Cube Aim Pro");
        Horse horse = new Horse("Бруно", 150);

        printSection("Подробная демонстрация");
        printSubsection("Пешком");
        ivan.move(5, TerrainType.PLAIN);

        printSubsection("Машина");
        ivan.takeTransport(car);
        ivan.move(20, TerrainType.PLAIN);
        ivan.move(10, TerrainType.FOREST);
        System.out.println("Остаток топлива у машины: " + car.getFuelAmount());
        ivan.leaveTransport();

        printSubsection("Велосипед");
        ivan.takeTransport(bicycle);
        ivan.move(12, TerrainType.FOREST);
        ivan.move(8, TerrainType.SWAMP);
        ivan.leaveTransport();

        printSubsection("Лошадь");
        ivan.takeTransport(horse);
        ivan.move(30, TerrainType.FOREST);
        ivan.move(10, TerrainType.SWAMP);
        System.out.println("Остаток сил у лошади: " + horse.getEnergy());
        ivan.leaveTransport();

        printSubsection("Вездеход");
        ivan.takeTransport(allTerrainVehicle);
        ivan.move(40, TerrainType.SWAMP);
        ivan.move(120, TerrainType.FOREST);
        System.out.println(
                "Остаток топлива у вездехода: " +
                        allTerrainVehicle.getFuelAmount());
        ivan.leaveTransport();
    }

    private static void runTransportInterfaceDemo() {
        Human[] humans = {
                new Human("Иван"),
                new Human("Роман"),
                new Human("Агата"),
                new Human("Рената")
        };

        Transport[] transports = {
                new Car("Nissan", 100),
                new AllTerrainVehicle("Desertcross", 180),
                new Bicycle("Trek Marlin"),
                new Horse("Буцефал", 80)
        };

        printSection("Демонстрация интерфейса Transport");

        for (Transport transport : transports) {
            printSubsection("Транспорт: " + transport.getName());

            for (Human human : humans) {
                human.takeTransport(transport);
                human.move(10, TerrainType.PLAIN);
                human.leaveTransport();
            }
        }
    }

    private static void printSection(String title) {
        System.out.println(title + ":");
    }

    private static void printSubsection(String title) {
        System.out.println();
        System.out.println(title + ":");
    }
}
