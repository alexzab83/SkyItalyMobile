package it.pietrantuono.skyitaly.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import it.pietrantuono.skyitaly.databinding.ActivityLoginBinding;
import it.pietrantuono.skyitaly.databinding.ActivityRecuperoPasswordBinding;

public class RecuperoPassword extends AppCompatActivity {

    private ActivityRecuperoPasswordBinding binding;
    private String txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {   // associazione layout all'activity
        super.onCreate(savedInstanceState);
        binding =ActivityRecuperoPasswordBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);

        binding.btnResetPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                txtemail=binding.email.getText().toString();
            }
        });
    }
}