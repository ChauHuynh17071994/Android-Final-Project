package com.example.chauhuynhnits15k.pizza_huynh;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainScreen extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        // Set up click listeners for all the buttons
        Button getStartedButton = findViewById(R.id.get_started_button);
        getStartedButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_started_button:
                if (getName().equals("") || getName() == null) {
                    new AlertDialog().Builder(this).setTitle(R.string.incomplete_title).setMessage(R.string.enter_name_text).setCancelable(false)
                            .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
                } else {
                    Intent i = new Intent(this, OrderPage.class);
                    startActivity(i);
                }
                break;
            // More buttons go here (if any) ...
        }
    }

    public String getName() {
        return name.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                //			startActivity(new Intent(this, Prefs.class));
                return true;
            case R.id.help:
                new AlertDialog.Builder(this).setTitle(R.string.help_title).setMessage(R.string.enter_name_help).setCancelable(false)
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
                return true;
            case R.id.exit:
                new AlertDialog.Builder(this).setTitle(R.string.exit).setMessage("Are you sure you want to exit?").setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
                return true;
        }
        return false;
    }
}
