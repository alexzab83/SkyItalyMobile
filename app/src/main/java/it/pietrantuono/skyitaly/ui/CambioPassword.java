package it.pietrantuono.skyitaly.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import it.pietrantuono.skyitaly.databinding.ActivityCambioPasswordBinding;
import it.pietrantuono.skyitaly.databinding.ActivityLoginBinding;

public class CambioPassword extends BaseActivity {

    private ActivityCambioPasswordBinding binding;
    private String oldPassword;
    private String newPassword;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCambioPasswordBinding.inflate(getLayoutInflater());   // accesso a tute le risorse grafiche inserite nel activity log_in xml
        View view = binding.getRoot();
        setContentView(view);     //

        binding.btnCambioPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RecuperoPassword.class);
                oldPassword = binding.oldpassword.getText().toString();
                newPassword = binding.newpassword.getText().toString();
                if (checkFieldPassword(oldPassword, newPassword) && checkPassword(oldPassword) && checkPassword(newPassword)) {
                    startActivity(new Intent(v.getContext(), SkiMapListActivity.class));
                    finish();
                } else
                    Toast.makeText(v.getContext(), "CampiErrati", Toast.LENGTH_LONG).show();
            }

        });
    }

    private boolean checkFieldPassword(String oldPassword, String newPassword) {     // da implementare(controllo due campi email e password)
        return (oldPassword.isEmpty() || newPassword.isEmpty());

    }

    public boolean checkPassword(String password) {
        if (password.length() < 6) return false;
        return true;
    }
}