package com.example.chessopenings;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;



import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private RecyclerView contactsRecView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();

        setContentView(R.layout.activity_main);

//        ActionBar actionBar=getSupportActionBar();
//        actionBar.setTitle(getResources().getString(R.string.app_name));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Nav_fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home1); // to place the first fragment
        }
    }

    
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;
        NavigationView navigationView = findViewById(R.id.nav_view);


        RelativeLayout rt=findViewById(R.id.Relativelay);


        if(id == R.id.nav_home1 || id==R.id.nav_Logout) {



            rt.setVisibility(View.VISIBLE);
            getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            navigationView.setCheckedItem(R.id.nav_home1);
            fragment = new Nav_fragment();
        }

        else if(id == R.id.nav_home) {



            rt.setVisibility(View.GONE);
            fragment = new HomeFragment();
        }
        else if(id == R.id.nav_about) {

            fragment = new AboutFragment();


            rt.setVisibility(View.GONE);
        }
        else if(id == R.id.nav_share) {
            getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            navigationView.setCheckedItem(R.id.nav_home1);
            Intent myIntent=new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareBody="Are you Intrested in learning more about Chess Openings? if yess then feel free to discover my application!!!:)";
            String shareSubject="Chess Openings";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);
            myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);


            startActivity(Intent.createChooser(myIntent,"Share using"));

        }
        else if(id == R.id.nav_settings) {
            fragment = new SettingsFragment();


            rt.setVisibility(View.GONE);


        }
        else if(id == R.id.nav_Quiz) {
            fragment = new QuizFragment();


            rt.setVisibility(View.GONE);
        }
        else if(id==R.id.languageIcon){
            showChangedLanguageDialog();

        }

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean GoingtoHomeFragment(View view) {
        // Hide the views
        Fragment fragment = null;


        RelativeLayout rt=findViewById(R.id.Relativelay);


        rt.setVisibility(View.GONE);
        fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setCheckedItem(R.id.nav_home);
        }
        return true;



    }
    public boolean GoingtoQuizFragment(View view) {
        // Hide the views
        Fragment fragment = null;


        RelativeLayout rt=findViewById(R.id.Relativelay);


        rt.setVisibility(View.GONE);
        fragment = new QuizFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setCheckedItem(R.id.nav_Quiz);
        }
        return true;



    }
    private void showChangedLanguageDialog(){
        final String[] listItems={"English","French","Portuguese","Arabic"};
        AlertDialog.Builder nBuilder=new AlertDialog.Builder(MainActivity.this);
        nBuilder.setTitle("ChooseLanguage....");
        nBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0){
                    setLocale("en");
                    recreate();
                }
                else if(which==1){
                    setLocale("fr");
                    recreate();
                }
                else if(which==2){
                    setLocale("pt");
                    recreate();
                }else if(which==3){
                    setLocale("ar");
                    recreate();
                }
                dialog.dismiss();


            }

        });
        AlertDialog nDialog= nBuilder.create();
        nDialog.show();
    }
    private void setLocale(String lang){
        Locale locale=new Locale(lang);
        locale.setDefault(locale);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor=getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }
    public void loadLocale(){
        SharedPreferences prefs=getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language=prefs.getString("My_Lang","");
        setLocale(language);
    }

}
