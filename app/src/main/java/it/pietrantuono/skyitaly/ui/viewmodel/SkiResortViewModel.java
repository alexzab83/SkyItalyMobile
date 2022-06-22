package it.pietrantuono.skyitaly.ui.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import it.pietrantuono.skyitaly.network.SkiResortCaller;
import it.pietrantuono.skyitaly.ui.callbacks.ILoginCallback;

public class SkiResortViewModel extends ViewModel {

    private Context context;

    public SkiResortViewModel(Context context){
        this.context = context;
    }

    public void login(String email, String password, ILoginCallback callback){
        SkiResortCaller skiResortCaller = new SkiResortCaller(context , callback);
        skiResortCaller.login(email, password);
    }

    public void changePassword(String email, String oldPassword, String newPassword,  ILoginCallback callback){
        SkiResortCaller skiResortCaller = new SkiResortCaller(context , callback);
        skiResortCaller.changePassword(email, oldPassword, newPassword);
    }

    public void recoveryPassword(String email, ILoginCallback callback){
        SkiResortCaller skiResortCaller = new SkiResortCaller(context , callback);
        skiResortCaller.recoveryPassword(email);
    }
}
