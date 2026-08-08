import java.util.*;
import java.util.stream.*;

class Sensor {
    String id;
    double temperature;

    Sensor(String id, double temperature) {
        this.id = id;
        this.temperature = temperature;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Sensor> readings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            double temp = sc.nextDouble();
            readings.add(new Sensor(id, temp));
        }

        Map<String, Double> averageTemp = readings.stream()
                .filter(s -> s.temperature > 50)
                .collect(Collectors.groupingBy(
                        s -> s.id,
                        Collectors.averagingDouble(s -> s.temperature)
                ));

        averageTemp.entrySet().stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .forEach(entry ->
                        System.out.println(entry.getKey() + " " + entry.getValue()));

        sc.close();
    }
}