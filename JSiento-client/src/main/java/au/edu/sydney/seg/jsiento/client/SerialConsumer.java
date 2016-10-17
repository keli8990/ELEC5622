package au.edu.sydney.seg.jsiento.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import au.edu.sydney.seg.jsiento.client.FeatureExtractor;

public class SerialConsumer implements SerialPortEventListener {
	SerialPort serialPort;
    /** The port we're normally going to use. */
	private static final String PORT_NAMES[] = { 
		"/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyACM0", // Raspberry Pi
        "/dev/ttyUSB0", // Linux
		"COM3" // Windows
	};
	/**
	* A BufferedReader which will be fed by a InputStreamReader 
	* converting the bytes into characters 
	* making the displayed results codepage independent
	*/
	private BufferedReader input;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port.115200 */
	private static final int DATA_RATE = 115200;
	/** Maximum recording time in seconds */
 	private static final int MAX_RECORDING_TIME=7200; // 2 hours
	private static BufferedWriter writer = null;
	/** Size of time windows for feature extraction */
	private static final int SEGMENT_WINDOW_SIZE=10000; // 10 seconds
	/** POST URL to handle the REST service */
	private static final String POST_URL="http://localhost:8080/JSiento-server/feature/post";
	/** A RESTClient object for sending POST requests */
	private static RESTClient bioRESTClient;
	/** A FeatureExtractor object for feature extraction */
	private static FeatureExtractor featExtractor;
	private static long segmentStartTime;

	/**
	 * Initialize the application
	*/
	public void initialize() {
		
		System.setProperty("http.proxyHost", "web-cache.usyd.edu.au");
		System.setProperty("http.proxyPort", "8080");
		
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		//First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}
		if (portId == null) {
			System.out.println("Could not find COM port.");
			return;
		}
		// Create featureExtractor object
		featExtractor=new FeatureExtractor();
		bioRESTClient=new RESTClient();
		// Start segmentTimer
		segmentStartTime=System.currentTimeMillis();
		
		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the input stream
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
			// ------------------
			// Create output file
            String timeLog = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
            File logFile = new File(timeLog+".csv");
            // Print output file full path
            System.out.println(logFile.getCanonicalPath());
            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write("TimeStamp, HR , SC \n ");
            
            
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
	*/
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				// read sensor data
				String inputLine=input.readLine();
				
				System.out.println(inputLine);
				// Check time for calculating features
				long currentTime=System.currentTimeMillis();
				long EndTime=System.currentTimeMillis();;
				String dataTimeStamp = new SimpleDateFormat("HH-mm-ss").format(currentTime);
				if (currentTime-segmentStartTime < SEGMENT_WINDOW_SIZE)
				{
					// CASE 1: Store data 
					// Store data for feature extraction
					featExtractor.addRawData(inputLine);
					// Print time stamp to the .csv file
					writer.write(dataTimeStamp+",");
					// Print sensor data to the .csv file
					//System.out.println(inputLine);
					writer.write(inputLine+"\n");
					writer.flush();		
				}
				else{		
					// CASE 2: Calculate features and send to server
					String postStr= featExtractor.extractFeatures(new Date(currentTime));
					
					// Clear featureExtractor
					featExtractor.clearExtractor();
					// Reset segment timer
					segmentStartTime=System.currentTimeMillis();
					// Send JSON to the server
					//bioRESTClient.sendPOST(POST_URL, postStr);
					// ------------------------------------- Thread
					class OneShotTask implements Runnable {
				        String urlStr;
				        String pStr;				        
				        OneShotTask(String url,String p) { urlStr = url; pStr=p; }
				        public void run() {
				        	bioRESTClient.sendPOST(urlStr, pStr);
				        }
				    }
				    Thread t = new Thread(new OneShotTask(POST_URL,postStr));
				    t.start();
				    // ------------------------------------- Thread
					EndTime=System.currentTimeMillis();
					System.out.println(EndTime-currentTime);
				}
				
					
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
	}
	
	/**
	 * This should be called when you stop using the port.
	 * This will prevent port locking on platforms like Linux.
	*/
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
			// Close writer stream
			try {
				writer.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		SerialConsumer main = new SerialConsumer();
		main.initialize();
		Thread t=new Thread() {
			public void run() {
				//waiting for events to occur and responding to them.
				try {Thread.sleep(MAX_RECORDING_TIME);} catch (InterruptedException ie) {}
			}
		};
		t.start();
		System.out.println("Started");
	}
}



