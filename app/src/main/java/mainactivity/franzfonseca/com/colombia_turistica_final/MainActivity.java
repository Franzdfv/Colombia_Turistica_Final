package mainactivity.franzfonseca.com.colombia_turistica_final;


import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private String[] opciones;
    private ListView listView;
    private android.support.v7.app.ActionBar ab;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    private CharSequence tituloSec;
    private CharSequence tituloApp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opciones= new String[]{"Sitios Turisticos", "Bares", "Hoteles", "Demografia", "Diseñador" };
        listView= (ListView) findViewById(R.id.menuIzq);
        drawerLayout = (DrawerLayout)findViewById(R.id.contenedorprincipal);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),android.R.layout.simple_list_item_1, opciones));

        ab = getSupportActionBar();
        if (ab !=null){
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new PrimerFragment();
                        break;
                    case 1:
                        fragment = new SegundoFragment();
                        break;
                    case 2:
                        fragment = new TercerFragment();
                        break;
                    case 3:
                        fragment = new CuartoFragment();
                        break;
                    case 4:
                        fragment = new QuintoFragment();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
                listView.setItemChecked(position, true);
                tituloSec = opciones[position];
                ab.setTitle(tituloSec);
                drawerLayout.closeDrawer(listView);

            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.ic_menu_white_24dp,R.string.abierto,R.string.cerrado);

        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
