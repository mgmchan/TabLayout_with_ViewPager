package com.bcil.testtablayoutviewpager;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
	private Context myContext;
	int totalTabs;

	public MyAdapter(Context context, FragmentManager fm, int ttlTabs) {
		super(fm);
		myContext = context;
		this.totalTabs = ttlTabs;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
			case 0:
				return new HomeFragment();
			case 1:
				return new HomeFragment();
			case 2:
				return new HomeFragment();
			case 3:
				return new HomeFragment();
			case 4:
				return new HomeFragment();
			case 5:
				return new HomeFragment();
			case 6:
				return new HomeFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		return totalTabs;
	}
}
