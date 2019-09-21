package com.bcil.testtablayoutviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

	TabLayout myTabLayout;
	ViewPager myViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myTabLayout = (TabLayout) findViewById(R.id.myTabLayout);
		myViewPager = (ViewPager) findViewById(R.id.myViewPager);

		myTabLayout.addTab(myTabLayout.newTab().setText("Home"));
		myTabLayout.addTab(myTabLayout.newTab().setText("Sport"));
		myTabLayout.addTab(myTabLayout.newTab().setText("Movie"));

		final MyAdapter myAdapter = new MyAdapter(this, getSupportFragmentManager(), myTabLayout.getTabCount());
		myViewPager.setAdapter(myAdapter);

		myViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(myTabLayout));

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
