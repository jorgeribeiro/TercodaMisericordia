package mej.jorge.com.tercodamisericordia.adapters;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Calendar;

public class AlarmSetter extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(context);
        if(mSettings.getBoolean("statusToggleButton", false)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, mSettings.getInt("hourTimePicker", 15));
            calendar.set(Calendar.MINUTE, mSettings.getInt("minTimePicker", 0));
            calendar.clear(Calendar.SECOND);
            setAlarm(context, calendar);
        }
    }

    public void setAlarm(Context context, Calendar calendar) {
        Intent alarmIntent = new Intent(context, AlarmReceiverTerco.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if(calendar.getTimeInMillis() < System.currentTimeMillis()) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + AlarmManager.INTERVAL_DAY, AlarmManager.INTERVAL_DAY, pendingIntent);
        } else {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        }
    }

    public void cancelAlarm(Context context) {
        Intent alarmIntent = new Intent(context, AlarmReceiverTerco.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }

}
