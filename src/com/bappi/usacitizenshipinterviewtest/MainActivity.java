package com.bappi.usacitizenshipinterviewtest;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;

public class MainActivity extends Activity {

    final MediaPlayer mp = new MediaPlayer();
    AssetFileDescriptor afd;
    String trackName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main_view);		
		
		ListView listView = (ListView) findViewById(R.id.list);
		listView.setAdapter(new CustomAdapter(getApplicationContext()));
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,	long arg3) {
				// TODO Auto-generated method stub
				if(position==0) return;
				if(mp.isPlaying()){  
					mp.stop();
				} 

				try {
					mp.reset();	
					trackName = "track"+ position + ".mp3";
					afd = getAssets().openFd(trackName);
					mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
					mp.prepare();
					mp.start();
				} catch (Exception e) {
					
				} 			
				
			}			
			
		});
		
	}

}
