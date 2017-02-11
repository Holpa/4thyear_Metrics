import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

/**
 * to do:
 * exceptions related to DB connections
 * add snapshot feature
 * do Linux Commands.
 * @author Ahmad
 *
 */
public class Main {
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		LinuxTerminal lT= new LinuxTerminal();
		lT.WindowsGetIP();
		Timer timer = new Timer();
		Gui window = new Gui();
		timer.schedule(new DBinvoker(window), 0, 5000);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}	

class DBinvoker extends TimerTask{
	Gui window;
	public DBinvoker(Gui window) {
		this.window = window;
	}

	public void run() {
		SQLmanager db = new SQLmanager();
		try {
			db.connectToDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			db.readData();
			window.setJtext(Integer.toString(db.getLoadValue()));
			window.setJtext_2(Integer.toString(db.getRamValue()));
			window.setJtext_3(Integer.toString(db.getTempValue()));
			window.setJtext_4(Integer.toString(db.getDisValue()));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			db.insertData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();

	}
}

