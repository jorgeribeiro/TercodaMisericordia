package mej.jorge.com.tercodamisericordia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MysteryThreeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;

        view = inflater.inflate(R.layout.fragment_page, container, false);

        View imgViewMystery = view.findViewById(R.id.imgMisterio1);
        View textViewIntro = view.findViewById(R.id.intro1);
        View textViewMystery = view.findViewById(R.id.misterio1);
        ((ImageView)imgViewMystery).setImageResource(R.drawable.misterio3);
        ((TextView)textViewIntro).setText(R.string.intro3);
        ((TextView)textViewMystery).setText(R.string.misterio3);

        View buttonEternoPai = view.findViewById(R.id.botaoEternoPai);
        buttonEternoPai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setTitle("Eterno Pai")
                        .setMessage(R.string.oracaoEternoPai)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Do something else
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        View buttonDolorosaPaixao = view.findViewById(R.id.botaoDolorosaPaixao);
        buttonDolorosaPaixao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setTitle("Pela Sua Dolorosa Paixão")
                        .setMessage(R.string.oracaoDolorosaPaixao)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Do something else
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        View buttonSangueeAgua = view.findViewById(R.id.botaoSangueeAgua);
        buttonSangueeAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setTitle("Ó Sangue e Água")
                        .setMessage(R.string.oracaoSangueeAgua)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Do something else
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        return view;
    }
}
