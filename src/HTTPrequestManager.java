import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPrequestManager {

	private int Value= 2000;
	/*
	public static void main(String[] args) throws Exception {

		HTTPrequestManager http = new HTTPrequestManager();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();

	}
	 */
	// HTTP GET request
	public void retrieveResource() throws Exception {

		String url = "http://127.0.0.1:8080/~/in-cse";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("X-M2M-Origin", "admin:admin");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result

		System.out.println(response.toString());
		writeFile("retrieveResource",response.toString());

	}

	// HTTP POST request
	public void createSensor(boolean unlimited) throws Exception {

		
		if(!unlimited)
		{
			this.Value = 1;
		}
		for(int i=0; i< Value ; i++)
		{
			String url = "http://127.0.0.1:8080/~/in-cse";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			int responseCode=0;
			//add reuqest header

			con.setRequestMethod("POST");
			con.setRequestProperty("X-M2M-Origin", "admin:admin");
			con.setRequestProperty("Content-Type", "application/xml;ty=2");
			String urlParameters = "<m2m:ae xmlns:m2m="+"\"http://www.onem2m.org/xml/protocols\""+" rn="+"\"MY_SENSOR2\" >"
					+"<api>app-sensor</api>"
					+"<lbl>Type/sensor Category/temperature Location/home</lbl>"
					+"<rr>false</rr>"
					+"</m2m:ae>";
			con.setRequestProperty("Content-Length", Integer.toString(urlParameters.length()));
			// Send post request
			con.setDoOutput(true);
			con.setDoInput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			con.getOutputStream().write(urlParameters.getBytes("UTF8"));
			//wr.write(urlParameters.getBytes("UTF-8"));
			wr.flush();
			wr.close();
			responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
			if(responseCode == 201)
			{
				BufferedReader in = new BufferedReader(
						new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				in.close();
				writeFile("createSensor",response.toString());
			}else
			{
				writeFile("createSensor","response Code with ERROR: "+responseCode);
			}

		}

	}
	public void discoverResourcesBasedOnLabel() throws Exception {

		String url = "http://127.0.0.1:8080/~/in-cse?fu=1&lbl=Type/sensor";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Accept","application/xml");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		writeFile("discoverResourcesBasedOnLabel",response.toString());
		System.out.println(response.toString());
	}

	public void writeFile(String filename, String Data)
	{

		try(FileWriter fw = new FileWriter(filename+".txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
		{
			out.println("\n \n"+Data);
		} catch (IOException e) {
			//exception handling left as an exercise for the reader
			try{
				PrintWriter writer = new PrintWriter(filename+".txt", "UTF-8");
				writer.println(Data);
				writer.close();
			} catch (IOException ei) {
				// do something
			}
		}

	}

	public void subScripeMonitor() throws IOException {
		// TODO Auto-generated method stub

		String url = "http://127.0.0.1:8080/~/in-cse/in-name/MY_SENSOR/DATA";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		int responseCode=0;
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Content-Type", "application/xml;ty=23");

		String urlParameters = "<m2m:sub xmlns:m2m="+"\"http://www.onem2m.org/xml/protocols\""+" rn="+"\"SUB_MY_SENSOR\">"
				+"<nu>http://localhost:1400/monitor</nu>"
				+"<nct>2</nct>"
				+"</m2m:sub>";
		con.setRequestProperty("Content-Length", Integer.toString(urlParameters.length()));
		// Send post request
		con.setDoOutput(true);
		con.setDoInput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		con.getOutputStream().write(urlParameters.getBytes("UTF8"));
		//wr.write(urlParameters.getBytes("UTF-8"));
		wr.flush();
		wr.close();
		responseCode = con.getResponseCode();
		writeFile("subScripeMonitor","Error Occured with code of"+responseCode+"\n ");
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		writeFile("subScripeMonitor",response.toString());
		System.out.println(response.toString());
	}

	public void pushDatatoContainer() throws IOException {
		// TODO Auto-generated method stub
		String url = "http://127.0.0.1:8080/~/in-cse/in-name/MY_SENSOR/DATA";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		int responseCode=0;
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Content-Type", "application/xml;ty=4");

		String urlParameters = "<m2m:cin xmlns:m2m="+"\"http://www.onem2m.org/xml/protocols\">"
				+"<cnf>message</cnf>"
				+"<con>"
				+"&lt;obj&gt;"
				+"&lt;str name=&quot;appId&quot; val=&quot;MY_SENSOR&quot;/&gt;"
				+"&lt;str name=&quot;category&quot; val=&quot;temperature &quot;/&gt;"
				+"&lt;int name=&quot;data&quot; val=&quot;27&quot;/&gt;"
				+"&lt;int name=&quot;unit&quot; val=&quot;celsius&quot;/&gt;"
				+"&lt;/obj&gt;"
				+"</con>"
				+"</m2m:cin>";
		con.setRequestProperty("Content-Length", Integer.toString(urlParameters.length()));
		// Send post request
		con.setDoOutput(true);
		con.setDoInput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		con.getOutputStream().write(urlParameters.getBytes("UTF8"));
		wr.flush();
		wr.close();
		responseCode = con.getResponseCode();
		writeFile("Data_Sent","Error Occured with code of"+responseCode+"\n ");
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		writeFile("Data_Sent",response.toString());
		System.out.println(response.toString());
	}

	public void createDataContainer() throws Exception {
		// TODO Auto-generated method stub
		String url = "http://127.0.0.1:8080/~/in-cse/in-name/MY_SENSOR";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		int responseCode=0;
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Content-Type", "application/xml;ty=3");

		String urlParameters = "<m2m:cnt xmlns:m2m="+"\"http://www.onem2m.org/xml/protocols\""+" rn="+"\"DATA\""+">"
				+"<cnf>message</cnf>"
				+"</m2m:cnt>";
		con.setRequestProperty("Content-Length", Integer.toString(urlParameters.length()));
		// Send post request
		con.setDoOutput(true);
		con.setDoInput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		con.getOutputStream().write(urlParameters.getBytes("UTF8"));
		wr.flush();
		wr.close();
		responseCode = con.getResponseCode();
		writeFile("createDataContainer","Error Occured with code of"+responseCode+"\n ");
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		writeFile("createDataContainer",response.toString());
		System.out.println(response.toString());
	}
}