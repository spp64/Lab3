package com.spp64.bigdatalab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	String text = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button create = (Button) findViewById(R.id.Button1);
		create.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i("clicked", "create");
				Intent i = new Intent(MainActivity.this, CreateActivity.class);
				i.putExtra("Action", "create");
				startActivity(i);
			}
		});

		Button insert = (Button) findViewById(R.id.Button2);
		insert.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(MainActivity.this, CreateActivity.class);
				i.putExtra("Action", "insert");
				startActivity(i);
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

				Intent i = new Intent(MainActivity.this, CreateActivity.class);
				i.putExtra("Action", "retrieve");
				startActivity(i);
			}
		});

		Button delete = (Button) findViewById(R.id.Button4);
		delete.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(MainActivity.this, CreateActivity.class);
				i.putExtra("Action", "delete");
				startActivity(i);
			}
		});

	}
}
