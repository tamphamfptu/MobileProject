package com.example.recyleview;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class HomeActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    boolean isCliked = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        TextView userName = findViewById(R.id.userName);
        Button productBtn = findViewById(R.id.productList);
        Button closeBtn = findViewById(R.id.closeBtn);
        Button notiBtn = findViewById(R.id.noti);
        Button stopBtn = findViewById(R.id.stopBtn);


        Intent intent = getIntent();
        String username = getIntent().getStringExtra("keyusername");


        //set new name base on input
        userName.setText(username);

        //get input username
        Toast.makeText(HomeActivity.this, "Welcum " + username, Toast.LENGTH_SHORT).show();

        productBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ShowActivity.class);
                startActivity(intent);
            }
        });



        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(99, intent);
                finish();
            }
        });

        notiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCliked = false;
                //Create first channel for notification
                String CHANNEL_ID = "channel_id";
                CharSequence name = "channel_name";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                Context context = getApplicationContext();
                Intent intent = new Intent(HomeActivity.this, ShowActivity.class);
                PendingIntent pe = PendingIntent.getActivity(getApplicationContext(),
                        0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                Notification builder = new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.bmw)
                        .setContentTitle("Brand new car")
                        .setContentText("nigga")
                        .setChannelId(CHANNEL_ID)
                        .setContentIntent(pe)
                        .build();
                NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel mchannel = new NotificationChannel(CHANNEL_ID, name, importance);
                    manager.createNotificationChannel(mchannel);
                }
                manager.notify(0, builder);
                mediaPlayer = MediaPlayer.create(HomeActivity.this, R.raw.quack);
                if(!isCliked){
                    mediaPlayer.start();

                }
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              stopmus(view);
            }
        });

    }
     protected void stopmus(View view) {
        isCliked = true;
        if(mediaPlayer!=null)
        {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
        super.onStop();
    }
}
