package it.pietrantuono.skyitaly.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import it.pietrantuono.skyitaly.databinding.ActivityCambioPasswordBinding;
import it.pietrantuono.skyitaly.databinding.ActivityLoginBinding;
import it.pietrantuono.skyitaly.network.model.User;
import it.pietrantuono.skyitaly.ui.callbacks.ILoginCallback;
import it.pietrantuono.skyitaly.ui.viewmodel.SkiResortViewModel;
import it.pietrantuono.skyitaly.utils.PreferencesUtils;

public class CambioPassword extends BaseActivity implements ILoginCallback {

    private ActivityCambioPasswordBinding binding;
    private String oldPassword;
    private SkiResortViewModel viewModel;
    private String newPassword;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCambioPasswordBinding.inflate(getLayoutInflater());   // accesso a tute le risorse grafiche inserite nel activity log_in xml
        View view = binding.getRoot();
        setContentView(view);
        setActionBar();
        viewModel = new SkiResortViewModel(this);
        binding.btnCambioPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RecuperoPassword.class);
                oldPassword = binding.oldpassword.getText().toString();
                newPassword = binding.newpassword.getText().toString();
                if (checkFieldPassword(oldPassword, newPassword) && checkPassword(oldPassword) && checkPassword(newPassword)) {
                    viewModel.changePassword(PreferencesUtils.getUser(v.getContext()).getEmail(), oldPassword, newPassword, CambioPassword.this);
                } else
                    Toast.makeText(v.getContext(), "CampiErrati", Toast.LENGTH_LONG).show();
            }

        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private boolean checkFieldPassword(String oldPassword, String newPassword) {     // da implementare(controllo due campi email e password)
        return (!oldPassword.isEmpty() && !newPassword.isEmpty());

    }

    public boolean checkPassword(String password) {
        if (password.length() < 6) return false;
        return true;
    }

    @Override
    public void loginSuccess(User u) {
        Toast.makeText(this, "Password modificata con successo!", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "Errore nel cambio password", Toast.LENGTH_LONG).show();
    }
}