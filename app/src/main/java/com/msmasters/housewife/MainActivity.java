package com.msmasters.housewife;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.VisibilityAwareImageButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FloatingActionButton fab_menu_open, fab_menu_close, fab_menu_semana, fab_menu_mes, fab_menu_compra, fab_menu_receita;
    private RecyclerView rv;
    private Context context;
    private List<MenuSemana> menu;
    private TextView data_txt, txt_menu_semana, txt_menu_mes, txt_menu_compra, txt_menu_receita;
    private LinearLayout linl_add;

    private Animation anim_slide_down, anim_slide_up, anim_rotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getId();
        fab_menu_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab_menu_semana.setVisibility(View.VISIBLE);
                fab_menu_semana.startAnimation(anim_slide_down);
                fab_menu_mes.setVisibility(View.VISIBLE);
                fab_menu_mes.startAnimation(anim_slide_down);
                fab_menu_compra.setVisibility(View.VISIBLE);
                fab_menu_compra.startAnimation(anim_slide_down);
                fab_menu_receita.setVisibility(View.VISIBLE);
                fab_menu_receita.startAnimation(anim_slide_down);



                txt_menu_semana.setVisibility(View.VISIBLE);
                txt_menu_semana.startAnimation(anim_slide_down);
                txt_menu_mes.setVisibility(View.VISIBLE);
                txt_menu_mes.startAnimation(anim_slide_down);
                txt_menu_compra.setVisibility(View.VISIBLE);
                txt_menu_compra.startAnimation(anim_slide_down);
                txt_menu_receita.setVisibility(View.VISIBLE);
                txt_menu_receita.startAnimation(anim_slide_down);

                linl_add.setVisibility(View.VISIBLE);
                fab_menu_close.setVisibility(View.VISIBLE);
                fab_menu_close.startAnimation(anim_rotation);
                fab_menu_open.setVisibility(View.GONE);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        fab_menu_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab_menu_semana.setVisibility(View.GONE);
                fab_menu_semana.startAnimation(anim_slide_up);
                fab_menu_mes.setVisibility(View.GONE);
                fab_menu_mes.startAnimation(anim_slide_up);
                fab_menu_compra.setVisibility(View.GONE);
                fab_menu_compra.startAnimation(anim_slide_up);
                fab_menu_receita.setVisibility(View.GONE);
                fab_menu_receita.startAnimation(anim_slide_up);
                txt_menu_semana.setVisibility(View.GONE);
                txt_menu_semana.startAnimation(anim_slide_up);
                txt_menu_mes.setVisibility(View.GONE);
                txt_menu_mes.startAnimation(anim_slide_up);
                txt_menu_compra.setVisibility(View.GONE);
                txt_menu_compra.startAnimation(anim_slide_up);
                txt_menu_receita.setVisibility(View.GONE);
                txt_menu_receita.startAnimation(anim_slide_up);


                linl_add.setVisibility(View.GONE);
                fab_menu_close.setVisibility(View.GONE);
                fab_menu_open.setVisibility(View.VISIBLE);
                fab_menu_open.startAnimation(anim_rotation);

            }
        });

        fab_menu_semana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MenuAddSemana.class);
                MainActivity.this.startActivity(i);
            }
        });

        txt_menu_semana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MenuAddSemana.class);
                MainActivity.this.startActivity(i);
            }
        });

        fab_menu_compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MenuAddCompra.class);
                MainActivity.this.startActivity(i);
            }
        });

        txt_menu_compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MenuAddCompra.class);
                MainActivity.this.startActivity(i);
            }
        });

        fab_menu_receita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MenuAddReceita.class);
                MainActivity.this.startActivity(i);
            }
        });

        txt_menu_receita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MenuAddReceita.class);
                MainActivity.this.startActivity(i);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd - MM -yyyy ");
        String strData = ""+ mdformat.format(calendar.getTime());
        data_txt.setText(strData);
        initMenu();
        initAdapter();
    }

    private void getId(){

        fab_menu_open = (FloatingActionButton) findViewById(R.id.fab);
        fab_menu_close = (FloatingActionButton) findViewById(R.id.fab_close);

        fab_menu_semana = (FloatingActionButton) findViewById(R.id.fab_add_menu_semana);
        fab_menu_mes = (FloatingActionButton) findViewById(R.id.fab_add_menu_mes);
        fab_menu_compra = (FloatingActionButton) findViewById(R.id.fab_add_menu_compra);
        fab_menu_receita = (FloatingActionButton) findViewById(R.id.fab_add_menu_receita);

        txt_menu_semana = (TextView) findViewById(R.id.txt_add_menu_semana);
        txt_menu_mes = (TextView) findViewById(R.id.txt_add_menu_mes);
        txt_menu_compra = (TextView) findViewById(R.id.txt_add_menu_compra);
        txt_menu_receita = (TextView) findViewById(R.id.txt_add_menu_receita);
        linl_add = (LinearLayout) findViewById(R.id.linearLayout_add);

        anim_slide_down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        anim_slide_up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        anim_rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotation);

        data_txt = (TextView) findViewById(R.id.textView4);
        rv = (RecyclerView) findViewById(R.id.recyclerViewMenu);
        rv.setHasFixedSize(true);

        LinearLayoutManager lineartManager = new LinearLayoutManager(context);
        rv.setLayoutManager(lineartManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(menu);


    }

    private void initMenu()
    {
        menu = new ArrayList<>();
        menu.add(new MenuSemana("Arroz de molho branco", "Caldeirada", "Sandes de ovo", R.drawable.ic_seg));
        menu.add(new MenuSemana("Feijoada", "Salada fria", "Sandes mista", R.drawable.ic_ter));
        menu.add(new MenuSemana("Funge com molho de frango", "Massa com bife de isca e salada", "Farinha musseque", R.drawable.ic_qua));
        menu.add(new MenuSemana("Caldeirada", "Papa de aveia", "Pipoca", R.drawable.ic_qui));
        menu.add(new MenuSemana("Cachupa", "Cachupa", "Pizza", R.drawable.ic_sex));
        menu.add(new MenuSemana("Mufete", "Massa com todos", "Sumo de beterraba", R.drawable.ic_sab));
        menu.add(new MenuSemana("Funge de calulú", "Arroz doce", "Farinha musseque", R.drawable.ic_dom));


    }

    private void initAdapter()
    {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(menu);
        rv.setAdapter(adapter);
    }

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sobre) {
            Intent i = new Intent(MainActivity.this, Sobre.class);
            MainActivity.this.startActivity(i);
            return true;
        }
        if (id == R.id.action_ajuda) {
            Intent i = new Intent(MainActivity.this, Ajuda.class);
            MainActivity.this.startActivity(i);
            return true;
        }
        if (id == R.id.action_sair) {
            finish();
            Process.killProcess(Process.myPid());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu_semana) {
            // Handle the camera action
        } else if (id == R.id.nav_menu_mes) {

        } else if (id == R.id.nav_receitas) {

        } else if (id == R.id.nav_compras) {

        } else if (id == R.id.nav_partilhar) {

        } else if (id == R.id.nav_configuracoes) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
