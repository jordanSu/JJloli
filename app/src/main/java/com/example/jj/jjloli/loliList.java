package com.example.jj.jjloli;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class loliList extends AppCompatActivity {
    private ArrayList<FloatingActionButton> deletingButtons = new ArrayList<>();
    private ArrayList<FloatingActionButton> editingButtons = new ArrayList<>();
    private ArrayList<TextView> textViews = new ArrayList<>();
    private Button editButton;
    private Boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loli_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editButton = (Button) findViewById(R.id.editbutton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditing) {
                    editButton.setText("Edit");
                    for (int i=0; i<6; i++) {
                        deletingButtons.get(i).setVisibility(View.INVISIBLE);
                        editingButtons.get(i).setVisibility(View.INVISIBLE);
                    }

                }
                else {
                    editButton.setText("Done");
                    for (int i=0; i<6; i++) {
                        deletingButtons.get(i).setVisibility(View.VISIBLE);
                        editingButtons.get(i).setVisibility(View.VISIBLE);
                    }
                }
                isEditing = !isEditing;
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

        textViews.add((TextView) findViewById(R.id.textView1));
        textViews.add((TextView) findViewById(R.id.textView2));
        textViews.add((TextView) findViewById(R.id.textView3));
        textViews.add((TextView) findViewById(R.id.textView4));
        textViews.add((TextView) findViewById(R.id.textView5));
        textViews.add((TextView) findViewById(R.id.textView6));

        for (int i=0; i<6; i++) {
            deletingButtons.get(i).setVisibility(View.INVISIBLE);
            editingButtons.get(i).setVisibility(View.INVISIBLE);

            deletingButtons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            editingButtons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(loliList.this, editTitle.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("index", editingButtons.indexOf(v));
                    bundle.putString("text", textViews.get(editingButtons.indexOf(v)).getText().toString());
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 0);
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            textViews.get(data.getExtras().getInt("index")).setText(data.getExtras().getString("text"));
        }
    }
}
