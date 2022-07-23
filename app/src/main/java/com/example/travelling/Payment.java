package com.example.travelling;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Payment extends AppCompatActivity {
    private EditText dateT ;
    private EditText birthday;
    private EditText ln;
    private EditText fn;
    private EditText email;
    private EditText address;
    private EditText phone;
    private EditText city;
    private EditText state;
    private Button BACK;

    DatePickerDialog.OnDateSetListener setListener;
    Button paybtn;

    FirebaseDatabase FD;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        dateT    = findViewById(R.id.DateT);
        birthday = findViewById(R.id.Birthday);
        fn       = findViewById(R.id.FN);
        ln       = findViewById(R.id.LN);
        email    = findViewById(R.id.Email);
        address  = findViewById(R.id.Address);
        phone    = findViewById(R.id.Phone);
        city     = findViewById(R.id.City);
        state    = findViewById(R.id.State);
        paybtn   = findViewById(R.id.Pay);
        BACK     = findViewById(R.id.back);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Payment.this, MainActivity.class));
            }
        });

        // save data in Firebase
        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FD = FirebaseDatabase.getInstance();
                reference = FD.getReference("Customer");

                String FN = fn.getText().toString();
                String LN = ln.getText().toString();
                String DT = dateT.getText().toString();
                String EM = email.getText().toString();
                String AD = address.getText().toString();
                String PH = phone.getText().toString();
                String CI = city.getText().toString();
                String ST = state.getText().toString();
                String BD = birthday.getText().toString();

                if(TextUtils.isEmpty(FN)){
                    fn.setError("FirstName cannot be empty");
                    fn.requestFocus();
                }
                else if(TextUtils.isEmpty(LN)){
                    ln.setError("LastName cannot be empty");
                    ln.requestFocus();
                }
                else if(TextUtils.isEmpty(DT)){
                    dateT.setError("Date Travelling cannot be empty");
                    dateT.requestFocus();
                }
                else if(TextUtils.isEmpty(EM)){
                    email.setError("Email cannot be empty");
                    email.requestFocus();
                }
                else if(TextUtils.isEmpty(AD)){
                    address.setError("Address cannot be empty");
                    address.requestFocus();
                }
                else if(TextUtils.isEmpty(PH)){
                    phone.setError("Phone cannot be empty");
                    phone.requestFocus();
                }
                else if(TextUtils.isEmpty(CI)){
                    city.setError("City cannot be empty");
                    city.requestFocus();
                }
                else if(TextUtils.isEmpty(ST)){
                    state.setError("State cannot be empty");
                    state.requestFocus();
                }
                else if(TextUtils.isEmpty(BD)){
                    birthday.setError("Birthday cannot be empty");
                    birthday.requestFocus();
                }
                else{
                    // get all the values
                    com.example.travelling.Db database = new com.example.travelling.Db(FN,LN,BD,DT,EM,AD,PH,CI,ST );

                    reference.child(FN).setValue(database);
                    startActivity(new Intent(Payment.this, com.example.travelling.Data.class));
                }
            }
        });

        dateT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Payment.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"-"+month+"-"+year;
                        dateT.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Payment.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"-"+month+"-"+year;
                        birthday.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }
}