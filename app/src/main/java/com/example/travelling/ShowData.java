package com.example.travelling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShowData extends AppCompatActivity {

    EditText up_ln,up_fn,up_email,up_dateT,up_birthday,up_address,up_phone,up_city,up_state;

    String fn,ln,em,dt,bi,ad,ph,ci,st;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        reference = FirebaseDatabase.getInstance().getReference("Customer");

        up_ln       = findViewById(R.id.UP_LN);
        up_fn       = findViewById(R.id.UP_FN);
        up_email    = findViewById(R.id.UP_Email);
        up_dateT    = findViewById(R.id.UP_DateT);
        up_birthday = findViewById(R.id.UP_Birthday);
        up_address  = findViewById(R.id.UP_Address);
        up_phone    = findViewById(R.id.UP_Phone);
        up_city     = findViewById(R.id.UP_City);
        up_state    = findViewById(R.id.UP_State);

        showAllUserData();
    }


    private void showAllUserData(){
        Intent intent = getIntent();
        fn = intent.getStringExtra("firstname");
        ln = intent.getStringExtra("lastname");
        em = intent.getStringExtra("email");
        dt = intent.getStringExtra("dateTravel");
        em = intent.getStringExtra("email");
        bi = intent.getStringExtra("date");
        ad = intent.getStringExtra("address");
        ph = intent.getStringExtra("phone");
        ci = intent.getStringExtra("city");
        st = intent.getStringExtra("state");

        up_fn.setText(fn);
        up_ln.setText(ln);
        up_email.setText(em);
        up_dateT.setText(dt);
        up_birthday.setText(bi);
        up_address.setText(ad);
        up_phone.setText(ph);
        up_city.setText(ci);
        up_state.setText(st);

    }

    public void update(View view){
        if(isFnChanged() || isLNChanged()){
            Toast.makeText(this,"Data has been update",Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this,"Data is same can not be update",Toast.LENGTH_SHORT).show();
    }

    private boolean isFnChanged(){
        if (!fn.equals(up_fn.getText().toString())) {
            reference.child(fn).child("firstname").setValue(up_fn.getText().toString());
            return true;
        }
        else
            return false;
    }

    private boolean isLNChanged(){
        if (!ln.equals(up_ln.getText().toString())) {
            reference.child(ln).child("lastname").setValue(up_ln.getText().toString());
            return true;
        }
        else
            return false;
    }

}