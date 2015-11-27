package pl.beeraddict.baapp;

import android.accounts.AccountsException;
import android.app.Activity;

import pl.beeraddict.baapp.core.BootstrapService;

import java.io.IOException;

public interface BootstrapServiceProvider {
    BootstrapService getService(Activity activity) throws IOException, AccountsException;
}
