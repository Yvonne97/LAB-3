package v.strathmore.com.lab3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DatabaseHelper db = new DatabaseHelper(this);

        /*
        CRUD OPERATIONS
         */

        //inserting vehicles
        Log.d("Insert: ", "Inserting...");
        db.addVehicle(new Vehicles("Mercedes", "2003"));
        db.addVehicle(new Vehicles("Mitsubishi", "2011"));
        db.addVehicle(new Vehicles("Kia", "2006"));
        db.addVehicle(new Vehicles("Peugeot", "1997"));

        //reading all vehicles
        Log.d("Reading: ", "Reading all vehicles...");
        List<Vehicles> vehicles = db.getAllVehicles();

        for (Vehicles cn : vehicles) {
            String log = "Id: "+cn.getID()+" ,Make: "+cn.getMake() +
                    " ,Year: " +cn.getYear();
            //writing contacts to log
            Log.d("Make: ", log);
        }

        //inserting users
        Log.d("Insert: ", "Inserting...");
        db.addUser(new Users("Jeff", "23"));
        db.addUser(new Users("Elinor", "21"));
        db.addUser(new Users("Michael", "16"));
        db.addUser(new Users("Ciru", "29"));

        //reading all vehicles
        Log.d("Reading: ", "Reading all users...");
        List<Users> users = db.getAllUsers();

        for (Users cn : users) {
            String log = "Id: "+cn.getID()+" ,Name: "+cn.getName() +
                    " ,Age: " +cn.getAge();
            //writing contacts to log
            Log.d("Name: ", log);
        }

        //inserting colors
        Log.d("Insert: ", "Inserting...");
        db.addColor(new Colors("Red", "Yellow"));
        db.addColor(new Colors("Green", "Blue"));
        db.addColor(new Colors("Orange", "Purple"));
        db.addColor(new Colors("Violet", "Brown"));

        //reading all colors
        Log.d("Reading: ", "Reading all colors...");
        List<Colors> colors = db.getAllColors();

        for (Colors cn : colors) {
            String log = "Id: "+cn.getID()+" ,Color_1: "+cn.getColor1() +
                    " ,Color_2: " +cn.getColor2();
            //writing contacts to log
            Log.d("Color_1: ", log);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
