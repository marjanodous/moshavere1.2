
package com.example.hoquqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    public static String Transaction_type;
    ImageView imgMenu;
    DrawerLayout myDraw;
    TextView call_me,sing_up_moshaver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tab);
        viewPager=findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        viewPagerAdapter adapter=new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFrg(new home(),"اصلی");
        adapter.addFrg(new ayamidanid(),"آیا میدانید های حقوقی");
        adapter.addFrg(new khanevade(),"خانواده");
        adapter.addFrg(new nahvekar(),"نحوه کار");
        adapter.addFrg(new mohajerat(),"مهاجرت");
        adapter.addFrg(new maliati(),"مالیاتی");
        viewPager.setAdapter(adapter);

         if (tabLayout.getSelectedTabPosition() == 0) {
        Transaction_type = ChosoeTabs.getChooseTabhome();
    }
        else if (tabLayout.getSelectedTabPosition() == 2) {
        Transaction_type = ChosoeTabs.getChooseTab_khanevade();
    }
        else if (tabLayout.getSelectedTabPosition() == 1) {
        Transaction_type = ChosoeTabs.getChooseTab_ayamidanid();
    }
        else if (tabLayout.getSelectedTabPosition() == 3) {
            Transaction_type = ChosoeTabs.getChooseTab_nahvekar();
        }
        else if (tabLayout.getSelectedTabPosition() == 4) {
            Transaction_type = ChosoeTabs.getChooseTab_mohajerat();
        }
        else if (tabLayout.getSelectedTabPosition() == 5) {
            Transaction_type = ChosoeTabs.getChooseTab_maliati();
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        //==============open draw=============================
        imgMenu = findViewById(R.id.img_menu);
        myDraw = findViewById(R.id.myDraw);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDraw.openDrawer(Gravity.RIGHT);
            }
        });
        sing_up_moshaver=findViewById(R.id.txt_sing_up_moshaver);
        sing_up_moshaver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,singup_moshavere.class));
            }
        });
}
    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
