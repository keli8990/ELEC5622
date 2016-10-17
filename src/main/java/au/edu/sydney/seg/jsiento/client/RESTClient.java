package au.edu.sydney.seg.jsiento.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RESTClient {

	public void sendPOST(String postURL, String postString){
		
		try {
			 
			URL url = new URL(postURL);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			OutputStream os = conn.getOutputStream();
			os.write(postString.getBytes());
			os.flush();			
	 
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				//TODO: Data insert failed!
				//System.out.println("Data insert failed. \n");
			}
			
			System.out.print("Output from Server: ");
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));	 
			System.out.println(br.readLine());
			
			conn.disconnect();
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {	 
			//e.printStackTrace();
			System.err.println("Could not find the URL: "+ postURL+"\n"); 
		 }
		
	}
	public void sendGET(String getURL){
		try {
			 
			URL url = new URL(getURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
	 
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
	 
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 
			conn.disconnect();
	 
		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }
	}
}
