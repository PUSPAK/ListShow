package list.application.com.listshow.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import list.application.com.listshow.R;
/**
 * Created by Puspak on 30/07/18.
 */
public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.frame_container)
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, new ListFragment());
        ft.commitAllowingStateLoss();

    }



}
