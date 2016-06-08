package mainactivity.franzfonseca.com.colombia_turistica_final;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;


public class Main3Activity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapter = new PageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);


        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener(){

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        ActionBar.Tab tab = actionBar.newTab().setText("Iglesia Ermita").setTabListener(tabListener);

        actionBar.addTab (tab);
        tab = actionBar.newTab().setText("Parque De La Cruz").setTabListener(tabListener);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Parque Ecológico").setTabListener(tabListener);
        actionBar.addTab(tab);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }
        });
    };

    public class PageAdapter extends FragmentPagerAdapter {


        public PageAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0: return new IglesiaErmitaFragment();
                case 1: return new ParquelacruzFragment();
                case 2: return new ParqeueEcologicoFragment();
                default: return null;

            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
