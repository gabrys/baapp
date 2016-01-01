package pl.beeraddict.baapp.ui;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.uncod.android.bypass.Bypass;
import pl.beeraddict.baapp.BeerAddictApp;
import pl.beeraddict.baapp.R;

public class AleActivity extends AppCompatActivity {
    @Bind(R.id.ale_title)
    protected TextView title;

    @Bind(R.id.ale_content)
    protected TextView content;

    @Bind(R.id.drawer_layout)
    protected DrawerLayout drawerLayout;

    @Inject
    protected Bypass bypass;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        setupDrawerToggle();

        ((BeerAddictApp) getApplication()).getComponent().inject(this);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Ale");

        CharSequence text = bypass.markdownToSpannable("#Header sizes\n" +
                "##Smaller header\n" +
                "###Even smaller header\n" +
                "###Even smaller header\n" +
                "###Even smaller header\n" +
                "###Even smaller header\n" +
                "###Even smaller header\n" +
                "\n" +
                "Paragraphs are obviously supported along with all the fancy text styling you could want.\n" +
                "There is *italic*, **bold** and ***bold italic***. Even links are supported, visit the\n" +
                "github page for Bypass [github](http://www.github.com/).\n" +
                "\n" +
                "* Nested List\n" +
                "\t* One\n" +
                "\t* Two\n" +
                "\t* Three\n" +
                "* One\n" +
                "\t* One\n" +
                "\t* Two\n" +
                "\t* Three\n" +
                "\n" +
                "## Code Block Support\n" +
                "\n" +
                "    const char* str;\n" +
                "    str = env->GetStringUTFChars(markdown, NULL);");

        content.setText(text);
        content.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setupDrawerToggle() {
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        drawerFragment.setUp(drawerFragment.getView(), drawerLayout);
    }
}
