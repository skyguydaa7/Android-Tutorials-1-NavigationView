package com.lbbento.blogsamples;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by lbbento on 03/08/15.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //NavigationDrawerLayout
    private DrawerLayout mNavigationDrawer;
    //NavigationView
    private NavigationView mNavigationView;
    //Toolbar
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind NavigationDrawer
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.main_side_menu);
        //Bind NavigationView
        mNavigationView = (NavigationView) findViewById(R.id.main_navigationview);
        //Bind toolbar
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);

        //SetUp
        mNavigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Set First Item as Initial COntent
        switchContent(Action1Fragment.newInstance("Action 1"));
        mNavigationView.getMenu().getItem(0).setChecked(true);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case(android.R.id.home):
                if (mNavigationDrawer.isDrawerOpen(GravityCompat.START))
                    mNavigationDrawer.closeDrawer(GravityCompat.START);
                else
                    mNavigationDrawer.openDrawer(GravityCompat.START);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

        @Override
        public boolean onNavigationItemSelected(MenuItem menuselected) {
            switch (menuselected.getItemId()) {
                case R.id.action_1:
                    switchContent(Action1Fragment.newInstance(menuselected.getTitle().toString()));
                    break;
                case R.id.action_2:
                    switchContent(Action2Fragment.newInstance(menuselected.getTitle().toString()));
                    break;
                default:
                    return false;
            }
            //check current item
            menuselected.setChecked(true);
            mNavigationDrawer.closeDrawers();
            return true;
        }

    public void switchContent(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content_frame, fragment, fragment.getClass().getName())
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }



}
