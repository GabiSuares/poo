import java.util.ArrayList;

abstract class Vehicle {
    private String plate;
    private String brand;
    private String model;

    public Vehicle(String plate, String brand, String model) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    public String getPlate() {
    return plate;
    }

    public void setPlate(String plate) {
    this.plate = plate;
    }

    public String getBrand() {
    return brand;
    }

    public void setBrand(String brand) {
    this.brand = brand;
    }

    public String getModel() {
    return model;
    }

    public void setModel(String model) {
    this.model = model;
    }

    public abstract double calculateParkingFee(int hours);

    public String toString() {
    return "Plate: " + plate + " - Brand: " + brand + " - Model: " + model;
    }
}

class Car extends Vehicle {
public Car(String plate, String brand, String model) {
super(plate, brand, model);
    }

public double calculateParkingFee(int hours) {
return hours * 5.0;
    }

public String toString() {
return "Car - " + super.toString();
    }
}

class Motorcycle extends Vehicle {
public Motorcycle(String plate, String brand, String model) {
super(plate, brand, model);
    }

public double calculateParkingFee(int hours) {
return hours * 3.0;
    }

public String toString() {
return "Motorcycle - " + super.toString();
    }
}

class Truck extends Vehicle {
public Truck(String plate, String brand, String model) {
super(plate, brand, model);
    }

public double calculateParkingFee(int hours) {
return hours * 10.0;
    }
public String toString() {
return "Truck - " + super.toString();
    }
}

public class ParkingApp {
public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
vehicles.add(new Car("ABC-1234", "Toyota", "Corolla"));
vehicles.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
vehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));

for (Vehicle v : vehicles) {
System.out.println("Vehicle: " + v.toString());
System.out.printf("Parking fee for 4h: R$ %.2f%n%n", v.calculateParkingFee(4));
        }
    }
}