package ru.otus.java.basic.homeworks.homework_7;

public class Main {
    private static final int CAR_INITIAL_FUEL = 100;
    private static final int ALL_TERRAIN_VEHICLE_INITIAL_FUEL = 250;
    private static final int HORSE_INITIAL_ENERGY = 150;

    private static final int WALK_DISTANCE = 5;
    private static final int CAR_PLAIN_DISTANCE = 20;
    private static final int CAR_FOREST_DISTANCE = 10;
    private static final int BICYCLE_FOREST_DISTANCE = 12;
    private static final int BICYCLE_SWAMP_DISTANCE = 8;
    private static final int HORSE_FOREST_DISTANCE = 30;
    private static final int HORSE_SWAMP_DISTANCE = 10;
    private static final int ALL_TERRAIN_VEHICLE_SWAMP_DISTANCE = 40;
    private static final int ALL_TERRAIN_VEHICLE_FOREST_DISTANCE = 120;

    private static final int DEMO_CAR_INITIAL_FUEL = 100;
    private static final int DEMO_ALL_TERRAIN_VEHICLE_INITIAL_FUEL = 180;
    private static final int DEMO_HORSE_INITIAL_ENERGY = 80;
    private static final int TRANSPORT_DEMO_DISTANCE = 10;

    public static void main(String[] args) {
        runDetailedDemo();
        runTransportInterfaceDemo();
    }

    private static void runDetailedDemo() {
        Human ivan = new Human("Иван");

        Car car = new Car("Toyota", CAR_INITIAL_FUEL);
        AllTerrainVehicle allTerrainVehicle =
                new AllTerrainVehicle("Argo Frontier", ALL_TERRAIN_VEHICLE_INITIAL_FUEL);
        Bicycle bicycle = new Bicycle("Cube Aim Pro");
        Horse horse = new Horse("Бруно", HORSE_INITIAL_ENERGY);

        printSection("Подробная демонстрация");
        printSubsection("Пешком");
        ivan.move(WALK_DISTANCE, TerrainType.PLAIN);

        printSubsection("Машина");
        ivan.takeTransport(car);
        ivan.move(CAR_PLAIN_DISTANCE, TerrainType.PLAIN);
        ivan.move(CAR_FOREST_DISTANCE, TerrainType.FOREST);
        System.out.println("Остаток топлива у машины: " + car.getFuelAmount());
        ivan.leaveTransport();

        printSubsection("Велосипед");
        ivan.takeTransport(bicycle);
        ivan.move(BICYCLE_FOREST_DISTANCE, TerrainType.FOREST);
        ivan.move(BICYCLE_SWAMP_DISTANCE, TerrainType.SWAMP);
        ivan.leaveTransport();

        printSubsection("Лошадь");
        ivan.takeTransport(horse);
        ivan.move(HORSE_FOREST_DISTANCE, TerrainType.FOREST);
        ivan.move(HORSE_SWAMP_DISTANCE, TerrainType.SWAMP);
        System.out.println("Остаток сил у лошади: " + horse.getEnergy());
        ivan.leaveTransport();

        printSubsection("Вездеход");
        ivan.takeTransport(allTerrainVehicle);
        ivan.move(ALL_TERRAIN_VEHICLE_SWAMP_DISTANCE, TerrainType.SWAMP);
        ivan.move(ALL_TERRAIN_VEHICLE_FOREST_DISTANCE, TerrainType.FOREST);
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
                new Car("Nissan", DEMO_CAR_INITIAL_FUEL),
                new AllTerrainVehicle("Desertcross", DEMO_ALL_TERRAIN_VEHICLE_INITIAL_FUEL),
                new Bicycle("Trek Marlin"),
                new Horse("Буцефал", DEMO_HORSE_INITIAL_ENERGY)
        };

        printSection("Демонстрация интерфейса Transport");

        for (Transport transport : transports) {
            printSubsection("Транспорт: " + transport.getName());

            for (Human human : humans) {
                human.takeTransport(transport);
                human.move(TRANSPORT_DEMO_DISTANCE, TerrainType.PLAIN);
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
