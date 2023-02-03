package javaMid4.ex07;

public class Driver {
	void drive(Vehicle vehicle) {
		vehicle.run();
	}

//	void fare(Vehicle vehicle) {
//		vehicle.money();
//	}
	int fare(Vehicle vehicle) {
		int fare = 0;
		if (vehicle instanceof Bus) {
			fare = 1350;
		} else if (vehicle instanceof Taxi) {
			fare = 3850;
		} else if (vehicle instanceof Subway) {
			fare = 1650;
		}
		return fare;

	}
}
