package pl.beeraddict.baapp.di;

import javax.inject.Singleton;

import dagger.Component;
import pl.beeraddict.baapp.BeerAddictApp;
import pl.beeraddict.baapp.di.modules.AndroidModule;
import pl.beeraddict.baapp.di.modules.ApplicationModule;
import pl.beeraddict.baapp.di.modules.UtilsModule;
import pl.beeraddict.baapp.ui.MainActivity;
import pl.beeraddict.baapp.ui.NavigationDrawerFragment;

@Singleton
@Component(
        modules = {
                AndroidModule.class,
                ApplicationModule.class,
                UtilsModule.class
        }
)
public interface BeerAddictComponent {
    void inject(BeerAddictApp target);

    void inject(NavigationDrawerFragment target);

    void inject(MainActivity target);
}
