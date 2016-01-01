package pl.beeraddict.baapp;

import pl.beeraddict.baapp.di.BeerAddictComponent;
import pl.beeraddict.baapp.di.DaggerHelper;
import timber.log.Timber;

/**
 * Beer Addict application
 */
public class BeerAddictApp extends android.app.Application {

    private BeerAddictComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
        component = DaggerHelper.buildComponent(this);
    }

    public BeerAddictComponent getComponent() {
        return component;
    }
}
