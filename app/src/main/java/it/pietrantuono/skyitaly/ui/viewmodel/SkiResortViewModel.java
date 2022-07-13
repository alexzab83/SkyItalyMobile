package it.pietrantuono.skyitaly.ui.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import it.pietrantuono.skyitaly.network.SkiResortCaller;
import it.pietrantuono.skyitaly.network.UserCaller;
import it.pietrantuono.skyitaly.ui.callbacks.IListPlantCallback;
import it.pietrantuono.skyitaly.ui.callbacks.ILoginCallback;
import it.pietrantuono.skyitaly.ui.callbacks.ISkiResortCallback;
import it.pietrantuono.skyitaly.utils.PreferencesUtils;

public class SkiResortViewModel extends ViewModel {

    private Context context;

    public SkiResortViewModel(Context context){
        this.context = context;
    }

    public void login(String email, String password, ILoginCallback callback){
        UserCaller userCaller = new UserCaller(context , callback);
        userCaller.login(email, password);
    }

    public void changePassword(String email, String oldPassword, String newPassword,  ILoginCallback callback){
        UserCaller userCaller = new UserCaller(context , callback);
        userCaller.changePassword(email, oldPassword, newPassword);
    }

    public void recoveryPassword(String email, ILoginCallback callback){
        UserCaller userCaller = new UserCaller(context , callback);
        userCaller.recoveryPassword(email);
    }

    public void getSkiResort(ISkiResortCallback callback, int type){
        SkiResortCaller caller = new SkiResortCaller(context, callback);
        caller.getSkiResorts(PreferencesUtils.getUser(context).getId(), type);
    }

    public void getPlantList(IListPlantCallback callback, int idSkiMap){
        SkiResortCaller caller = new SkiResortCaller(context, callback);
        caller.getListPlants(idSkiMap);
    }

    public void addRemoveFavorite( int userId, int idSkiMap, boolean addRemove){
        SkiResortCaller caller = new SkiResortCaller(context);
        caller.addRemoveFavorite(userId, idSkiMap, addRemove);
    }
}
