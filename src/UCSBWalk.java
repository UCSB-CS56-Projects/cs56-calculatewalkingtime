import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Scanner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.lang.*;
import java.util.*;

/**
 * An application used to get walking/bicycling times around UCSB campus.
 * 
 * @author 
 *
 *
 */
public class UCSBWalk {

    private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

    /**
     * Main class, gets the starting and ending building and whether the user is biking or walking.
     * Calls the go method with appropriate parameters.
     */
    public static String result;
    public static void calculate(String Building1, String Building2, String method) {

	
	
	
	
	String startBuild = Building1;
	String endBuild = Building2;
	String mode = method;
	String startLat = null;
	String startLong = null;
	String endLat = null;
	String endLong = null;
	String check = null;
	String check1 = null;
	
	
	
	//File file = new File("LatLong.txt");

	File file = new File(ClassLoader.getSystemResource("LatLong.txt").getFile());
	try {
	    
	    Scanner scanner = new Scanner(file);
	    scanner.useDelimiter(","); 
	    check = scanner.next();
	    
	    
	    while (!check.equals(startBuild)){
		
		
		
		startLat = scanner.next();
		startLong = scanner.next();
		
		check = scanner.next();
		
		
		
	    }
	    
	    
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	
	//File file1 = new File("LatLong.txt");
	
	try {
	    
	    Scanner scanner1 = new Scanner(file);
	    scanner1.useDelimiter(","); 
	    
	    check1 = scanner1.next();
	    
	    
	    
	    while (!check1.equals(endBuild)){
		endLat = scanner1.next();
		endLong = scanner1.next();
		
		check1 = scanner1.next();
		
		
		
	    }
	    
	    
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	
	
	
	String unFixedResult =  go(startLong, startLat, endLong, endLat, mode);
	int indexOfNewLine = unFixedResult.indexOf('\n');
	int indexOfsec = unFixedResult.indexOf('\n', indexOfNewLine+1);
	result = "This route will take" + unFixedResult.substring(indexOfsec, unFixedResult.length());
	

    }

    public static void calc747(String Building1, String Building2){
	String startBuild = Building1;
	String endBuild = Building2;
	String startLat = null;
	String startLong = null;
	String endLat = null;
	String endLong = null;
	String check = null;
	String check1 = null;
	
	
	
	File file = new File(ClassLoader.getSystemResource("LatLong.txt").getFile());
	
	try {
	    
	    Scanner scanner = new Scanner(file);
	    scanner.useDelimiter(","); 
	    check = scanner.next();
	    
	    
	    while (!check.equals(startBuild)){
		
		
		
		startLat = scanner.next();
		startLong = scanner.next();
		
		check = scanner.next();
		
		
		
	    }
	    
	    
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	

	
	try {
	    
	    Scanner scanner1 = new Scanner(file);
	    scanner1.useDelimiter(","); 
	    
	    check1 = scanner1.next();
	    
	    
	    
	    while (!check1.equals(endBuild)){
		endLat = scanner1.next();
		endLong = scanner1.next();
		
		check1 = scanner1.next();
		
		
		
	    }
	    
	    
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	
	//calculate the distance between the two buildings
	//code from https://www.geodatasource.com/developers/java

	//convet lat and longs from string to double
	double dstartLong = Double.parseDouble(startLong);
	double dstartLat = Double.parseDouble(startLat);
	double dendLong = Double.parseDouble(endLong);
	double dendLat = Double.parseDouble(endLat);




	    
	double theta = dstartLong - dendLong;
	double dist = Math.sin(deg2rad(dstartLat)) * Math.sin(deg2rad(dendLat)) + Math.cos(deg2rad(dstartLat)) * Math.cos(deg2rad(dendLat)) * Math.cos(deg2rad(theta));
	dist = Math.acos(dist);
	dist = (dist * 180 / Math.PI); 
	dist = dist * 60 * 1.1515;
	dist = dist * 1.609344;

	double speed = 920.0/3600;//in sec

	double time = dist/speed;
	String stime  = String.format("%.2f", time);
	result = "This route will take\n" + " "+ stime+ " " + "seconds";
    }
    /**
     *
     * This method takes in proper Lats and Longs and places in a google URL.
     * This returns an XML file which is parsed to find the total time in seconds and minutes.
     *
     */
    
    public static String go(String startLong, String startLat, String endLong, String endLat, String mode){
	Element route, leg, duration;
	String googleURL = "http://maps.googleapis.com/maps/api/directions/xml?origin="+startLat+","+startLong+"&destination="+endLat+","+endLong+"&mode="+mode+"&sensor=false";
	try{
	    URL urlGoogleDirService = new URL(googleURL);
	    
	    HttpURLConnection urlGoogleDirCon = (HttpURLConnection)urlGoogleDirService.openConnection();
	    urlGoogleDirCon.setAllowUserInteraction( false );
	    urlGoogleDirCon.setDoInput( true );
	    urlGoogleDirCon.setDoOutput( false );
	    urlGoogleDirCon.setUseCaches( true );
	    urlGoogleDirCon.setRequestMethod("GET");
	    urlGoogleDirCon.connect();
	    
	    
	    DocumentBuilderFactory factoryDir = DocumentBuilderFactory.newInstance();
	    DocumentBuilder parserDirInfo = factoryDir.newDocumentBuilder();
	    Document docDir = parserDirInfo.parse(urlGoogleDirCon.getInputStream());
	    urlGoogleDirCon.disconnect();
	    route    = (Element) docDir.getElementsByTagName("route").item(0);
	    leg      = (Element) route.getElementsByTagName("leg").item(0);
	    duration = (Element) leg.getElementsByTagName("duration").item(0);
	    int i = 0;
	    while((Element) leg.getElementsByTagName("duration").item(i) != null){
		duration = (Element) leg.getElementsByTagName("duration").item(i);
		i++;
	    }    
	    return duration.getTextContent();
	    
	    
	    
	    
	    
	}
	catch(Exception e){
	    System.out.println(e);
	    return null;
	}
    }
    
    
} 
