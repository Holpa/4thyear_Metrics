import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		SQLmanager db = new SQLmanager();
		db.connectToDB();
        db.readData();
        db.close();
		Timer timer = new Timer();
		Gui window = new Gui();
		timer.schedule(new DBinvoker(window), 0, 5000);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window.getFrame().setVisible(true);
					//window.setJtext_2(Integer.toString(db.getValue()));
					
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
				window.setJtext_2(Integer.toString(db.getValue()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         //db.insertData();
	         db.close();
	         System.out.print(db.getValue());
		    }
	}

