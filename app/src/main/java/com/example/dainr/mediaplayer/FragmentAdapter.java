package com.example.dainr.mediaplayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * A {@link FragmentAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 * This adapter will display each fragment on the screen to user
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    // Find the position of each tab
    // getItem is called to instantiate the fragment for the given tab.
    // Return a PlaceholderFragment (defined as a static inner class below).

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SongsFragment();
            case 1:
                return new AlbumsFragment();
            case 2:
                return new ArtistsFragment();
                   }
        return null;
    }


    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {

            case 0:
                return "SONGS";
            case 1:
                return "ALBUMS";
            case 2:
                return "ARTISTS";
                   }
        return null;
    }
}