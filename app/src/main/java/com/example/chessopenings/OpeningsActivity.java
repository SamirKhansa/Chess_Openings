package com.example.chessopenings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class OpeningsActivity extends AppCompatActivity {
    private RecyclerView contactsRecView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openings);
        contactsRecView = findViewById(R.id.ContactsRecyleView2);
        Button Btn=findViewById(R.id.BackButton);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ArrayList<Contacts> contacts=new ArrayList<>();

        String[] Names=getIntent().getStringArrayExtra("Variations");
        String Header=getIntent().getStringExtra("name").toString();
        String Position=getIntent().getStringExtra("Position").toString();
        String Description=getIntent().getStringExtra("Description").toString();
        int ID = getIntent().getIntExtra("ID", 0);
        TextView header=findViewById(R.id.headerTextView);
        TextView Desc=findViewById(R.id.descriptionTextView);
        header.setText(Header);
        Desc.setText(Description);
        if(ID==1){
            contacts.add(new Contacts(Names[0],"e4 c5, Nf3","",Names,9,"img_9"));
            contacts.add(new Contacts(Names[1],"e4 c5, Nc3","",Names,9,"img_10"));
            contacts.add(new Contacts(Names[2],"e4 c5, c3","",Names,9,"img_11"));
            contacts.add(new Contacts(Names[3],"e4 c5, d4","",Names,9,"img_12"));
            contacts.add(new Contacts(Names[4],"e4 c5, f4","",Names,9,"img_13"));

        }

        if(ID==2) {
            contacts.add(new Contacts(Names[0],"e4 e5,Nf3 Nc6,Bb5, a6","",Names,14,"img_14"));
            contacts.add(new Contacts(Names[1],"e4 e5,Nf3 Nc6,Bb5, a6\n Ba4","",Names,14,"img_15"));
            contacts.add(new Contacts(Names[2],"e4 e5,Nf3 Nc6,Bb5, Nf6","",Names,14,"img_16"));
            contacts.add(new Contacts(Names[3],"e4 e5,Nf3 Nc6,Bb5, f5","",Names,14,"img_17"));
            contacts.add(new Contacts(Names[4],"e4 e5,Nf3 Nc6,Bb5, Nd4","",Names,14,"img_18"));
        }
        if(ID==3) {
            contacts.add(new Contacts(Names[0],"e4e5,Nf3 Nc6,Bc4 Bc5,c3","",Names,19,"img_19"));
            contacts.add(new Contacts(Names[1],"e4 e5,Nf3 Nc6,Bc4 Nf6","",Names,19,"img_20"));
            contacts.add(new Contacts(Names[2],"e4 e5,Nf3 Nc6,Bc4 b4","",Names,19,"img_21"));
            contacts.add(new Contacts(Names[3],"e4 e5,Nf3 Nc6,Bc4 Bc5\nc3 Nf6,d3","",Names,19,"img_22"));
            contacts.add(new Contacts(Names[4],"e4 e5,Nf3 Nc6,d4 exd4, Bc4","",Names,19,"img_23"));
        }
        if(ID==4) {
            contacts.add(new Contacts(Names[0],"e4e5,Nf3 Nc6,Bc4 Bc5,c3","",Names,19,"img_19"));
            contacts.add(new Contacts(Names[1],"e4 e5,Nf3 Nc6,Bc4 Nf6","",Names,19,"img_20"));
            contacts.add(new Contacts(Names[2],"e4 e5,Nf3 Nc6,Bc4 b4","",Names,19,"img_21"));
            contacts.add(new Contacts(Names[3],"e4 e5,Nf3 Nc6,Bc4 Bc5\nc3 Nf6,d3","",Names,19,"img_22"));
            contacts.add(new Contacts(Names[4],"e4 e5,Nf3 Nc6,d4 exd4, Bc4","",Names,19,"img_23"));
        }
        if(ID==5) {
            contacts.add(new Contacts(Names[0],"e4e5,Nf3 Nc6,Bc4 Bc5,c3","",Names,19,"img_19"));
            contacts.add(new Contacts(Names[1],"e4 e5,Nf3 Nc6,Bc4 Nf6","",Names,19,"img_20"));
            contacts.add(new Contacts(Names[2],"e4 e5,Nf3 Nc6,Bc4 b4","",Names,19,"img_21"));
            contacts.add(new Contacts(Names[3],"e4 e5,Nf3 Nc6,Bc4 Bc5\nc3 Nf6,d3","",Names,19,"img_22"));
            contacts.add(new Contacts(Names[4],"e4 e5,Nf3 Nc6,d4 exd4, Bc4","",Names,19,"img_23"));
        }

        ContactRecViewAdapter adapter=new ContactRecViewAdapter(this);
        adapter.setContacts(contacts);
        adapter.setFragmentManager(getSupportFragmentManager());


        contactsRecView.setAdapter(adapter);
        contactsRecView.setLayoutManager(new LinearLayoutManager(this));



    }
    public void GoingBackToTheOpeningsPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}