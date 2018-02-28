package com.nehvin.s11e178notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,intent,0);
        Notification.Action action = new Notification.Action.Builder(android.R.drawable.sym_action_chat, "Previous", pendingIntent).build();

        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("Lunch is Ready")
                .setContentText("It is getting cold ... ")
                .setContentIntent(pendingIntent)
                .addAction(action)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(2,notification);
    }
}
