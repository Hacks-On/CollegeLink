package com.example.collegelink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile_skill_page);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Update your skills");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#D91C5C"));
        actionBar.setBackgroundDrawable(colorDrawable);

        mCP = findViewById(R.id.CP);
        mJavaP = findViewById(R.id.JavaP);
        mPythonP = findViewById(R.id.PythonP);
        mPHPP = findViewById(R.id.PHPP);
        mRP = findViewById(R.id.RP);
        mSwiftP = findViewById(R.id.SwiftP);
        mGoLangP = findViewById(R.id.GoLangP);
        mCHashP = findViewById(R.id.UnityP);
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

                    if(data.equals("C++"))
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
        //DatabaseReference ref2 =fData.getReference("Skills");

        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.CP:
                if(checked) {
                    selection.add("C++");
                    //ref2.child("C++").child(userid).setValue(userid);
                }
                else {
                    selection.remove("C++");
                    //ref2.child("C++").child(userid).removeValue();
                }
                break;
            case R.id.JavaP:
                if(checked) {
                    selection.add("Java");
                    //ref2.child("Java").child(userid).setValue(userid);
                }
                else {
                    selection.remove("Java");
                    //ref2.child("Java").child(userid).removeValue();
                }
                break;
            case R.id.PythonP:
                if(checked) {
                    selection.add("Python");
                    //ref2.child("Python").child(userid).setValue(userid);
                }
                else {
                    selection.remove("Python");
                    //ref2.child("Python").child(userid).removeValue();
                }
                break;
            case R.id.PHPP:
                if(checked) {
                    selection.add("PHP");
                    //ref2.child("PHP").child(userid).setValue(userid);
                }
                else {
                    selection.remove("PHP");
                    //ref2.child("PHP").child(userid).removeValue();
                }
                break;
            case R.id.RP:
                if(checked) {
                    selection.add("R");
                    //ref2.child("R").child(userid).setValue(userid);
                }
                else {
                    selection.remove("R");
                    //ref2.child("R").child(userid).removeValue();
                }
                break;
            case R.id.SwiftP:
                if(checked) {
                    selection.add("Swift");
                    //ref2.child("Swift").child(userid).setValue(userid);
                }
                else {
                    selection.remove("Swift");
                    //ref2.child("Swift").child(userid).removeValue();
                }
                break;
            case R.id.GoLangP:
                if(checked) {
                    selection.add("GoLang");
                    //ref2.child("GoLang").child(userid).setValue(userid);
                }
                else {
                    selection.remove("GoLang");
                    //ref2.child("GoLang").child(userid).removeValue();
                }
                break;
            case R.id.UnityP:
                if(checked) {
                    selection.add("C#");
                    //ref2.child("C#").child(userid).setValue(userid);
                }
                else {
                    selection.remove("C#");
                    //ref2.child("C#").child(userid).removeValue();
                }
                break;
            case R.id.JavaSciptP:
                if(checked) {
                    selection.add("JavaScript");
                    //ref2.child("JavaScript").child(userid).setValue(userid);
                }
                else {
                    selection.remove("JavaScript");
                    //ref2.child("JavaScript").child(userid).removeValue();
                }
                break;
            case R.id.KotlinP:
                if(checked) {
                    selection.add("Kotlin");
                    //ref2.child("Kotlin").child(userid).setValue(userid);
                }
                else {
                    selection.remove("Kotlin");
                    //ref2.child("Kotlin").child(userid).removeValue();
                }
                break;
            case R.id.PearlP:
                if(checked) {
                    selection.add("Pearl");
                    //ref2.child("Pearl").child(userid).setValue(userid);
                }
                else {
                    selection.remove("Pearl");
                    //ref2.child("Pearl").child(userid).removeValue();
                }
                break;
            case R.id.RubyP:
                if(checked) {
                    selection.add("Ruby");
                    //ref2.child("Ruby").child(userid).setValue(userid);
                }
                else {
                    selection.remove("Ruby");
                    //ref2.child("Ruby").child(userid).removeValue();
                }
                break;
            case R.id.AIP:
                if(checked) {
                    selection.add("AI");
                    //ref2.child("AI").child(userid).setValue(userid);
                }
                else {
                    selection.remove("AI");
                    //ref2.child("AI").child(userid).removeValue();
                }
                break;
            case R.id.MLP:
                if(checked) {
                    selection.add("ML");
                    //ref2.child("ML").child(userid).setValue(userid);
                }
                else {
                    selection.remove("ML");
                    //ref2.child("ML").child(userid).removeValue();
                }
                break;
            case R.id.AndroidStudioP:
                if(checked) {
                    selection.add("Android Studio");
                    //ref2.child("Android Studio").child(userid).setValue(userid);
                }
                else {
                    selection.remove("Android Studio");
                    //ref2.child("Android Studio").child(userid).removeValue();
                }
                break;
            case R.id.IOTP:
                if(checked) {
                    selection.add("IOT");
                    //ref2.child("IOT").child(userid).setValue(userid);
                }
                else {
                    selection.remove("IOT");
                    //ref2.child("IOT").child(userid).removeValue();
                }
                break;
            case R.id.WebDevP:
                if(checked) {
                    selection.add("WebDev");
                    //ref2.child("WebDev").child(userid).setValue(userid);
                }
                else {
                    selection.remove("WebDev");
                    //ref2.child("Webdev").child(userid).removeValue();
                }
                break;
            case R.id.ReactJSP:
                if(checked) {
                    selection.add("ReactJS");
                    //ref2.child("ReactJS").child(userid).setValue(userid);
                }
                else {
                    selection.remove("ReactJS");
                    //ref2.child("ReactJS").child(userid).removeValue();
                }
                break;
            case R.id.NodeJSP:
                if(checked) {
                    selection.add("NodeJS");
                    //ref2.child("NodeJS").child(userid).setValue(userid);
                }
                else {
                    selection.remove("NodeJS");
                    //ref2.child("NodeJS").child(userid).removeValue();
                }
                break;
            case R.id.FlutterP:
                if(checked) {
                    selection.add("Flutter");
                    //ref2.child("Flutter").child(userid).setValue(userid);
                }
                else {
                    selection.remove("Flutter");
                    //ref2.child("Flutter").child(userid).removeValue();
                }
                break;
            case R.id.FirebaseP:
                if(checked) {
                    selection.add("Firebase");
                    //ref2.child("Firebase").child(userid).setValue(userid);
                }
                else {
                    selection.remove("Firebase");
                    //ref2.child("Firebase").child(userid).removeValue();
                }
                break;
            case R.id.DBMSP:
                if(checked) {
                    selection.add("DBMS");
                    //ref2.child("DBMS").child(userid).setValue(userid);
                }
                else {
                    selection.remove("DBMS");
                    //ref2.child("DBMS").child(userid).removeValue();
                }
                break;
            case R.id.DataScienceP:
                if(checked) {
                    selection.add("Data Science");
                    //ref2.child("Data Science").child(userid).setValue(userid);
                }
                else {
                    selection.remove("Data Science");
                    //ref2.child("Data Science").child(userid).removeValue();
                }
                break;
            case R.id.UIUXP:
                if(checked) {
                    selection.add("UI/UX");
                    //ref2.child("UI/UX").child(userid).setValue(userid);
                }
                else {
                    selection.remove("UI/UX");
                    //ref2.child("UI/UX").child(userid).removeValue();
                }
                break;
        }

    }
}