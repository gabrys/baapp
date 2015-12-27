package pl.beeraddict.baapp;

import pl.beeraddict.baapp.core.TimerService;
import pl.beeraddict.baapp.ui.BootstrapActivity;
import pl.beeraddict.baapp.ui.BootstrapFragmentActivity;
import pl.beeraddict.baapp.ui.BootstrapTimerActivity;
import pl.beeraddict.baapp.ui.CheckInsListFragment;
import pl.beeraddict.baapp.ui.MainActivity;
import pl.beeraddict.baapp.ui.NavigationDrawerFragment;
import pl.beeraddict.baapp.ui.NewsActivity;
import pl.beeraddict.baapp.ui.NewsListFragment;
import pl.beeraddict.baapp.ui.UserActivity;
import pl.beeraddict.baapp.ui.UserListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AndroidModule.class,
                BootstrapModule.class
        }
)
public interface BootstrapComponent {

    void inject(BootstrapApplication target);

    void inject(BootstrapTimerActivity target);

    void inject(MainActivity target);

    void inject(CheckInsListFragment target);

    void inject(NavigationDrawerFragment target);

    void inject(NewsActivity target);

    void inject(NewsListFragment target);

    void inject(UserActivity target);

    void inject(UserListFragment target);

    void inject(TimerService target);

    void inject(BootstrapFragmentActivity target);
    void inject(BootstrapActivity target);


}
