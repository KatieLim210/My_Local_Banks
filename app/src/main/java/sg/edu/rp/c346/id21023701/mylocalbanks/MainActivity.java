package sg.edu.rp.c346.id21023701.mylocalbanks;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView dbs;
TextView ocbc;
TextView uob;
String wordClicked = "";
boolean favDBS;
boolean favOCBC;
boolean favUOB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#F4A460"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        dbs = findViewById(R.id.textViewDBS);
        ocbc = findViewById(R.id.textViewOCBC);
        uob = findViewById(R.id.textViewUOB);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");

        if (v == dbs) {
            wordClicked = "dbs";
        }
        else if (v == ocbc) {
            wordClicked = "ocbc";

        }
        else if (v == uob){
            wordClicked = "uob";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("dbs")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentwebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentwebsite);
            }
            else if(item.getItemId()==1){
                Intent intentcall = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + "18001111111"));
                startActivity(intentcall);
            }
            else if(item.getItemId()==2){
                if(favDBS == false){
                    dbs.setTextColor(Color.parseColor("#000000"));
                    favDBS = true;
                }else if(favDBS == true){
                    dbs.setTextColor(Color.parseColor("#B22222"));
                    favDBS = false;
                }
            }


                return true; //menu item successfully handled
        }

        if(wordClicked.equalsIgnoreCase("ocbc")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 1
                //code for action
                Intent intentwebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentwebsite);
            }
            else if(item.getItemId()==1){
                Intent intentcall = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + "18003633333"));
                startActivity(intentcall);
            }
            else if(item.getItemId()==2){
                if(favOCBC == false){
                    ocbc.setTextColor(Color.parseColor("#000000"));
                    favOCBC = true;
                }else if(favOCBC == true){
                    ocbc.setTextColor(Color.parseColor("#B22222"));
                    favOCBC = false;
                }
            }


            return true; //menu item successfully handled
        }
        if(wordClicked.equalsIgnoreCase("uob")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 1
                //code for action
                Intent intentwebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentwebsite);
            }
            else if(item.getItemId()==1){
                Intent intentcall = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + "18002222121"));
                startActivity(intentcall);
                    return true; //menu item successfully handled
                }
            }else if(item.getItemId()==2){
            if(favUOB == false){
                uob.setTextColor(Color.parseColor("#000000"));
                favUOB = true;
            }else if(favUOB == true){
                uob.setTextColor(Color.parseColor("#B22222"));
                favUOB = false;
            }
        }


        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;
        } else {
            dbs.setText("Error translation");
            ocbc.setText("Error translation");
            uob.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }


    }




