package pl.beeraddict.baapp;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

/**
 * Beer Addict application
 * (Also a dagger module injecting itself as an Android app)
 */
@Module
public class BeerAddictApp extends Application {

    private BeerAddictComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
        component = DaggerBeerAddictComponent.builder()
                .beerAddictApp(this)
                .androidModule(new AndroidModule())
                .bootstrapModule(new BootstrapModule())
                .build();
    }

    public BeerAddictComponent getComponent() {
        return component;
    }

    @Provides
    public Application getInstance() {
        return this;
    }
}
