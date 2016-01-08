package mej.jorge.com.tercodamisericordia;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

import mej.jorge.com.tercodamisericordia.adapters.AlarmReceiver;

public class AlertaFragment extends Fragment {
    public AlertaFragment(){}

    private static Toast toast;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alerta, container, false);

        final SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity());

        final View timePicker = view.findViewById(R.id.timePicker);
        View toggleButton = view.findViewById(R.id.toggleButton);
        ((ToggleButton) toggleButton).setChecked(mSettings.getBoolean("statusToggleButton", false));
        ((TimePicker) timePicker).setIs24HourView(true);
        ((TimePicker) timePicker).setCurrentHour(mSettings.getInt("hourTimePicker", 15));
        ((TimePicker) timePicker).setCurrentMinute(mSettings.getInt("minTimePicker", 0));

        ((ToggleButton) toggleButton).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent alarmIntent = new Intent(getActivity(), AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                SharedPreferences.Editor editor = mSettings.edit();
                if(isChecked) {
                    editor.putBoolean("statusToggleButton", true);
                    editor.putInt("hourTimePicker", ((TimePicker) timePicker).getCurrentHour());
                    editor.putInt("minTimePicker", ((TimePicker) timePicker).getCurrentMinute());

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, ((TimePicker) timePicker).getCurrentHour());
                    calendar.set(Calendar.MINUTE, ((TimePicker) timePicker).getCurrentMinute());
                    calendar.set(Calendar.SECOND, 0);
                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 24*60*60*1000, pendingIntent);

                    if(toast != null)
                        toast.cancel();
                    toast = Toast.makeText(getActivity(), "Alerta ligado", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    editor.putBoolean("statusToggleButton", false);

                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
                    alarmManager.cancel(pendingIntent);

                    if(toast != null)
                        toast.cancel();
                    toast = Toast.makeText(getActivity(), "Alerta desligado", Toast.LENGTH_SHORT);
                    toast.show();
                }
                editor.apply();
            }
        });

        return view;
    }

}

