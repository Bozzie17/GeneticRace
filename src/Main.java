/**
 * Created by s213227304 on 2017/10/19.
 */
public class Main {
    private static int timeFrame;
    private static int[] commands;

    public static void main(String[] args) {
        if (args.length > 0) {
            timeFrame = Integer.parseInt(args[0]);
            commands = readCommands(timeFrame);
            Race race = new Race(timeFrame, commands);
            race.run();
            // maybe run on its own thread? with the stopwatch also on its own?
        }
    }

    private static int[] readCommands(int difficulty){
        //read in the correct csv and assign values to commands
        return commands;
    }
}
