package mej.jorge.com.tercodamisericordia.Novena;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mej.jorge.com.tercodamisericordia.R;

public class NovenaBeginFragment extends Fragment {
    public NovenaBeginFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_begin_novena, container, false);

        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean dialogShown = mSettings.getBoolean("dialogShownNovena", false);
        if (!dialogShown) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                    .setMessage("A Novena pode ser rezada sempre que desejar. Porém, o tempo mais propício " +
                            "para rezá-la é durante a quaresma, iniciando-a na Sexta-Feira Santa, finalizando-a " +
                            "exatamente no Domingo da Divina Misericórdia.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Do something else
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

            SharedPreferences.Editor editor = mSettings.edit();
            editor.putBoolean("dialogShownNovena", true);
            editor.apply();
        }

        return view;
    }
}
