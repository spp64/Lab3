package Hbase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.neoremind.sshxcute.core.ConnBean;
import net.neoremind.sshxcute.core.Result;
import net.neoremind.sshxcute.core.SSHExec;
import net.neoremind.sshxcute.exception.TaskExecFailException;
import net.neoremind.sshxcute.task.CustomTask;
import net.neoremind.sshxcute.task.impl.ExecCommand;
import net.neoremind.sshxcute.task.impl.ExecShellScript;



public class Operations {
	
	public static void connectSSH()
	{
		// Initialize a SSHExec instance without referring any object. 
		SSHExec ssh = null;
		// Wrap the whole execution jobs into try-catch block   
		try {
		    // Initialize a ConnBean object, parameter list is ip, username, password
		    ConnBean cb = new ConnBean("134.193.136.147", "group9","group9");
		    // Put the ConnBean instance as parameter for SSHExec static method getInstance(ConnBean) to retrieve a real SSHExec instance
		    ssh = SSHExec.getInstance(cb);              
		
		    // Connect to server
		    ssh.connect();
		    // Upload sshxcute_test.sh to /home/tsadmin on remote system
		    ssh.uploadSingleDataToServer("C:\\Users\\Praneeth\\Android\\HbaseFrontEnd\\sensortag.txt", "/home/group9/");
		    
	
		} 
		catch (TaskExecFailException e) 
		{
		    System.out.println(e.getMessage());
		    e.printStackTrace();
		} 
		catch (Exception e) 
		{
		    System.out.println(e.getMessage());
		    e.printStackTrace();
		} 
		finally 
		{
		    ssh.disconnect();   
		}
	}
	
	
	public static void runHbaseCreate()
	{
		 try {
	            URL url = new URL("http://134.193.136.147:8080/HbaseWS/jaxrs/generic/hbaseCreate/Table5266/Date:accelerometer:Humidity:Gyro");
	            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	            String inputLine; 
	 
	            while ((inputLine = in.readLine()) != null) {
	                // Process each line.
	                System.out.println(inputLine);
	            }
	            in.close(); 
	 
	        } catch (MalformedURLException me) {
	            System.out.println(me); 
	 
	        } catch (IOException ioe) {
	            System.out.println(ioe);
	        }
	 }
	
	
	public static void runHbaseInsert()
	{
		 try {
	            URL url = new URL("http://134.193.136.147:8080/HbaseWS/jaxrs/generic/hbaseInsert/Test5266/-home-group9-sensortag.txt/Date:accelerometer:Humidity:Gyro");
	            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	            String inputLine; 
	 
	            while ((inputLine = in.readLine()) != null) {
	                // Process each line.
	                System.out.println(inputLine);
	            }
	            in.close(); 
	 
	        } catch (MalformedURLException me) {
	            System.out.println(me); 
	 
	        } catch (IOException ioe) {
	            System.out.println(ioe);
	        }
	}
	
	
	public static void runHbaseRetrieveAll()
	{
		 try {
	            URL url = new URL("http://134.193.136.147:8080/HbaseWS/jaxrs/generic/hbaseRetrieveAll/Test5266");
	            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	            String inputLine; 
	 
	            while ((inputLine = in.readLine()) != null) {
	                // Process each line.
	                System.out.println(inputLine);
	            }
	            in.close(); 
	 
	        } catch (MalformedURLException me) {
	            System.out.println(me); 
	 
	        } catch (IOException ioe) {
	            System.out.println(ioe);
	        }
	}
	
	
	public static void runHbaseDelete()
	{
		 try {
	            URL url = new URL("http://134.193.136.147:8080/HbaseWS/jaxrs/generic/hbasedeletel/Test5266");
	            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	            String inputLine; 
	 
	            while ((inputLine = in.readLine()) != null) {
	                // Process each line.
	                System.out.println(inputLine);
	            }
	            in.close(); 
	 
	        } catch (MalformedURLException me) {
	            System.out.println(me); 
	 
	        } catch (IOException ioe) {
	            System.out.println(ioe);
	        }
	}
	
	static public void main(String args[])
	{
		//connectSSH();
		//runHbaseCreate();
		runHbaseInsert();
		//runHbaseRetrieveAll();
		//runHbaseDelete();
	}
	

}
