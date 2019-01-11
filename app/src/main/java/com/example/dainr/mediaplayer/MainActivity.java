package com.example.dainr.mediaplayer;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
         {
             private ViewPager viewPager;
             private DrawerLayout drawer;
             public String title;

             private TabLayout tabLayout;
             private String[] pageTitle = {"SONGS", "ALBUMS", "ARTISTS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.view_pager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (int i = 0; i < 3; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

            //set viewpager adapter
            FragmentAdapter pagerAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

            //change Tab selection when swipe ViewPager
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

            //change ViewPager page when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });

        if (savedInstanceState == null) {
                navigationView.getMenu().performIdentifierAction(R.id.nav_library,0);
            }}

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation view item clicks here.
                FragmentManager fm = getSupportFragmentManager();
                switch (item.getItemId()) {
                    case R.id.nav_library:
                        title = "Library";
                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.nav_playlists:
                        title = "Playlists";
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.nav_now_playing:
                        title = "Now Playing";
                        viewPager.setCurrentItem(2);
                        break;

                    case R.id.nav_folders:
                        title = "Folders";
                        viewPager.setCurrentItem(3);
                        break;

                    case R.id.nav_settings:
                        title = "Settings";
                        viewPager.setCurrentItem(4);
                        break;

                    case R.id.nav_about:
                        title = "About Us";
                        viewPager.setCurrentItem(5);
                        break;
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            item.setChecked(true);
            getSupportActionBar().setTitle(title);
            assert drawer != null;
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        }


