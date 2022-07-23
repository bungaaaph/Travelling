package com.example.travelling;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Data extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    com.example.travelling.Adapter adapter;
    ArrayList<com.example.travelling.Db> list;
    Button back;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        recyclerView = findViewById(R.id.data);
        databaseReference = FirebaseDatabase.getInstance().getReference("Customer");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        back = findViewById(R.id.btn_back);
        mAuth = FirebaseAuth.getInstance();

        list = new ArrayList<>();
        adapter = new com.example.travelling.Adapter(this,list);
        recyclerView.setAdapter(adapter);

        back.setOnClickListener(view -> {
            mAuth.signOut();
            Toast.makeText(Data.this, "Logout successfully",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Data.this, MainActivity.class));
        });


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    com.example.travelling.Db db = dataSnapshot.getValue(com.example.travelling.Db.class);
                    list.add(db);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}