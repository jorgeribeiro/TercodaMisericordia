package mej.jorge.com.tercodamisericordia.Novena;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mej.jorge.com.tercodamisericordia.MainActivity;
import mej.jorge.com.tercodamisericordia.R;

public class DayFourFragment extends Fragment {
    public DayFourFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_novena, container, false);

        View txtViewTitleDay = view.findViewById(R.id.titulo_dia);
        View txtViewJesus = view.findViewById(R.id.primeiro_dia_jesus);
        View txtViewFaustina = view.findViewById(R.id.primeiro_dia_faustina);

        ((TextView)txtViewTitleDay).setText(R.string.titulo_quarto_dia);
        ((TextView)txtViewJesus).setText(R.string.quarto_dia_jesus);
        ((TextView)txtViewFaustina).setText(R.string.quarto_dia_faustina);

        View btnTerco = view.findViewById(R.id.botao_terco);
        btnTerco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("openTercoFragment", "tercoFragment");
                startActivity(intent);
            }
        });

        return view;
    }
}
