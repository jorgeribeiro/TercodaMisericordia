package mej.jorge.com.tercodamisericordia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jorge on 1/2/2016.
 */
public class EndFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;

        view = inflater.inflate(R.layout.fragment_end, container, false);

        View buttonOremos = view.findViewById(R.id.botaoOremos);
        buttonOremos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setTitle("Oremos")
                        .setMessage(R.string.oremosFinal)
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
