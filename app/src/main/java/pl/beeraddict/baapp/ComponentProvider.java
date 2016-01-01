

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
public class ComponentProvider {

    private static BeerAddictComponent component;

    public static BeerAddictComponent getComponent() {
        return component;
    }

    public static void buildComponent(BeerAddictApp app) {
        component = DaggerBeerAddictComponent.builder()
                .beerAddictApp(app)
                .androidModule(new AndroidModule())
                .bootstrapModule(new BootstrapModule())
                .build();
    }
}
