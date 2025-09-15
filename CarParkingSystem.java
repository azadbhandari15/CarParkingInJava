public class CarParkingSystem {

    public static void main(String[] args) {
        ParkingLot parkingLot=new ParkingLot(5);

        Runnable carProducer=()->{
            int carNumber=1;
            while(true){
                try {
                    Car car = new Car("Car-" + carNumber++);
                    parkingLot.parkCar(car);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        Runnable carConsumer=()->{
            while(true){
                try {
                    Thread.sleep(1000);
                    parkingLot.leaveCar();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        new Thread(carProducer).start();
        new Thread(carConsumer).start();
    }
}
