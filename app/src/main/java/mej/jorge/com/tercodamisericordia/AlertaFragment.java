package mej.jorge.com.tercodamisericordia;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import mej.jorge.com.tercodamisericordia.adapters.AlarmSetter;

public class AlertaFragment extends Fragment {
    public AlertaFragment(){}

    private static Toast toast;
    private AlarmSetter alarmSetter;
    private SharedPreferences mSettings;
    final String KEY_TOGGLE_BUTTON = "statusToggleButton";
    final String KEY_HOUR = "hourTimePicker";
    final String KEY_MINUTE = "minTimePicker";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alerta, container, false);

        alarmSetter = new AlarmSetter();
        mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        final View timePicker = view.findViewById(R.id.timePicker);
        final View toggleButton = view.findViewById(R.id.toggleButton);

        ((ToggleButton) toggleButton).setChecked(mSettings.getBoolean(KEY_TOGGLE_BUTTON, false));
        ((TimePicker) timePicker).setIs24HourView(true);
        /**
         * TODO
         * setCurrentHour and setCurrentMinute are deprecated in API 23
         * In future versions, remember that I have to change to the new methods:
         * setHour and setMinute, also valid for getHour and getMinute.
         */
        ((TimePicker) timePicker).setCurrentHour(mSettings.getInt(KEY_HOUR, 15));
        ((TimePicker) timePicker).setCurrentMinute(mSettings.getInt(KEY_MINUTE, 0));

        ((ToggleButton) toggleButton).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                firstClick(getActivity());
                SharedPreferences.Editor editor = mSettings.edit();
                if(isChecked) {
                    editor.putBoolean(KEY_TOGGLE_BUTTON, true);
                    editor.putInt(KEY_HOUR, ((TimePicker) timePicker).getCurrentHour());
                    editor.putInt(KEY_MINUTE, ((TimePicker) timePicker).getCurrentMinute());

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.set(Calendar.HOUR_OF_DAY, ((TimePicker) timePicker).getCurrentHour());
                    calendar.set(Calendar.MINUTE, ((TimePicker) timePicker).getCurrentMinute());
                    calendar.clear(Calendar.SECOND);
                    alarmSetter.setAlarm(getActivity(), calendar);

                    if(toast != null)
                        toast.cancel();
                    toast = Toast.makeText(getActivity(), "Notificação ligada", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    editor.putBoolean(KEY_TOGGLE_BUTTON, false);
                    alarmSetter.cancelAlarm(getActivity());

                    if(toast != null)
                        toast.cancel();
                    toast = Toast.makeText(getActivity(), "Notificação desligada", Toast.LENGTH_SHORT);
                    toast.show();
                }
                editor.apply();
            }
        });
        return view;
    }

    public void firstClick(Context context) {
        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(context);
        boolean dialogShown = mSettings.getBoolean("firstClickShown", false);
        if (!dialogShown) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context)
                    .setTitle("Atenção!")
                    .setMessage("A notificação do terço não é sonora. Na hora selecionada, " +
                            "você receberá apenas uma notificação no seu telefone. Este aplicativo " +
                            "não irá gerar nenhum alerta sonoro.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Do something else
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

            SharedPreferences.Editor editor = mSettings.edit();
            editor.putBoolean("firstClickShown", true);
            editor.apply();
        }
    }

}

