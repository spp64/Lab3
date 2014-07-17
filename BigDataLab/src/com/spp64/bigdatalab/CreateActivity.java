package com.spp64.bigdatalab;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

public class CreateActivity extends Activity {
	String HTML;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);

		Bundle bundle = getIntent().getExtras();
		String data;
		data = bundle.getString("Action");

		/*
		 * TextView text = (TextView) findViewById(R.id.textView);
		 * text.setMovementMethod(new ScrollingMovementMethod());
		 */

		if (data == "create") {
			// Task1 task = new Task1();
			// task.execute();

			new Task()
					.execute("http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseCreate/BlahBlah10/GeoLocation:Date:Accelerometer");
		} else if (data == "insert") {
			/*
			 * Task2 task = new Task2(); task.execute();
			 */

			new Task()
					.execute("http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseCreate/Blah101/GeoLocation:Date:Accelerometer");
		} else if (data == "retrieve") {
			/*
			 * Task3 task = new Task3(); task.execute();
			 */

			new Task()
					.execute("http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseRetrieveAll/Blah101");
		} else if (data == "delete") {
			/*
			 * Task4 task = new Task4(); task.execute();
			 */

			new Task()
					.execute("http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbasedeletel/Blah101");
		}

		/*
		 * Log.i("in create ","create"); try { URL url = new URL(
		 * "http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseCreate/Blah/GeoLocation:Date:Accelerometer"
		 * ); BufferedReader in = new BufferedReader(new InputStreamReader(
		 * url.openStream())); String inputLine; StringBuilder sb = new
		 * StringBuilder();
		 * 
		 * while ((inputLine = in.readLine()) != null) { // Process each line.
		 * 
		 * sb.append(inputLine); sb.append("\n"); } //String buffer =
		 * sb.toString(); text.setText(sb.toString()); Log.i("buffer data",
		 * sb.toString()); in.close();
		 * 
		 * } catch (Exception me) { Log.i("error", "error");
		 * 
		 * 
		 * } } else if (data == "insert") { try { URL url = new URL(
		 * "http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseInsert/TableNewPran/-home-group9-sensorTagData.txt/GeoLocation:Date:Accelerometer"
		 * ); BufferedReader in = new BufferedReader(new InputStreamReader(
		 * url.openStream())); String inputLine; StringBuilder sb = new
		 * StringBuilder();
		 * 
		 * while ((inputLine = in.readLine()) != null) { // Process each line.
		 * 
		 * sb.append(inputLine); sb.append("\n"); } String buffer =
		 * sb.toString(); text.setText(buffer); in.close();
		 * 
		 * } catch (MalformedURLException me) { System.out.println(me);
		 * 
		 * } catch (IOException ioe) { System.out.println(ioe); }
		 * 
		 * } else if (data == "retrieve") {
		 * 
		 * try { URL url = new URL(
		 * "http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseRetrieveAll/TableNewPran"
		 * ); BufferedReader in = new BufferedReader(new InputStreamReader(
		 * url.openStream()));
		 * 
		 * File sdCard = Environment.getExternalStorageDirectory(); File
		 * directory = new File(sdCard.getAbsolutePath() + "/Data"); if
		 * (!directory.exists()) directory.mkdirs(); String fname =
		 * "RetrieveData.txt"; File file = new File(directory, fname);
		 * 
		 * if (!file.exists()) file.createNewFile();
		 * 
		 * FileOutputStream out = new FileOutputStream(file, true);
		 * 
		 * String inputLine; StringBuilder sb = new StringBuilder();
		 * 
		 * while ((inputLine = in.readLine()) != null) { // Process each line.
		 * out.write(inputLine.getBytes()); sb.append(inputLine);
		 * sb.append("\n"); } String buffer = sb.toString();
		 * text.setText(buffer); in.close(); out.flush(); out.close();
		 * 
		 * } catch (MalformedURLException me) { System.out.println(me);
		 * 
		 * } catch (IOException ioe) { System.out.println(ioe); }
		 * 
		 * try {
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * } else if (data == "delete") {
		 * 
		 * try { URL url = new URL(
		 * "http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbasedeletel/TableNewPran"
		 * ); BufferedReader in = new BufferedReader(new InputStreamReader(
		 * url.openStream())); String inputLine; StringBuilder sb = new
		 * StringBuilder();
		 * 
		 * while ((inputLine = in.readLine()) != null) { // Process each line.
		 * 
		 * sb.append(inputLine); sb.append("\n"); } String buffer =
		 * sb.toString(); text.setText(buffer); in.close();
		 * 
		 * } catch (MalformedURLException me) { //me.printStackTrace();
		 * text.setText("error"); } catch (IOException ioe) {
		 * System.out.println(ioe); }
		 */// }
	}

	/*
	 * @Override public void onResume() { super.onResume(); Log.i("resume",
	 * "resuming"); }
	 */

	private class Task extends AsyncTask<String, Void, String> {
		private ProgressDialog dialog = new ProgressDialog(CreateActivity.this);

		@Override
		protected String doInBackground(String... url) {
			try {

				HttpClient httpClient = new DefaultHttpClient();
				HttpContext localContext = new BasicHttpContext();
				HttpGet httpGet = new HttpGet(url[0]); // URL!

				HttpResponse response = httpClient.execute(httpGet,
						localContext);
				String result = "";

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent()));

				String line = null;
				while ((line = reader.readLine()) != null) {
					result += line + "\n";
					HTML = result;
				}

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// TODO Auto-generated method stub
			return HTML;
		}

		@Override
		protected void onPreExecute() {
			dialog.setMessage("In Progress...");
			dialog.show();

		}

		@Override
		protected void onPostExecute(String result) {
			dialog.dismiss();
			System.out.println("Respose : " + result);
			Log.i("result", result);
			TextView text = (TextView) findViewById(R.id.textView);
			text.setMovementMethod(new ScrollingMovementMethod());
			text.setText(result);
		}

	}

	private class Task1 extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(Void... params) {
			WebServiceRequestManager manager = new WebServiceRequestManager();

			return manager
					.getMethod("http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseCreate/BlahBlah10/GeoLocation:Date:Accelerometer");

		}

		@Override
		protected void onPostExecute(String result) {
			System.out.println("Respose : " + result);
			Log.i("result", result);
			TextView text = (TextView) findViewById(R.id.textView);
			text.setMovementMethod(new ScrollingMovementMethod());
			text.setText("" + result);
		}
	}

	private class Task2 extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(Void... params) {
			WebServiceRequestManager manager = new WebServiceRequestManager();

			return manager
					.getMethod("http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseCreate/BlahBlah10/GeoLocation:Date:Accelerometer");

		}

		@Override
		protected void onPostExecute(String result) {
			System.out.println("Respose : " + result);
			Log.i("result", result);
			TextView text = (TextView) findViewById(R.id.textView);
			text.setMovementMethod(new ScrollingMovementMethod());
			text.setText(result);
		}
	}

	private class Task3 extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(Void... params) {
			WebServiceRequestManager manager = new WebServiceRequestManager();

			return manager
					.getMethod("http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseCreate/BlahBlah10/GeoLocation:Date:Accelerometer");

		}

		@Override
		protected void onPostExecute(String result) {
			System.out.println("Respose : " + result);
			Log.i("result", result);
			TextView text = (TextView) findViewById(R.id.textView);
			text.setMovementMethod(new ScrollingMovementMethod());
			text.setText(result);
		}
	}

	private class Task4 extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(Void... params) {
			WebServiceRequestManager manager = new WebServiceRequestManager();

			return manager
					.getMethod("http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseCreate/BlahBlah10/GeoLocation:Date:Accelerometer");

		}

		@Override
		protected void onPostExecute(String result) {
			System.out.println("Respose : " + result);
			Log.i("result", result);
			TextView text = (TextView) findViewById(R.id.textView);
			text.setMovementMethod(new ScrollingMovementMethod());
			text.setText("" + result);
		}
	}

	class WebServiceRequestManager {

		public String getMethod(String url) {
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response;
			String responseString = null;
			try {
				response = httpclient.execute(new HttpGet(url));
				StatusLine statusLine = response.getStatusLine();
				if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					response.getEntity().writeTo(out);
					out.close();
					responseString = out.toString();
				} else {
					// Closes the connection.
					response.getEntity().getContent().close();
					throw new IOException(statusLine.getReasonPhrase());
				}
			} catch (ClientProtocolException e) {
				// TODO Handle problems..
			} catch (IOException e) {
				// TODO Handle problems..
			}
			return responseString;
		}
	}

}