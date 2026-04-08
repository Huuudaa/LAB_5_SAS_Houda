package com.example.lab_5_sas_houda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AlertDialog;
import androidx.activity.OnBackPressedCallback;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayoutPrincipal;
    private ViewPager2 pagerPrincipal;
    private FragmentPagerAdapter monAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayoutPrincipal = findViewById(R.id.tabLayoutPrincipal);
        pagerPrincipal = findViewById(R.id.pagerPrincipal);

        monAdapter = new FragmentPagerAdapter(this);
        pagerPrincipal.setAdapter(monAdapter);

        new TabLayoutMediator(tabLayoutPrincipal, pagerPrincipal,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText(R.string.onglet_chaleur);
                    } else {
                        tab.setText(R.string.onglet_distance);
                    }
                }
        ).attach();

        // Gestion moderne du bouton Retour
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                montrerDialogueQuitter();
            }
        };
        this.getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, R.string.menu_quitter);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            montrerDialogueQuitter();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void montrerDialogueQuitter() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_quitter_titre)
                .setMessage(R.string.dialog_quitter_message)
                .setPositiveButton(R.string.oui, (dialog, which) -> finish())
                .setNegativeButton(R.string.non, null)
                .show();
    }
}