package it.pietrantuono.skyitaly.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.pietrantuono.skyitaly.R;
import it.pietrantuono.skyitaly.databinding.ActivityLoginBinding;
import it.pietrantuono.skyitaly.network.model.User;
import it.pietrantuono.skyitaly.ui.callbacks.ILoginCallback;
import it.pietrantuono.skyitaly.ui.viewmodel.SkiResortViewModel;

public class LoginActivity extends BaseActivity implements ILoginCallback {

    private ActivityLoginBinding binding;
    private String txtemail;
    private String txtPassword;
    private SkiResortViewModel viewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());   // accesso a tute le risorse grafiche inserite nel activity log_in xml
        View view = binding.getRoot();
        setContentView(view);     //
        viewModel = new SkiResortViewModel(this);
        //leggere ciò che è stato scritto nel campo password
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), RecuperoPassword.class);
                txtemail = binding.email.getText().toString();       //leggere ciò che è stato scritto nel campo email
                txtPassword = binding.password.getText().toString();
                if (checkField(txtemail, txtPassword) && checkEmail(txtemail) && checkPassword(txtPassword)) {
                    viewModel.login(binding.email.getText().toString(), binding.password.getText().toString(), LoginActivity.this);
                } else
                    Toast.makeText(v.getContext(), "CampiErrati", Toast.LENGTH_LONG).show();



            }
        });

        binding.btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), RecuperoPassword.class));
            }
        });
    }

    private boolean checkField(String username, String password) {     // da implementare(controllo due campi email e password)
        return !(username.isEmpty() || password.isEmpty());

    }

    public boolean checkEmail(String email) {
        String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";         // ^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        Boolean result = matcher.matches();
        return result;
    }

    public boolean checkPassword(String password) {
        if (password.length() < 6) return false;
        return true;
    }


    @Override
    public void loginSuccess(User u) {

    }

    @Override
    public void loginFail() {

    }

}


