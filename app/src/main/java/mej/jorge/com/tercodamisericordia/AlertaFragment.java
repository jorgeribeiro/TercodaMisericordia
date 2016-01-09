package mej.jorge.com.tercodamisericordia;

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
    private AlarmReceiver alarmReceiver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alerta, container, false);
        alarmReceiver = new AlarmReceiver();

        final SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        final View timePicker = view.findViewById(R.id.timePicker);
        final View toggleButton = view.findViewById(R.id.toggleButton);

        ((ToggleButton) toggleButton).setChecked(mSettings.getBoolean("statusToggleButton", false));
        ((TimePicker) timePicker).setIs24HourView(true);
        ((TimePicker) timePicker).setCurrentHour(mSettings.getInt("hourTimePicker", 15));
        ((TimePicker) timePicker).setCurrentMinute(mSettings.getInt("minTimePicker", 0));

        ((ToggleButton) toggleButton).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = mSettings.edit();
                if(isChecked) {
                    editor.putBoolean("statusToggleButton", true);
                    editor.putInt("hourTimePicker", ((TimePicker) timePicker).getCurrentHour());
                    editor.putInt("minTimePicker", ((TimePicker) timePicker).getCurrentMinute());

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, ((TimePicker) timePicker).getCurrentHour());
                    calendar.set(Calendar.MINUTE, ((TimePicker) timePicker).getCurrentMinute());
                    calendar.clear(Calendar.SECOND);
                    alarmReceiver.setAlarm(getActivity(), calendar);

                    if(toast != null)
                        toast.cancel();
                    toast = Toast.makeText(getActivity(), "Alerta ligado", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    editor.putBoolean("statusToggleButton", false);

                    alarmReceiver.cancelAlarm(getActivity());

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

