package com.example.lab_5_sas_houda;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Locale;

public class ChaleurFragment extends Fragment {

    private RadioGroup rgTemperature;
    private EditText etValeurChaleur;
    private Button btnConvertirChaleur;
    private TextView tvResultatChaleur;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View vue = inflater.inflate(R.layout.fragment_chaleur, container, false);

        rgTemperature = vue.findViewById(R.id.rgTemperature);
        etValeurChaleur = vue.findViewById(R.id.etValeurChaleur);
        btnConvertirChaleur = vue.findViewById(R.id.btnConvertirChaleur);
        tvResultatChaleur = vue.findViewById(R.id.tvResultatChaleur);

        btnConvertirChaleur.setOnClickListener(v -> {
            String saisie = etValeurChaleur.getText().toString();

            if (TextUtils.isEmpty(saisie)) {
                Toast.makeText(getContext(), R.string.erreur_valeur_vide, Toast.LENGTH_SHORT).show();
                return;
            }

            double valeur = Double.parseDouble(saisie);
            double resultat;
            int selectedId = rgTemperature.getCheckedRadioButtonId();

            if (selectedId == R.id.rbCtoF) {
                resultat = (valeur * 9.0 / 5.0) + 32;
                String message = String.format(Locale.FRANCE, getString(R.string.resultat_format), resultat) + " °F";
                tvResultatChaleur.setText(message);
            } else {
                resultat = (valeur - 32) * 5.0 / 9.0;
                String message = String.format(Locale.FRANCE, getString(R.string.resultat_format), resultat) + " °C";
                tvResultatChaleur.setText(message);
            }
        });

        return vue;
    }
}