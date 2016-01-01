package pl.beeraddict.baapp.di;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import pl.beeraddict.baapp.BeerAddictApp;
import pl.beeraddict.baapp.di.modules.AndroidModule;
import pl.beeraddict.baapp.di.modules.ApplicationModule;
import pl.beeraddict.baapp.di.modules.UtilsModule;

/**
 * We want to have one Dagger component in the application
 * <p/>
 * The buildComponent method is used to constructs it given the application instance.
 * BeerAddictApp saves the component and allows to fetch it back using getComponent method.
 * <p/>
 * The getComponent method extracts the application from any activity or fragment, casts
 * it to BeerAddictApp and returns the component stored in it.
 *
 * @see BeerAddictApp
 */
public class DaggerHelper {
    public static BeerAddictComponent buildComponent(Application app) {
        return DaggerBeerAddictComponent.builder()
                .applicationModule(new ApplicationModule(app))
                .androidModule(new AndroidModule())
                .utilsModule(new UtilsModule())
                .build();
    }

    public static BeerAddictComponent getComponent(Application app) {
        BeerAddictApp baapp = (BeerAddictApp) app;
        return baapp.getComponent();
    }

    public static BeerAddictComponent getComponent(Activity activity) {
        return getComponent(activity.getApplication());
    }

    public static BeerAddictComponent getComponent(Fragment fragment) {
        return getComponent(fragment.getActivity().getApplication());
    }
}
