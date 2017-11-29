package edu.tjhsst.myfirebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference mRef;
    private TextView mText;
    private EditText mEdit;
    private Button mButton;
    private String message;
    private String message2;
    private String current;
    private ValueCounter temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);


        mText = (TextView)findViewById(R.id.text0);
        mEdit = (EditText)findViewById(R.id.text1);
        mButton = (Button)findViewById(R.id.button1);
        message = "message";
        message2 = "message2";
        database = FirebaseDatabase.getInstance();
        mRef = database.getReference(message);
        mRef.setValue(new ValueCounter("message"));
        mRef = database.getReference(message2);
        mRef.setValue(new ValueCounter("message2"));
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                int a = (int)(Math.random() * 2);
                if(a==0)
                    {
                        current = message;

                    }
                else
                    {
                        current = message2;
                    }
                mRef = database.getReference(current);

                mRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        temp = (dataSnapshot.getValue(ValueCounter.class));
                        temp.increment();
                        mRef.setValue(temp);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });
            }
        });
    }
}
