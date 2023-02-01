package javaMid3.ex10;

public class TV {
	boolean power;
	int channel;

	void power() {
		power = !power;

	}

	void channelUp() {
		++channel;
	}

	void channelDown() {
		--channel;
	}

}