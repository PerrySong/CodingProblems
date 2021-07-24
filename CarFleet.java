import java.util.Arrays;

public class CarFleet {
    class Car implements Comparable<Car> {
        int position;
        double timeToTarget;
        public int compareTo(Car car2) {
            return car2.position - this.position;
        }
    }

    // O(N)
    // O(N lg N)
    public int carFleet(int target, int[] position, int[] speed) {

        Car[] cars = new Car[position.length];

        for (int i = 0; i < cars.length; i++) {
            Car car = new Car();
            car.position = position[i];
            car.timeToTarget = (target - position[i]) / (double) speed[i];
            cars[i] = car;
        }

        Arrays.sort(cars);

        int res = 1;
        Car leadCar = cars[0];
        for (int i = 1; i < cars.length; i++) {
            Car curCar = cars[i];
            if (curCar.timeToTarget > leadCar.timeToTarget) {
                res++;
                leadCar = curCar;
            }
        }
        return res;
    }
}
