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

public class DistanceFragment extends Fragment {

    private RadioGroup rgDistance;
    private EditText etValeurDistance;
    private Button btnConvertirDistance;
    private TextView tvResultatDistance;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View vue = inflater.inflate(R.layout.fragment_distance, container, false);

        rgDistance = vue.findViewById(R.id.rgDistance);
        etValeurDistance = vue.findViewById(R.id.etValeurDistance);
        btnConvertirDistance = vue.findViewById(R.id.btnConvertirDistance);
        tvResultatDistance = vue.findViewById(R.id.tvResultatDistance);

        btnConvertirDistance.setOnClickListener(v -> {
            String saisie = etValeurDistance.getText().toString();

            if (TextUtils.isEmpty(saisie)) {
                Toast.makeText(getContext(), R.string.erreur_valeur_vide, Toast.LENGTH_SHORT).show();
                return;
            }

            double valeur = Double.parseDouble(saisie);
            double resultat;
            int selectedId = rgDistance.getCheckedRadioButtonId();

            if (selectedId == R.id.rbKmToMiles) {
                resultat = valeur * 0.621371;
                String message = String.format(Locale.FRANCE, getString(R.string.resultat_format), resultat) + " milles";
                tvResultatDistance.setText(message);
            } else {
                resultat = valeur * 1.609344;
                String message = String.format(Locale.FRANCE, getString(R.string.resultat_format), resultat) + " km";
                tvResultatDistance.setText(message);
            }
        });

        return vue;
    }
}