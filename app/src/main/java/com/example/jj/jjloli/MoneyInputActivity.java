package com.example.jj.jjloli;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MoneyInputActivity extends AppCompatActivity {
    private TextView textView1;
    private View.OnClickListener onCBtnClick;
    private long Cnt = 0;
    private ChargeTable chargeTable;
    private Calendar myCalendar;
    private DatePickerDialog.OnDateSetListener date;
    private TextView dateEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v_charge_input);
        textView1 = (TextView) findViewById(R.id.money);
        onCBtnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                int num = Integer.valueOf(b.getText().toString());
                Cnt = Cnt * 10 + num;

                textView1.setText(getMoneyString(Cnt));
            }
        };

        calculateBtnBinding();

        chargeTable = new ChargeTable(getApplicationContext());

        Calendar c = Calendar.getInstance();
        dateEdit = (TextView) findViewById(R.id.datepicker);
        dateEdit.setKeyListener(null);
        dateEdit.setText(String.format("%d/%d/%d", c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE)));

        myCalendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dateEdit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel() {

        String myFormat = "yyyy/MM/dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateEdit.setText(sdf.format(myCalendar.getTime()));
    }

    private void calculateBtnBinding() {
        for (int i = 0; i <= 9; i++) {
            int ii = getResources().getIdentifier("button" + String.valueOf(i), "id", getPackageName());
            Button fab = (Button) findViewById(ii);
            if (fab != null)
                fab.setOnClickListener(onCBtnClick);
        }

        Button CB = (Button) findViewById(R.id.buttonC);
        CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cnt = 0;
                textView1.setText(getMoneyString(Cnt));
            }
        });

        Button BB = (Button) findViewById(R.id.buttonB);
        BB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cnt /= 10;

                textView1.setText(getMoneyString(Cnt));
//                OnDoneClick();
            }
        });
    }

    public String getMoneyString(long s) {
        String ret = "";
        long n = s;
        while (n > 1000) {
            ret = "," + String.valueOf(n % 1000) + ret;

            n /= 1000;
        }

        ret = String.valueOf(n) + ret;

        return ret;
    }

    public void OnDoneClick() {
        String dateString = dateEdit.getText().toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        TextView commentEdit = (TextView) findViewById(R.id.detail);

        try {
            Date date = dateFormat.parse(dateString);

            long unixTime = (long) date.getTime() / 1000;

            ChargeSchema item = new ChargeSchema(0, unixTime, commentEdit.getText().toString(), "", 0, Cnt);

            chargeTable.insert(item);
        } catch (Exception ex) {
        }
    }
}
