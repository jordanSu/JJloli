package com.example.jj.jjloli;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class loliList extends AppCompatActivity {
    private ArrayList<FloatingActionButton> deletingButtons;
    private ArrayList<FloatingActionButton> editingButtons;
    private Button editButton;
    private Boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loli_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditing) {
                    editButton.setText("Edit");
                    //TODO
                }
                else {
                    editButton.setText("Done");
                    //TODO
                }
            }
        });

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        deletingButtons.add((FloatingActionButton) findViewById(R.id.fab2));
        deletingButtons.add((FloatingActionButton) findViewById(R.id.fab4));
        deletingButtons.add((FloatingActionButton) findViewById(R.id.fab6));
        deletingButtons.add((FloatingActionButton) findViewById(R.id.fab8));
        deletingButtons.add((FloatingActionButton) findViewById(R.id.fab10));
        deletingButtons.add((FloatingActionButton) findViewById(R.id.fab12));

        editingButtons.add((FloatingActionButton) findViewById(R.id.fab1));
        editingButtons.add((FloatingActionButton) findViewById(R.id.fab3));
        editingButtons.add((FloatingActionButton) findViewById(R.id.fab5));
        editingButtons.add((FloatingActionButton) findViewById(R.id.fab7));
        editingButtons.add((FloatingActionButton) findViewById(R.id.fab9));
        editingButtons.add((FloatingActionButton) findViewById(R.id.fab11));
    }

}
