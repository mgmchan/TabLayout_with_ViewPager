package com.bcil.testtablayoutviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener;

public class MainActivity extends AppCompatActivity {

	TabLayout myTabLayout;
	ViewPager myViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Obtain reference to TabLayout and ViewPager
		myTabLayout = (TabLayout) findViewById(R.id.myTabLayout);
		myViewPager = (ViewPager) findViewById(R.id.myViewPager);

		// Create the tabs
		// These 2 lines makes long tab lists (not recommended from UX) scrollable automatically
		myTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
		myTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

		// Add the tabs
		myTabLayout.addTab(myTabLayout.newTab().setText("Home"));
		myTabLayout.addTab(myTabLayout.newTab().setText("Sport"));
		myTabLayout.addTab(myTabLayout.newTab().setText("Movie"));
		myTabLayout.addTab(myTabLayout.newTab().setText("Long Tab 4"));
		myTabLayout.addTab(myTabLayout.newTab().setText("Tab 5"));
		myTabLayout.addTab(myTabLayout.newTab().setText("Tab 6"));
		myTabLayout.addTab(myTabLayout.newTab().setText("Tab 7"));

		// Setup ViewPager adapter
		final MyAdapter myAdapter = new MyAdapter(this, getSupportFragmentManager(), myTabLayout.getTabCount());
		myViewPager.setAdapter(myAdapter);

		// Setup PageChange listener so as to call TabLayout's to keep tab highlights in sync
		myViewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(myTabLayout));

		myTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				myViewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}
		});
	}
}
