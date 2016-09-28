package innerClass;
import javax.swing.JOptionPane;


public class Client {

	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();
		JOptionPane.showMessageDialog(null,"Quit program?");
		System.exit(0);
//		TalkingClock.TimePrinter a = new TalkingClock(1000, true).new TimePrinter();

	}

}
