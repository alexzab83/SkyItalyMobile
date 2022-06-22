package it.pietrantuono.skyitaly.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.pietrantuono.skyitaly.databinding.ActivityLoginBinding;
import it.pietrantuono.skyitaly.databinding.ActivityRecuperoPasswordBinding;
import it.pietrantuono.skyitaly.network.model.User;
import it.pietrantuono.skyitaly.ui.callbacks.ILoginCallback;
import it.pietrantuono.skyitaly.ui.viewmodel.SkiResortViewModel;

public class RecuperoPassword extends AppCompatActivity implements ILoginCallback {

    private ActivityRecuperoPasswordBinding binding;
    private String txtemail;

    private SkiResortViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {   // associazione layout all'activity
        super.onCreate(savedInstanceState);
        binding =ActivityRecuperoPasswordBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        viewModel = new SkiResortViewModel(this);
        binding.btnResetPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                txtemail=binding.email.getText().toString();
                if (checkEmail(txtemail))
                    viewModel.recoveryPassword(txtemail, RecuperoPassword.this);
            }
        });
    }

    public boolean checkEmail(String email) {
        String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";         // ^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        Boolean result = matcher.matches();
        return result;
    }

    @Override
    public void loginSuccess(User u) {

    }

    @Override
    public void loginFail() {

    }
}