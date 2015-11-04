package mej.jorge.com.tercodamisericordia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mej.jorge.com.tercodamisericordia.adapters.OnSwipeTouchListener;

public class SobreFragment extends Fragment {
    public SobreFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sobre, container, false);

        view.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
            @Override
            public void onSwipeLeft() {
                //Toast.makeText(getActivity(), R.string.texto_sammyra, Toast.LENGTH_LONG).show();
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
        });

        return view;
    }
}
