package com.example.collegelink;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Array;
import java.util.ArrayList;

public class SkillPage extends AppCompatActivity {
    CheckBox mC, mJava,mPython, mPHP, mR, mSwift, mGoLang, mCHash, mJavaScript,
            mKotlin, mPearl, mRuby, mAI, mML, mAndroidStudio,mIOT, mWebDev, mReactJS,
            mNodeJS, mFlutter, mFirebase, mDBMS, mDataScience, mUIUX;
    Button mUpdate;
    FirebaseAuth fAuth;
    FirebaseDatabase fData;
    String userid;
    ArrayList<String> selection = new ArrayList<String>();
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_page);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Add your skills");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#D91C5C"));
        actionBar.setBackgroundDrawable(colorDrawable);

        mC = findViewById(R.id.C);
        mJava = findViewById(R.id.Java);
        mPython = findViewById(R.id.Python);
        mPHP = findViewById(R.id.PHP);
        mR = findViewById(R.id.R);
        mSwift = findViewById(R.id.Swift);
        mGoLang = findViewById(R.id.GoLang);
        mCHash = findViewById(R.id.Unity);
        mJavaScript = findViewById(R.id.JavaScript);
        mKotlin = findViewById(R.id.Kotlin);
        mPearl = findViewById(R.id.Pearl);
        mRuby = findViewById(R.id.Ruby);
        mAI = findViewById(R.id.AI);
        mML = findViewById(R.id.ML);
        mAndroidStudio = findViewById(R.id.AndroidStudio);
        mIOT = findViewById(R.id.IOT);
        mWebDev = findViewById(R.id.WebDev);
        mReactJS = findViewById(R.id.ReactJS);
        mNodeJS = findViewById(R.id.NodeJS);
        mFlutter = findViewById(R.id.Flutter);
        mFirebase = findViewById(R.id.Firebase);
        mDBMS = findViewById(R.id.DBMS);
        mDataScience = findViewById(R.id.DataScience);
        mUIUX = findViewById(R.id.UIUX);

        mUpdate = findViewById(R.id.Update);


        fAuth = FirebaseAuth.getInstance();
        fData = FirebaseDatabase.getInstance();
        userid = fAuth.getCurrentUser().getUid();


        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference databaseReference = fData.getReference("Users");
                databaseReference.child(userid).child("Skills").setValue(selection);
                DatabaseReference databaseReference1 = fData.getReference("Skills");
                for(int i=0;i<selection.size();i++){
                    databaseReference1.child(selection.get(i)).child("Users").child(userid).setValue(userid);
                }
                Toast.makeText(SkillPage.this, "Added skills!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
    }
    public void selectItem(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.C:
                if (checked)
                    selection.add("C++");
                else
                    selection.remove("C++");
                break;
            case R.id.Java:
                if (checked)
                    selection.add("Java");
                else
                    selection.remove("Java");
                break;
            case R.id.Python:
                if (checked)
                    selection.add("Python");
                else
                    selection.remove("Python");
                break;
            case R.id.PHP:
                if (checked)
                    selection.add("PHP");
                else
                    selection.remove("PHP");
                break;
            case R.id.R:
                if (checked)
                    selection.add("R");
                else
                    selection.remove("R");
                break;
            case R.id.Swift:
                if (checked)
                    selection.add("Swift");
                else
                    selection.remove("Swift");
                break;
            case R.id.GoLang:
                if (checked)
                    selection.add("GoLang");
                else
                    selection.remove("GoLang");
                break;
            case R.id.Unity:
                if (checked)
                    selection.add("Unity");
                else
                    selection.remove("Unity");
                break;
            case R.id.JavaScript:
                if (checked)
                    selection.add("JavaScript");
                else
                    selection.remove("JavaScript");
                break;
            case R.id.Kotlin:
                if (checked)
                    selection.add("Kotlin");
                else
                    selection.remove("Kotlin");
                break;
            case R.id.Pearl:
                if (checked)
                    selection.add("Pearl");
                else
                    selection.remove("Pearl");
                break;
            case R.id.Ruby:
                if (checked)
                    selection.add("Ruby");
                else
                    selection.remove("Ruby");
                break;
            case R.id.AI:
                if (checked)
                    selection.add("AI");
                else
                    selection.remove("AI");
                break;
            case R.id.ML:
                if (checked)
                    selection.add("ML");
                else
                    selection.remove("ML");
                break;
            case R.id.AndroidStudio:
                if (checked)
                    selection.add("Android Studio");
                else
                    selection.remove("Android Studio");
                break;
            case R.id.IOT:
                if (checked)
                    selection.add("IOT");
                else
                    selection.remove("IOT");
                break;
            case R.id.WebDev:
                if (checked)
                    selection.add("WebDev");
                else
                    selection.remove("WebDev");
                break;
            case R.id.ReactJS:
                if (checked)
                    selection.add("ReactJS");
                else
                    selection.remove("ReactJS");
                break;
            case R.id.NodeJS:
                if (checked)
                    selection.add("NodeJS");
                else
                    selection.remove("NodeJS");
                break;
            case R.id.Flutter:
                if (checked)
                    selection.add("Flutter");
                else
                    selection.remove("Flutter");
                break;
            case R.id.Firebase:
                if (checked)
                    selection.add("Firebase");
                else
                    selection.remove("Firebase");
                break;
            case R.id.DBMS:
                if (checked)
                    selection.add("DBMS");
                else
                    selection.remove("DBMS");
                break;
            case R.id.DataScience:
                if (checked)
                    selection.add("Data Science");
                else
                    selection.remove("Data Science");
                break;
            case R.id.UIUX:
                if (checked)
                    selection.add("UI/UX");
                else
                    selection.remove("UI/UX");
                break;
        }
    }
}