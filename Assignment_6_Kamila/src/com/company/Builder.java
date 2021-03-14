package com.company;

public class Builder {
}
// Using the Builder pattern makes sense only when your products
// are quite complex and require extensive configuration. The
// following two products are related, although they don't have
// a common interface.
public class Car {
    private Car car;
    private int seats;
    private Engine engine;
    private TripComputer tripComputer;
    private Transmission transmission;
    private GPS gps;
// A car can have a GPS, trip computer and some number of
// seats. Different models of cars (sports car, SUV,
// cabriolet) might have different features installed or
// enabled.

    public Car(Car car, int seats, Engine engine, TripComputer tripComputer, Transmission transmission, GPS gps) {
        this.car = car;
        this.seats = seats;
        this.engine = engine;
        this.tripComputer = tripComputer;
        this.transmission = transmission;
        this.gps = gps;
    }

    public Car getCar() {
        return car;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public GPS getGps() {
        return gps;
    }
}
// Each car should have a user manual that corresponds to
// the car's configuration and describes all its features.

public class Manual {
    private Car car;
    private int seats;
    private Engine engine;
    private TripComputer tripComputer;
    private Transmission transmission;
    private GPS gps;
// A car can have a GPS, trip computer and some number of
// seats. Different models of cars (sports car, SUV,
// cabriolet) might have different features installed or
// enabled.

    public Manual(Car car, int seats, Engine engine, TripComputer tripComputer, Transmission transmission, GPS gps) {
        this.car = car;
        this.seats = seats;
        this.engine = engine;
        this.tripComputer = tripComputer;
        this.transmission = transmission;
        this.gps = gps;
    }

}
// The builder interface specifies methods for creating the
// different parts of the product objects.
public interface Builder {
    void reset();

    void setSeats(int seats);

    void setEngine(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPS(GPS gps);
}

// The concrete builder classes follow the builder interface and
// provide specific implementations of the building steps. Your
// program may have several variations of builders, each
// implemented differently.
public class CarBuilder implements Builder{
        private Car car;
        private int seats;
        private Engine engine;
        private TripComputer tripComputer;
        private Transmission transmission;
        private GPS gps;
        // A fresh builder instance should contain a blank product
        // object which it uses in further assembly.

        // The reset method clears the object being built.
        @Override
        public void reset() {
            this.car = new Car();
        }
        // All production steps work with the same product instance.
        @Override
        public void setSeats(){
            this.seats=seats;
        }
        // Set the number of seats in the car.
        @Override
        public void setEngine(Engine engine){
            this.engine=engine;
        }
        // Install a given engine.
        @Override
        public void setTripComputer(TripComputer tripComputer){
            this.TripComputer=tripComputer;
        }
        // Install a trip computer.
        @Override
        public void setGPS(GPS gps){
            this.gps=gps;
        }
}
        // Install a global positioning system.

        // Concrete builders are supposed to provide their own
        // methods for retrieving results. That's because various
        // types of builders may create entirely different products
        // that don't all follow the same interface. Therefore such
        // methods can't be declared in the builder interface (at
        // least not in a statically-typed programming language).
        //
        // Usually, after returning the end result to the client, a
        // builder instance is expected to be ready to start
        // producing another product. That's why it's a usual
        // practice to call the reset method at the end of the
        // `getProduct` method body. However, this behavior isn't
        // mandatory, and you can make your builder wait for an
        // explicit reset call from the client code before disposing
        // of the previous result.
        public Car getProduct() {
            return new Car(seats, engine, transmission, tripComputer, gps);
        }
}
// Unlike other creational patterns, builder lets you construct
// products that don't follow the common interface.
class CarManualBuilder implements Builder {
    private Car car;
    private int seats;
    private Engine engine;
    private TripComputer tripComputer;
    private Transmission transmission;
    private GPS gps;

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    // Document car seat features.
    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    // Add engine instructions.
    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    // Add trip computer instructions.
    @Override
    public void setGPS(GPS gps) {
        this.gps = gps;
    }

    // Add GPS instructions.
    public Manual getProduct() {
        return new Manual(seats, engine, transmission, tripComputer, gps);
    }
}
// Return the manual and reset the builder.


// The director is only responsible for executing the building
// steps in a particular sequence. It's helpful when producing
// products according to a specific order or configuration.
// Strictly speaking, the director class is optional, since the
// client can control builders directly.



// The client code creates a builder object, passes it to the
// director and then initiates the construction process. The end
// result is retrieved from the builder object.

        public static void main(String[] args){
        Database database=Database.getInstance();

        CarBuilder builder=new CarBuilder();

        Car car=builder.getProduct();

        CarManualBuilder builder=new CarManualBuilder();


        // The final product is often retrieved from a builder
        // object since the director isn't aware of and not
        // dependent on concrete builders and products.
        Manual manual=builder.getProduct();
        }
}