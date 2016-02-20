package mej.jorge.com.tercodamisericordia.adapters;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import mej.jorge.com.tercodamisericordia.MainActivity;
import mej.jorge.com.tercodamisericordia.R;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        createNotification(context);
    }

    private void createNotification(Context context) {
        Intent intent1 = new Intent(context, MainActivity.class);
        intent1.putExtra("openFragment", "tercoFragment");
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent1, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.icon_notification)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_app))
                .setContentTitle("Divina Misericórdia")
                .setContentText("Hora do Terço!")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManager mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
    }


}
