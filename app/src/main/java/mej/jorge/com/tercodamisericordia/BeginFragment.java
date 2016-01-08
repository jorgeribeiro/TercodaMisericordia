package mej.jorge.com.tercodamisericordia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by Jorge on 1/2/2016.
 */
public class BeginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;

        view = inflater.inflate(R.layout.fragment_begin, container, false);

        View buttonEspiritoSanto = view.findViewById(R.id.botaoEspiritoSanto);
        buttonEspiritoSanto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setTitle("Invocação do Espírito Santo")
                        .setMessage(R.string.oracaoEspiritoSanto)
                        .setPositiveButton("Amém", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Do something else
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        View buttonPaiNosso = view.findViewById(R.id.botaoPaiNosso);
        buttonPaiNosso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setTitle("Pai Nosso")
                        .setMessage(R.string.oracaoPaiNosso)
                        .setPositiveButton("Amém", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Do something else
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        View buttonAveMaria = view.findViewById(R.id.botaoAveMaria);
        buttonAveMaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setTitle("Ave Maria")
                        .setMessage(R.string.oracaoAveMaria)
                        .setPositiveButton("Amém", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Do something else
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        View buttonCredo = view.findViewById(R.id.botaoCredo);
        buttonCredo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setTitle("Credo")
                        .setMessage(R.string.oracaoCredo)
                        .setPositiveButton("Amém", new DialogInterface.OnClickListener() {
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
