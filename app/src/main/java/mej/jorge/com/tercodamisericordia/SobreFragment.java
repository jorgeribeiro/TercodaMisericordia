package mej.jorge.com.tercodamisericordia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SobreFragment extends Fragment {
    public SobreFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sobre, container, false);

        View sammyraBtn = view.findViewById(R.id.sammyra);
        int currentApi = Build.VERSION.SDK_INT;
        if(currentApi >= Build.VERSION_CODES.HONEYCOMB) {
            sammyraBtn.setOnClickListener(new View.OnClickListener() {
                int countClick = 0;
                @Override
                public void onClick(View v) {
                    countClick++;
                    if(countClick == 18) {
                        countClick = 0;
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                                .setTitle("Sammyra")
                                .setMessage(R.string.texto_sammyra)
                                .setPositiveButton("♥", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Do something else
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                }
            });
        } else {
            sammyraBtn.setVisibility(View.INVISIBLE);
        }

        return view;
    }
}
