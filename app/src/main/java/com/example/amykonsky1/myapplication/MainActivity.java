package com.example.amykonsky1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    implements View.OnClickListener

    {
        private static final int NOTIFY_ID = 1001;

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        findViewById(R.id.btnNotification).setOnClickListener(this);

    }

    private void createNotification() {


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);


        Intent intent = new Intent(this, NotificationResultActivity.class);
        Intent.putExtra("notifyID", Notify_ID);



        PendingIntent pendingIntent = PendingIntent.getActivity(this,NOTIFY_ID, intent, PendingIntent.FLAG_CANCEL_CURRENT );

        builder.setSmallIcon(R.drawable.ic_stat_sample_notification);
        builder.setContentTitle("Sample Notification");
        builder.setContentText("This is a sample notification");

        builder.setAutoCancel(true);

        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

        builder.setSubText("Tap to view");


        builder.setContentIntent(pendingIntent);

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompay.BigTextStyle();
        bigTextStyle.setBigContentTitle("This is a big notification");
        bigTextStyle.bigText(getResources().getString(R.string.LongMsg));
        builder.setStyle(bigTextStyle);



        builder.addAction(R.ic_Launder, "Action 1, pendingIntent");
        builder.addAction(R.ic_Launder, "Action 2, pendingIntent");

        builder.setVisibility(Notification. VISIBILITY_PRIVATE);

        Notification notification = builder.build();
        NotificationManager mgr = (NotificaionManager)getSystemService(NOTIFICATION_SERVICE);
        mgr.notify(NOTIFY_ID, notification);

    }
}