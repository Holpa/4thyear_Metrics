import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * test test
 * @author Ahmad
 *
 */
public class LinuxTerminal {

	public String WindowsGetIP() throws IOException
	{
		String g = "";
		Process p = Runtime.getRuntime().exec(new String[] {"ipconfig", g});
		InputStream s = p.getInputStream();

		BufferedReader in = new BufferedReader(new InputStreamReader(s));
		String temp;
		String rString = "";
		while ((temp = in.readLine()) != null) {
			rString+= temp;
			rString+="\n";
		    System.out.println(temp);
		}
		return rString;
	}
	
	public String get_load()
	{
/*
 *     try:
        s = subprocess.check_output(["cat","/proc/loadavg"])
        return float(s.split()[0])
    except:
        return 0
 */
		
		// under experiment
		/*
		 * System.out.println("Total CPU-usage:" + JVMFactory.getJVM().getMachine().getCPULoad());

System.out.println("Total JVM-load :" + JVMFactory.getJVM().getJVMLoad());

for(Iterator it = JVMFactory.getJVM().getMachine().getCPUs().iterator(); it.hasNext();)
{
   CPU cpu = (CPU)it.next();
   System.out.println("CPU Description: " + cpu.getDescription());
   System.out.println("CPU Clock Frequency: " + cpu.getClockFrequency());
   System.out.println("CPU Load: " + cpu.getLoad());
   System.out.println();
}
		 */
		return"";
	}
	public String get_ram()
	{
		/*
		 *     try:
        s = subprocess.check_output(["free","-m"])
        lines = s.split("\n")
        used_mem = float(lines[1].split()[2])
        total_mem = float(lines[1].split()[1])
        return (int((used_mem/total_mem)*100))
    except:
        return 0
		 */
		return "";
	}
	public String get_disk()
	{
		/*
		 *     try:
        s = subprocess.check_output(["df","/dev/root"])
        lines = s.split("\n")
        return int(lines[1].split("%")[0].split()[4])
    except:
        return 0
		 */
		return "";
	}
	public String get_temprature()
	{
		/*
		 *     try:
        dir_path="/opt/vc/bin/vcgencmd"
        s = subprocess.check_output([dir_path,"measure_temp"])
        return float(s.split("=")[1][:-3])
    except:
        return 0
		 */
		return "";
	}
}

// this is example of IP config call to linux
/*
String mode = null;
try
{
     String[] cmd = {"xterm -e /sbin/ifconfig -a"};
 Process p = Runtime.getRuntime().exec(cmd);
 BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
 mode = br.readLine();
 //String s;
 //while ((s = br.readLine()) != null) {
     // process the line
 //}
 //System.out.println(mode);
 p.waitFor();
 br.close();
}
catch (IOException e) {} // should probably deal with this
catch (InterruptedException e) {}
return mode;
*/
