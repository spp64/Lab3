package com.spp64.bigdatalab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	String HTML;
	TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.textView);
		text.setMovementMethod(new ScrollingMovementMethod());
		text.setText("");

		Button create = (Button) findViewById(R.id.Button1);
		create.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i("clicked", "create");
				/*Intent i = new Intent(MainActivity.this, CreateActivity.class);
				i.putExtra("Action", "create");
				startActivity(i);*/
				new Task()
				.execute("http://134.193.136.147:8080/HbaseWS/jaxrs/generic/hbaseCreate/NewTableData/GeoLocation:Date:Accelerometer");
			}
		});

		Button insert = (Button) findViewById(R.id.Button2);
		insert.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				new Task()
				.execute("http://134.193.136.147:8080/HbaseWS/jaxrs/generic/hbaseCreate/Blah101/GeoLocation:Date:Accelerometer");
			}
		});

		Button retrieve = (Button) findViewById(R.id.Button3);
		retrieve.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				/*
				 * new AsyncTask<Void, Void, String>() {
				 * 
				 * 
				 * @Override protected String doInBackground(Void... params) {
				 * WebServiceRequestManager manager = new
				 * WebServiceRequestManager(); return manager.getMethod(
				 * "http://134.193.136.127:8080/HbaseWS/jaxrs/generic/hbaseRetrieveAll/Blah101"
				 * ); }
				 * 
				 * @Override protected void onPostExecute(String result) {
				 * super.onPostExecute(result); System.out.println(result);
				 * Log.i("retrieve",result);
				 * 
				 * } }.execute();
				 */

				new Task()
				.execute("http://134.193.136.147:8080/HbaseWS/jaxrs/generic/hbaseRetrieveAll/Blah101");
			}
		});

		Button delete = (Button) findViewById(R.id.Button4);
		delete.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				new Task()
				.execute("http://134.193.136.147:8080/HbaseWS/jaxrs/generic/hbasedeletel/Blah101");
			}
		});

	}
	
	private class Task extends AsyncTask<String, Void, String> {
		private ProgressDialog dialog = new ProgressDialog(MainActivity.this);

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
			text.setText(result);
			
		}

	}
}
