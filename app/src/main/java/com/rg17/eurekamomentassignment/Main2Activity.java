package com.rg17.eurekamomentassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.data.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {

    private EditText ename,edob,eemail,ephone;
    private Button btn_submit;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        databaseReference = FirebaseDatabase.getInstance().getReference("userdetails");


        ename = (EditText)findViewById(R.id.name);
        edob = (EditText)findViewById(R.id.dob);
        eemail = (EditText)findViewById(R.id.email);
        ephone = (EditText)findViewById(R.id.phone);
        btn_submit = (Button)findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    public void addUser(){
        String username = ename.getText().toString();
        String userdob = edob.getText().toString();
        String useremail = eemail.getText().toString();
        String userphone = ephone.getText().toString();

        if(username.isEmpty() || userdob.isEmpty() || useremail.isEmpty() || userphone.isEmpty())
        {
            Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_LONG).show();
        }
        else
        {
            String id = databaseReference.push().getKey();

            UserDetails userDetails = new UserDetails(id,username,userdob,useremail,userphone);
            databaseReference.child(id).setValue(userDetails);
            ename.setText("");
            edob.setText("");
            eemail.setText("");
            ephone.setText("");

            Toast.makeText(this,"Details Submitted",Toast.LENGTH_LONG).show();
        }

    }
}
