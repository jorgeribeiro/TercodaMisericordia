package mej.jorge.com.tercodamisericordia.notUsed;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mej.jorge.com.tercodamisericordia.R;

public class TercoFragmentOld extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String PREFS_NAME = "MyPrefsFile";
    private int mPage;

    public static TercoFragmentOld newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        TercoFragmentOld fragment = new TercoFragmentOld();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        boolean dialogShown = settings.getBoolean("dialogShown", false);
        if (!dialogShown) {
           AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                   .setMessage("Para retornar ao Menu, pressione o botão Voltar do seu aparelho")
                   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int which) {
                           // Do something else
                       }
                   });
            AlertDialog alert = builder.create();
            alert.show();

            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("dialogShown", true);
            editor.apply();
        }

        View view;
        if(mPage == 1) {
            view = inflater.inflate(R.layout.fragment_begin_terco, container, false);
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
        } else if(mPage == 7) {
            view = inflater.inflate(R.layout.fragment_end_terco, container, false);
        } else {
            view = inflater.inflate(R.layout.fragment_page_terco, container, false);
            View imgViewMystery = view.findViewById(R.id.imgMisterio1);
            View textViewIntro = view.findViewById(R.id.intro1);
            View textViewMystery = view.findViewById(R.id.misterio1);
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
            switch(mPage) {
                case 2:
                    ((ImageView)imgViewMystery).setImageResource(R.drawable.misterio1);
                    ((TextView)textViewIntro).setText(R.string.intro1);
                    ((TextView)textViewMystery).setText(R.string.misterio1);
                    break;
                case 3:
                    ((ImageView)imgViewMystery).setImageResource(R.drawable.misterio2);
                    ((TextView)textViewIntro).setText(R.string.intro2);
                    ((TextView)textViewMystery).setText(R.string.misterio2);
                    break;
                case 4:
                    ((ImageView)imgViewMystery).setImageResource(R.drawable.misterio3);
                    ((TextView)textViewIntro).setText(R.string.intro3);
                    ((TextView)textViewMystery).setText(R.string.misterio3);
                    break;
                case 5:
                    ((ImageView)imgViewMystery).setImageResource(R.drawable.misterio4);
                    ((TextView)textViewIntro).setText(R.string.intro4);
                    ((TextView)textViewMystery).setText(R.string.misterio4);
                    break;
                case 6:
                    ((ImageView)imgViewMystery).setImageResource(R.drawable.misterio5);
                    ((TextView)textViewIntro).setText(R.string.intro5);
                    ((TextView)textViewMystery).setText(R.string.misterio5);
                    break;
                default:
                    ((ImageView)imgViewMystery).setImageResource(R.drawable.misterio1);
                    ((TextView)textViewIntro).setText(R.string.intro1);
                    ((TextView)textViewMystery).setText(R.string.misterio1);
            }
        }
        return view;
    }
}
