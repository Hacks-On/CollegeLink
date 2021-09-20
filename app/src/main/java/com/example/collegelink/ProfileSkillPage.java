package com.example.collegelink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.ArrayList;

public class ProfileSkillPage extends AppCompatActivity {
    CheckBox mCP, mJavaP,mPythonP, mPHPP, mRP, mSwiftP, mGoLangP, mCHashP, mJavaScriptP,
            mKotlinP, mPearlP, mRubyP, mAIP, mMLP, mAndroidStudioP,mIOTP, mWebDevP, mReactJSP,
            mNodeJSP, mFlutterP, mFirebaseP, mDBMSP, mDataScienceP, mUIUXP;
    Button mUpdateP;
    FirebaseAuth fAuth;
    FirebaseDatabase fData;
    String userid;
    ArrayList<String> selection = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_skill_page);

        mCP = findViewById(R.id.CP);
        mJavaP = findViewById(R.id.JavaP);
        mPythonP = findViewById(R.id.PythonP);
        mPHPP = findViewById(R.id.PHPP);
        mRP = findViewById(R.id.RP);
        mSwiftP = findViewById(R.id.SwiftP);
        mGoLangP = findViewById(R.id.GoLangP);
        mCHashP = findViewById(R.id.CHashP);
        mJavaScriptP = findViewById(R.id.JavaSciptP);
        mKotlinP = findViewById(R.id.KotlinP);
        mPearlP = findViewById(R.id.PearlP);
        mRubyP = findViewById(R.id.RubyP);
        mAIP = findViewById(R.id.AIP);
        mMLP = findViewById(R.id.MLP);
        mAndroidStudioP = findViewById(R.id.AndroidStudioP);
        mIOTP = findViewById(R.id.IOTP);
        mWebDevP = findViewById(R.id.WebDevP);
        mReactJSP = findViewById(R.id.ReactJSP);
        mNodeJSP = findViewById(R.id.NodeJSP);
        mFlutterP = findViewById(R.id.FlutterP);
        mFirebaseP = findViewById(R.id.FirebaseP);
        mDBMSP = findViewById(R.id.DBMSP);
        mDataScienceP = findViewById(R.id.DataScienceP);
        mUIUXP = findViewById(R.id.UIUXP);

        mUpdateP = findViewById(R.id.UpdateP);

        fAuth = FirebaseAuth.getInstance();
        fData = FirebaseDatabase.getInstance();
        userid = fAuth.getCurrentUser().getUid();

        DatabaseReference ref = fData.getReference("Users").child(userid).child("Skills");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                selection = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String data = snapshot.getValue(String.class);
                    selection.add(data);

                    if(data.equals("C/C++"))
                        mCP.setChecked(true);
                    else if(data.equals("Python"))
                        mPythonP.setChecked(true);
                    else if(data.equals("Java"))
                        mJavaP.setChecked(true);
                    else if(data.equals("PHP"))
                        mPHPP.setChecked(true);
                    else if(data.equals("R"))
                        mRP.setChecked(true);
                    else if(data.equals("Swift"))
                        mSwiftP.setChecked(true);
                    else if(data.equals("GoLang"))
                        mGoLangP.setChecked(true);
                    else if(data.equals("C#"))
                        mCHashP.setChecked(true);
                    else if(data.equals("JavaScript"))
                        mJavaScriptP.setChecked(true);
                    else if(data.equals("Kotlin"))
                        mKotlinP.setChecked(true);
                    else if(data.equals("Pearl"))
                        mPearlP.setChecked(true);
                    else if(data.equals("Ruby"))
                        mRubyP.setChecked(true);
                    else if(data.equals("AI"))
                        mAIP.setChecked(true);
                    else if(data.equals("ML"))
                        mMLP.setChecked(true);
                    else if(data.equals("Android Studio"))
                        mAndroidStudioP.setChecked(true);
                    else if(data.equals("IOT"))
                        mIOTP.setChecked(true);
                    else if(data.equals("WebDev"))
                        mWebDevP.setChecked(true);
                    else if(data.equals("ReactJS"))
                        mReactJSP.setChecked(true);
                    else if(data.equals("NodeJS"))
                        mNodeJSP.setChecked(true);
                    else if(data.equals("Flutter"))
                        mFlutterP.setChecked(true);
                    else if(data.equals("Firebase"))
                        mFirebaseP.setChecked(true);
                    else if(data.equals("DBMS"))
                        mDBMSP.setChecked(true);
                    else if(data.equals("Data Science"))
                        mDataScienceP.setChecked(true);
                    else if(data.equals("UI/UX"))
                        mUIUXP.setChecked(true);
                }
                System.out.println(selection.size());
                System.out.println(selection);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mUpdateP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference=fData.getReference("Users").child(userid).child("Skills");
                databaseReference.setValue(selection);
                Toast.makeText(ProfileSkillPage.this, "Updated skills!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void selectItemProfile(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.CP:
                if(checked)
                    selection.add("C/C++");
                else
                    selection.remove("C/C++");
                break;
            case R.id.JavaP:
                if(checked)
                    selection.add("Java");
                else
                    selection.remove("Java");
                break;
            case R.id.PythonP:
                if(checked)
                    selection.add("Python");
                else
                    selection.remove("Python");
                break;
            case R.id.PHPP:
                if(checked)
                    selection.add("PHP");
                else
                    selection.remove("PHP");
                break;
            case R.id.RP:
                if(checked)
                    selection.add("R");
                else
                    selection.remove("R");
                break;
            case R.id.SwiftP:
                if(checked)
                    selection.add("Swift");
                else
                    selection.remove("Swift");
                break;
            case R.id.GoLangP:
                if(checked)
                    selection.add("GoLang");
                else
                    selection.remove("GoLang");
                break;
            case R.id.CHashP:
                if(checked)
                    selection.add("C#");
                else
                    selection.remove("C#");
                break;
            case R.id.JavaSciptP:
                if(checked)
                    selection.add("JavaScript");
                else
                    selection.remove("JavaScript");
                break;
            case R.id.KotlinP:
                if(checked)
                    selection.add("Kotlin");
                else
                    selection.remove("Kotlin");
                break;
            case R.id.PearlP:
                if(checked)
                    selection.add("Pearl");
                else
                    selection.remove("Pearl");
                break;
            case R.id.RubyP:
                if(checked)
                    selection.add("Ruby");
                else
                    selection.remove("Ruby");
                break;
            case R.id.AIP:
                if(checked)
                    selection.add("AI");
                else
                    selection.remove("AI");
                break;
            case R.id.MLP:
                if(checked)
                    selection.add("ML");
                else
                    selection.remove("ML");
                break;
            case R.id.AndroidStudioP:
                if(checked)
                    selection.add("Android Studio");
                else
                    selection.remove("Android Studio");
                break;
            case R.id.IOTP:
                if(checked)
                    selection.add("IOT");
                else
                    selection.remove("IOT");
                break;
            case R.id.WebDevP:
                if(checked)
                    selection.add("WebDev");
                else
                    selection.remove("WebDev");
                break;
            case R.id.ReactJSP:
                if(checked)
                    selection.add("ReactJS");
                else
                    selection.remove("ReactJS");
                break;
            case R.id.NodeJSP:
                if(checked)
                    selection.add("NodeJS");
                else
                    selection.remove("NodeJS");
                break;
            case R.id.FlutterP:
                if(checked)
                    selection.add("Flutter");
                else
                    selection.remove("Flutter");
                break;
            case R.id.FirebaseP:
                if(checked)
                    selection.add("Firebase");
                else
                    selection.remove("Firebase");
                break;
            case R.id.DBMSP:
                if(checked)
                    selection.add("DBMS");
                else
                    selection.remove("DBMS");
                break;
            case R.id.DataScienceP:
                if(checked)
                    selection.add("Data Science");
                else
                    selection.remove("Data Science");
                break;
            case R.id.UIUXP:
                if(checked)
                    selection.add("UI/UX");
                else
                    selection.remove("UI/UX");
                break;
        }
    }
}