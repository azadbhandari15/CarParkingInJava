import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ParkingLot {

    private final BlockingQueue<Car> parkingSpots;

    public ParkingLot(int capacity) {
        this.parkingSpots = new ArrayBlockingQueue<>(capacity);
    }

    public void parkCar(Car car) throws InterruptedException{
        parkingSpots.put(car);
        System.out.println("Car has been parked with number "+car.getLicensePlate());
    }

    public Car leaveCar() throws InterruptedException{
        Car car=parkingSpots.take();
        System.out.println(car.getLicensePlate()+" left.");
        return car;
    }

    public int availableSpots(){
        return parkingSpots.remainingCapacity();
    }
}
