package com.example.materialtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.bumptech.glide.Glide;
import com.example.materialtest.R;
import com.example.materialtest.fragment.Fragment01;
import com.example.materialtest.fragment.Fragment02;

import java.util.ArrayList;

public class FruitActivity2 extends AppCompatActivity {

    public static final String FRUIT_NAME = "fruit_name";

    public static final String FRUIT_IMAGE_ID = "fruit_image_id";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit2);
        Intent intent = getIntent();
//        String fruitName = intent.getStringExtra(FRUIT_NAME);
        int fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID, 0);

        ImageView fruitImageView = (ImageView) findViewById(R.id.fruit_image_view);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.vp);
//        TextView fruitContentText = (TextView) findViewById(R.id.fruit_content_text);

        Glide.with(this).load(fruitImageId).into(fruitImageView);
//        String fruitContent = generateFruitContent(fruitName);
//        fruitContentText.setText(fruitContent);

        performVP();
        performTab();
    }

    private void performVP() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new Fragment01());
        fragments.add(new Fragment02());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }

    private void performTab() {
//        tabLayout.addTab(tabLayout.newTab().setText("NBA"));
//        tabLayout.addTab(tabLayout.newTab().setText("CBA"));
//        tabLayout.setupWithViewPager(viewPager);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

//    private String generateFruitContent(String fruitName) {
//        StringBuilder fruitContent = new StringBuilder();
//        for (int i = 0; i < 500; i++) {
//            fruitContent.append(fruitName);
//        }
//        return fruitContent.toString();
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
