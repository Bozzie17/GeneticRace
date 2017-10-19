import com.pi4j.io.gpio.*;

/**
 * Created by s213227304 on 2017/10/19.
 */
public class Race {
    private int timeFrame;
    private int[] commands;
    private final GpioController gpio = GpioFactory.getInstance();
    private Pin pwmPin = RaspiPin.GPIO_08;
    private Pin ledPin1 = RaspiPin.GPIO_09;
    private Pin ledPin2 = RaspiPin.GPIO_07;
    private Pin ledPin3 = RaspiPin.GPIO_00;

    GpioPinPwmOutput pwm = gpio.provisionSoftPwmOutputPin(pwmPin);
    private GpioPinDigitalOutput redLED = gpio.provisionDigitalOutputPin(ledPin1);
    private GpioPinDigitalOutput greenLED = gpio.provisionDigitalOutputPin(ledPin2);
    private GpioPinDigitalOutput blueLED = gpio.provisionDigitalOutputPin(ledPin3);

    public Race (int tf, int[] c) {
        timeFrame = tf;
        commands = c;
    }

    public void run() {
        pwm.setPwmRange(255);
        pwm.setPwm(0);
        try {
            redLED.high();
            Thread.sleep(1000);
            greenLED.high();
            Thread.sleep(1000);
            blueLED.high();
            Thread.sleep(2000);
            redLED.low();
            greenLED.low();
            blueLED.low();
            race();
        } catch (Exception ignored) {}
    }

    public void race() {
        for (int i:
             commands) {
            try {
                pwm.setPwm(i);
                Thread.sleep(timeFrame);
            } catch (Exception ignored) {}
        }
        pwm.setPwm(0);
    }
}
