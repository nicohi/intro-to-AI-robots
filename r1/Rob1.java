import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class Rob1 {
    static DifferentialPilot pilot = new DifferentialPilot(5.6, 17.5f, Motor.A, Motor.B);
    static UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S2);
    static LightSensor light = new LightSensor(SensorPort.S1);

    static double r = 10.0;

    static double d = 50.0; //max cm

    static int hi = 100;
    //int lo = 0;
    
    static int delay = 100;

    public static void main(String[] args) {
        while(true) go();
    }

    public static void go() {
        pilot.travelArc(r,d,true);
        while(onRight()) {
            //Button.waitForAnyPress();
            Delay.msDelay(delay);
        }
        //pilot.stop();
        pilot.quickStop();
        if (r < 0) Sound.playNote(Sound.XYLOPHONE, 523, 700); //C5
        else Sound.playNote(Sound.XYLOPHONE, 659, 700); //E5
        r *= -1.0;
    }

    public static boolean onRight() {
        if (r > 0) return light.readValue() < hi;
        return light.readValue() >= hi;
    }
}
