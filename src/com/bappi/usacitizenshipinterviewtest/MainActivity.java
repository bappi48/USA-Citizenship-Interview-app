package com.bappi.usacitizenshipinterviewtest;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class MainActivity extends Activity {

	String stateName;
	String[] data;
    Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.first_page_scroll_view);		
		
		final TextView txtCapital = (TextView) findViewById(R.id.state_capital);
		final TextView txtSenator = (TextView) findViewById(R.id.state_senator);
		final TextView txtGovernor = (TextView) findViewById(R.id.state_governor);
		
		final SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
		int pos = sharedPref.getInt("state", 0);
		
		Spinner spin = (Spinner) findViewById(R.id.state_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.states_name, R.layout.spinner_layout);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(adapter);
		spin.setSelection(pos);
		spin.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				position++;
				stateName = "state"+position;				
				int id = context.getResources().getIdentifier(stateName,"array", context.getPackageName());
				//Log.d("BAP", stateName + " : "+ id );
				data = context.getResources().getStringArray(id);				
				txtCapital.setText("\n" + data[0] + "\n");
				txtSenator.setText(data[1] + "\n");
				txtGovernor.setText(data[2]);
				
				SharedPreferences.Editor edit = sharedPref.edit();
				edit.putInt("state", --position);
				edit.commit();
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		Button button = (Button) findViewById(R.id.gotoquestion);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, QuestionsActivity.class);
				startActivity(intent);
			}
		});
		
		
		
		
	}

}
