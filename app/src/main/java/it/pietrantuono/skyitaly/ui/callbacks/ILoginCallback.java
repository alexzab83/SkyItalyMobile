package it.pietrantuono.skyitaly.ui.callbacks;

import it.pietrantuono.skyitaly.network.model.User;

public interface ILoginCallback {

    void loginSuccess(User u);

    void loginFail();
}
