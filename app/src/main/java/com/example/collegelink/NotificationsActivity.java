package com.example.collegelink;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NotificationsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    AdapterNotifications adapterNotifications;
    ArrayList<ModelNotifications> list;

    Set<String> pid = new HashSet<String>();
    String userid;
    ArrayList<String> selection = new ArrayList<String>();
    ArrayList<String> postdetails = new ArrayList<String>();

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Notifications");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#D91C5C"));
        actionBar.setBackgroundDrawable(colorDrawable);

        recyclerView = findViewById(R.id.recyclenotif);

        database = FirebaseDatabase.getInstance().getReference("Notification");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapterNotifications = new AdapterNotifications(this, list);
        recyclerView.setAdapter(adapterNotifications);

        userid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        FirebaseDatabase fdata = FirebaseDatabase.getInstance();

        DatabaseReference refposts = fdata.getReference("Users").child(userid).child("Skills");
        refposts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                selection = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String data = snapshot.getValue(String.class);
                    selection.add(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference skillsnode = fdata.getReference("Skills");
        skillsnode.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<String, Object> array = new HashMap<String, Object>();
                array = (HashMap<String, Object>) dataSnapshot.getValue();
                for (int i = 0; i < selection.size(); i++) {
                    for (Map.Entry<String, Object> entry : array.entrySet()) {
                        if(entry.getKey().equals(selection.get(i))){
                            HashMap<Object, Object> array2 = (HashMap<Object, Object>) entry.getValue();
                            String [] postid = array2.values().toArray(new String[0]);
                            for(int j=0;j<postid.length;j++){
                                pid.add(postid[j]);
                            }
                        }
                    }
                }
                for(String items : pid){
                    postdetails.add(items);
                }
                DatabaseReference notnode = FirebaseDatabase.getInstance().getReference("Notification");
                for(int i=0;i<postdetails.size();i++){
                    notnode.child(userid).child(postdetails.get(i)).setValue(postdetails.get(i));
                }


                DatabaseReference publishername = fdata.getReference("Posts");
                publishername.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        HashMap<String, Object> array = new HashMap<String, Object>();
                        array = (HashMap<String, Object>) snapshot.getValue();
                        for(int i=0;i< postdetails.size();i++){
                            for (Map.Entry<String, Object> entry : array.entrySet()){
                                if(entry.getKey().equals(postdetails.get(i))){
                                    HashMap<Object, Object> array2 = (HashMap<Object, Object>) entry.getValue();
                                    DatabaseReference noti = FirebaseDatabase.getInstance().getReference("Notification");
                                    noti.child(userid).child(postdetails.get(i)).child("uname").setValue(array2.get("uname"));
                                    noti.child(userid).child(postdetails.get(i)).child("description").setValue(array2.get("uname")+" added a post which might interest you.");
                                }
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*DatabaseReference refposts = fdata.getReference("Users").child(userid).child("Skills");
        refposts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                selection = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String data = snapshot.getValue(String.class);
                    selection.add(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference skillsnode = fdata.getReference("Skills");
        skillsnode.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<String, Object> array = new HashMap<String, Object>();
                array = (HashMap<String, Object>) dataSnapshot.getValue();
                for (int i = 0; i < selection.size(); i++) {
                    for (Map.Entry<String, Object> entry : array.entrySet()) {
                        if(entry.getKey().equals(selection.get(i))){
                            HashMap<Object, Object> array2 = (HashMap<Object, Object>) entry.getValue();
                            String [] postid = array2.values().toArray(new String[0]);
                            for(int j=0;j<postid.length;j++){
                                pid.add(postid[j]);
                            }
                        }
                    }
                }
                for(String items : pid){
                    postdetails.add(items);
                }
                DatabaseReference notnode = FirebaseDatabase.getInstance().getReference("Notification");
                for(int i=0;i<postdetails.size();i++){
                    notnode.child(userid).child(postdetails.get(i)).setValue(postdetails.get(i));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        /*DatabaseReference post = fdata.getReference("Posts");
        post.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                HashMap<String, Object> array = new HashMap<String, Object>();
                array = (HashMap<String, Object>) snapshot.getValue();
                for (int i = 0; i < postdetails.size(); i++) {
                    for (Map.Entry<String, Object> entry : array.entrySet()) {
                        if(entry.getKey().equals(postdetails.get(i))){
                            System.out.println(entry.getKey());
                            System.out.println(entry.getValue());
                        }
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        /*DatabaseReference post = fdata.getReference("Posts");
        post.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HashMap<String, Object> array = new HashMap<String, Object>();
                array = (HashMap<String, Object>) snapshot.getValue();
                for (int i = 0; i < postdetails.size(); i++) {
                    for (Map.Entry<String, Object> entry : array.entrySet()) {
                        if(entry.getKey().equals(postdetails.get(i))){
                            HashMap<String, Object> array2 = new HashMap<String, Object>();
                            array2 = (HashMap<String, Object>) entry.getValue();
                            for (Map.Entry<String, Object> entry2 : array2.entrySet()){
                                if(entry2.getKey().equals("uname")){
                                    DatabaseReference notnode = FirebaseDatabase.getInstance().getReference("Notification");
                                    notnode.child(userid).child("uname").setValue(entry2.getValue());
                                }
                            }

                        }
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/



        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {

                    ModelNotifications modelNotifications = dataSnapshot.getValue(ModelNotifications.class);
                    list.add(modelNotifications);

                }

                adapterNotifications.notifyDataSetChanged();

            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}