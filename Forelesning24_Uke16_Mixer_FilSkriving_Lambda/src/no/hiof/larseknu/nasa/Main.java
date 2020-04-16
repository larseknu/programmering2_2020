package no.hiof.larseknu.nasa;

import no.hiof.larseknu.nasa.model.Planet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static List<Planet> planets = new ArrayList<>();

    public static void main(String[] args) {
        readDataFromFile("planets.csv");

        for (Planet planet : planets)
            System.out.println(planet.getName() + " mass "  + planet.getMass());

        writeDataToFile("newplanets2.csv", ",");

        NotGenericTest isFactor = new NotGenericTest() {
            @Override
            public boolean test(int a, int b) {
                return (a % b) == 0;
            }
        };
        GenericTest<Integer> isFactorGen = (a, b) -> (a % b) == 0;

        System.out.println(isFactor.test(12, 6));
        System.out.println(isFactorGen.test(12, 6));

        GenericTestReturn<String, Boolean> contains = (a, b) -> a.contains(b);
        GenericTestReturn<String, String> merge = (a, b) -> a + " " + b;

        System.out.println(contains.test("Uranus", "Ur"));
        System.out.println(merge.test("How you,", "doin'?"));

        Collections.sort(planets, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        printConditionally(planets, p -> p.getName().startsWith("K"), p -> System.out.println(p.getName()));

        printConditionally(planets, p -> p.getMass() > 7000, p -> System.out.println(p.getName() + " - " + p.getMass()));
    }

    public static void printConditionally(List<Planet> planets, Predicate<Planet> condition, Consumer<Planet> consumer) {
        for (Planet planet : planets) {
            if (condition.test(planet))
                consumer.accept(planet);
        }
    }

    public static void readDataFromFile(String filename) {
        File file = new File(filename);

        try {
            List<String> lines = Files.readAllLines(file.toPath());

            for (String line : lines) {
                if (line.startsWith("#"))
                    continue;

                String[] parts = line.split(",", -1);

                String name = parts[1];
                String discoveryMethod = parts[2];
                String orbitalPeriodStr = parts[3];
                String massStr = parts[6];
                String radiusStr = parts[7];

                double orbitalPeriod = (orbitalPeriodStr.isEmpty() ? 0 : Double.parseDouble(orbitalPeriodStr));
                double mass = (massStr.isEmpty() ? 0 : Double.parseDouble(massStr));
                double radius = (radiusStr.isEmpty() ? 0 : Double.parseDouble(radiusStr));

                Planet planet = new Planet(name, discoveryMethod, orbitalPeriod, mass, radius);

                planets.add(planet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataToFile(String filename, String delimiter) {

        try (FileWriter fileWriter = new FileWriter(filename)) {
            for (Planet planet : planets) {
                fileWriter.append(planet.getName());
                fileWriter.append(delimiter);
                fileWriter.append(planet.getDiscoveryMethod());
                fileWriter.append(delimiter);
                fileWriter.append(String.valueOf(planet.getOrbitalPeriod()));
                fileWriter.append(delimiter);
                fileWriter.append(String.valueOf(planet.getMass()));
                fileWriter.append(delimiter);
                fileWriter.append(String.valueOf(planet.getRadius()));
                fileWriter.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

interface Condition<T> {
    boolean test(T p);
}

interface NotGenericTest {
    boolean test(int a, int b);
}

interface GenericTest<T> {
    boolean test(T a, T b);
}

interface GenericTestReturn<T, R> {
    R test(T a, T b);
}
