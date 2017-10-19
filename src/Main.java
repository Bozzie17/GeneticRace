import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Created by s213227304 on 2017/10/19.
 */
public class Main {
    private final GpioController gpio = GpioFactory.getInstance();
    private Pin pwmPin = RaspiPin.GPIO_08;
    private Pin ledPin1 = RaspiPin.GPIO_09;
    private Pin ledPin2 = RaspiPin.GPIO_07;
}
