package com.example.assignment2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd;
    EditText textNote;
    LinearLayout viewNotes;
    Context myActivity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myActivity = (Context) this;
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        textNote = (EditText) findViewById(R.id.textNote);
        viewNotes = (LinearLayout) findViewById(R.id.viewNotes);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize current note and saved notes
                final LinearLayout note = new LinearLayout(myActivity);
                EditText newNote = new EditText(myActivity);
                note.setOrientation(LinearLayout.VERTICAL);

                // Set layout for saved notes
                newNote.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                newNote.setGravity(Gravity.CENTER);
                newNote.setText(textNote.getText());
                note.addView(newNote);
                viewNotes.addView(note);

                // Initialize and define delete button
                Button buttonDelete = new Button(myActivity);
                buttonDelete.setText("Delete");
                note.addView(buttonDelete);

                buttonDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewNotes.removeView(note);
                    }
                });

                // Set current text back to empty String
                textNote.setText("");
            }
        });
    }
}
