import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class Rob2 {
    static DifferentialPilot pilot = new DifferentialPilot(5.6, 17.5f, Motor.A, Motor.B);
    static UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S2);
    static LightSensor light = new LightSensor(SensorPort.S1);

    static int md = 10;

    static int b = 40;

    public static void main(String[] args) {
        go();
    }

    public static void go() {
        findSpot();
        pilot.travel(-20);
        int d = sonic.getDistance();
        pilot.rotate(90);
        pilot.travel(d-5);
        pilot.rotate(-90);
    }

    public static void findSpot(){
        boolean in = false
        int d = sonic.getDistance();
        int w = 0;
        while (true) {
            if (sonic.getDistance() - d >= b) in = true;
            else {
                in = false;
                w = 0;
            }
            pilot.travel(md)
            if (in) w+=md;
        }
    }
}
