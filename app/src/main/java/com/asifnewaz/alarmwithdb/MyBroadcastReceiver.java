package com.asifnewaz.alarmwithdb;

/**
 * Created by USER on 8/30/2017.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    DatabaseHelper mDatabaseHelper;
    @Override
    public void onReceive(Context context, Intent intent) {
        mDatabaseHelper = new DatabaseHelper(context);
        mp=MediaPlayer.create(context, R.raw.alarm   );
        mp.start();
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();

        //setContentView(R.layout.main);
        Calendar myCalender = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Now we display formattedDate value in TextView
        String newEntry = "Alarmed  ";
        String formattedDate = df.format(myCalender.getTime());

        // Set newEntry to Data Base
        boolean insertData = mDatabaseHelper.addData(newEntry, formattedDate);
        //Checking Data inserted Correctly or not
        if (insertData) {
            Toast.makeText(context,"Saveing Successfull", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show();
        }
    }
}