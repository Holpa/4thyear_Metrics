import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HTTPrequestManager {

	private final String USER_AGENT = "Mozilla/5.0";
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

	}

	// HTTP POST request
	public void createSensor() throws Exception {

		String url = "http://127.0.0.1:8080/~/in-cse";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("X-M2M-Origin", "admin:admin");
		con.setRequestProperty("Content-Type", "application/xml;ty=2");

		String urlParameters = "<m2m:ae xmlns:m2m="+"\"http://www.onem2m.org/xml/protocols\""+" rn="+"\"MY_SENSOR\" >"
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

		int responseCode = con.getResponseCode();
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
		System.out.println(response.toString());

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
		System.out.println(response.toString());
	}
}