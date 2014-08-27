package com.APKS.mcqaudio;

import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
     
        final MediaPlayer mp = new MediaPlayer();
        Button b = (Button) findViewById(R.id.button1); 
        

        b.setOnClickListener(new OnClickListener() {

           // @Override
            public void onClick(View v) {

                if(mp.isPlaying())
                {  
                    mp.stop();
                 //   mp.reset();
                } 
                try {

                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("pcaudio.mp3");
                    mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                    mp.prepare();
                    mp.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        }); 
        
        Button button = (Button) findViewById(R.id.button2);
      	 
	        button.setOnClickListener(new OnClickListener() {
	 
	            @Override
	            public void onClick(View view) {
	                Toast.makeText(MainActivity.this, "Answer D", Toast.LENGTH_SHORT).show();
	            }
	 
	        });
        
        
        
        
        }
    

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
        
        
        
        
    }
    
     
   
   
   
}
