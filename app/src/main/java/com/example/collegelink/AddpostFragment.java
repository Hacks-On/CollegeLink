package com.example.collegelink;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddpostFragment extends Fragment {

    public AddpostFragment() {
        // Required empty public constructor
    }

    FirebaseAuth firebaseAuth;
    EditText title, des;
    private static final int CAMERA_REQUEST = 100;
    private static final int STORAGE_REQUEST = 200;
    String cameraPermission[];
    String storagePermission[];
    ProgressDialog pd;
    ImageView image;
    CheckBox mC, mJava,mPython, mPHP, mR, mSwift, mGoLang, mCHash, mJavaScript,
            mKotlin, mPearl, mRuby, mAI, mML, mAndroidStudio,mIOT, mWebDev, mReactJS,
            mNodeJS, mFlutter, mFirebase, mDBMS, mDataScience, mUIUX;
    ArrayList<String> selection = new ArrayList<String>();
    ArrayList<Object> pid = new ArrayList<Object>();
    String edititle, editdes, editimage;
    private static final int IMAGEPICK_GALLERY_REQUEST = 300;
    private static final int IMAGE_PICKCAMERA_REQUEST = 400;

    Uri imageuri = null;
    String name, email, uid, dp, timestamp;
    DatabaseReference databaseReference;
    Button req;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        name = firebaseAuth.getCurrentUser().getDisplayName();

        View view = inflater.inflate(R.layout.fragment_addpost, container, false);



        title = view.findViewById(R.id.ptitle);
        des = view.findViewById(R.id.pdes);
        image = view.findViewById(R.id.imagep);
        req = view.findViewById(R.id.requirements);
        pd = new ProgressDialog(getContext());
        pd.setCanceledOnTouchOutside(false);
        mC = (CheckBox) view.findViewById(R.id.Cpost);
        mJava = (CheckBox) view.findViewById(R.id.Javapost);
        mPython = (CheckBox) view.findViewById(R.id.Pythonpost);
        mPHP = (CheckBox) view.findViewById(R.id.PHPpost);
        mR = (CheckBox) view.findViewById(R.id.Rpost);
        mSwift = (CheckBox) view.findViewById(R.id.Swiftpost);
        mGoLang = (CheckBox) view.findViewById(R.id.GoLangpost);
        mCHash = (CheckBox) view.findViewById(R.id.Unitypost);
        mJavaScript = (CheckBox) view.findViewById(R.id.JavaScriptpost);
        mKotlin = (CheckBox) view.findViewById(R.id.Kotlinpost);
        mPearl = (CheckBox) view.findViewById(R.id.Pearlpost);
        mRuby = (CheckBox) view.findViewById(R.id.Rubypost);
        mAI = (CheckBox) view.findViewById(R.id.AIpost);
        mML = (CheckBox) view.findViewById(R.id.MLpost);
        mAndroidStudio = (CheckBox) view.findViewById(R.id.AndroidStudiopost);
        mIOT = (CheckBox) view.findViewById(R.id.IOTpost);
        mWebDev = (CheckBox) view.findViewById(R.id.WebDevpost);
        mReactJS = (CheckBox) view.findViewById(R.id.ReactJSpost);
        mNodeJS = (CheckBox) view.findViewById(R.id.NodeJSpost);
        mFlutter = (CheckBox) view.findViewById(R.id.Flutterpost);
        mFirebase = (CheckBox) view.findViewById(R.id.Firebasepost);
        mDBMS = (CheckBox) view.findViewById(R.id.DBMSpost);
        mDataScience = (CheckBox) view.findViewById(R.id.DataSciencepost);
        mUIUX = (CheckBox) view.findViewById(R.id.UIUXpost);
        Intent intent = getActivity().getIntent();

        mC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("C++");
                else
                    selection.remove("C++");
            }
        });
        mJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("Java");
                else
                    selection.remove("Java");
            }
        });
        mPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("Python");
                else
                    selection.remove("Python");
            }
        });
        mPHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("PHP");
                else
                    selection.remove("PHP");
            }
        });
        mR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("R");
                else
                    selection.remove("R");
            }
        });
        mSwift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("Swift");
                else
                    selection.remove("Swift");
            }
        });
        mGoLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("GoLang");
                else
                    selection.remove("GoLang");
            }
        });
        mCHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("C#");
                else
                    selection.remove("C#");
            }
        });
        mJavaScript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("JavaScript");
                else
                    selection.remove("JavaScript");
            }
        });
        mKotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("Kotlin");
                else
                    selection.remove("Kotlin");
            }
        });
        mPearl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("Pearl");
                else
                    selection.remove("Pearl");
            }
        });

        mRuby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("Ruby");
                else
                    selection.remove("Ruby");
            }
        });

        mAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("AI");
                else
                    selection.remove("AI");
            }
        });

        mIOT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("IOT");
                else
                    selection.remove("IOT");
            }
        });

        mAndroidStudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("Android Studio");
                else
                    selection.remove("Android Studio");
            }
        });


        mML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("ML");
                else
                    selection.remove("ML");
            }
        });

        mWebDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("WebDev");
                else
                    selection.remove("WebDev");
            }
        });

        mReactJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("ReactJS");
                else
                    selection.remove("ReactJS");
            }
        });

        mNodeJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("NodeJS");
                else
                    selection.remove("NodeJS");
            }
        });

        mFlutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("Flutter");
                else
                    selection.remove("Flutter");
            }
        });

        mFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("Firebase");
                else
                    selection.remove("Firebase");
            }
        });

        mDBMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("DBMS");
                else
                    selection.remove("DBMS");
            }
        });

        mDataScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("Data Science");
                else
                    selection.remove("Data Science");
            }
        });

        mUIUX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked)
                    selection.add("UI/UX");
                else
                    selection.remove("UI/UX");
            }
        });




        // Retrieving the user data like name ,email and profile pic using query
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        Query query = databaseReference.orderByChild("uid").equalTo(uid);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    name = dataSnapshot1.child("name").getValue().toString();
                    email = "" + dataSnapshot1.child("email").getValue();
                    dp = "" + dataSnapshot1.child("image").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Initialising camera and storage permission
        cameraPermission = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        // After click on image we will be selecting an image
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagePicDialog();
            }
        });



        // Now we will upload out blog
        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titl = "" + title.getText().toString().trim();
                String description = "" + des.getText().toString().trim();

                if (TextUtils.isEmpty(titl)) {
                    title.setError("Title Cant be empty");
                    Toast.makeText(getContext(), "Title can't be left empty", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(description)) {
                    des.setError("Description Cant be empty");
                    Toast.makeText(getContext(), "Description can't be left empty", Toast.LENGTH_LONG).show();
                    return;
                }

                if (imageuri == null) {
                    Toast.makeText(getContext(), "Select an Image", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    uploadData(titl, description);
                }

            }
        });
        return view;
    }



    private void showImagePicDialog() {
        String options[] = {"Camera", "Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Pick Image From");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // check for the camera and storage permission if
                // not given the request for permission
                if (which == 0) {
                    if (!checkCameraPermission()) {
                        requestCameraPermission();
                    } else {
                        pickFromCamera();
                    }
                } else if (which == 1) {
                    if (!checkStoragePermission()) {
                        requestStoragePermission();
                    } else {
                        pickFromGallery();
                    }
                }
            }
        });
        builder.create().show();
    }

    // check for storage permission
    private Boolean checkStoragePermission() {
        boolean result = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    // if not given then request for permission after that check if request is given or not
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQUEST: {
                if (grantResults.length > 0) {
                    boolean camera_accepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean writeStorageaccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    // if request access given the pick data
                    if (camera_accepted && writeStorageaccepted) {
                        pickFromCamera();
                    } else {
                        Toast.makeText(getContext(), "Please Enable Camera and Storage Permissions", Toast.LENGTH_LONG).show();
                    }
                }
            }

            // function end
            break;
            case STORAGE_REQUEST: {
                if (grantResults.length > 0) {
                    boolean writeStorageaccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                    // if request access given the pick data
                    if (writeStorageaccepted) {
                        pickFromGallery();
                    } else {
                        Toast.makeText(getContext(), "Please Enable Storage Permissions", Toast.LENGTH_LONG).show();
                    }
                }
            }
            break;
        }
    }

    // request for permission to write data into storage
    private void requestStoragePermission() {
        requestPermissions(storagePermission, STORAGE_REQUEST);
    }

    // check camera permission to click picture using camera
    private Boolean checkCameraPermission() {
        boolean result = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result && result1;
    }

    // request for permission to click photo using camera in app
    private void requestCameraPermission() {
        requestPermissions(cameraPermission, CAMERA_REQUEST);
    }

    // if access is given then pick image from camera and then put
    // the imageuri in intent extra and pass to startactivityforresult
    private void pickFromCamera() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.TITLE, "Temp_pic");
        contentValues.put(MediaStore.Images.Media.DESCRIPTION, "Temp Description");
        imageuri = getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        Intent camerIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camerIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageuri);
        startActivityForResult(camerIntent, IMAGE_PICKCAMERA_REQUEST);
    }

    // if access is given then pick image from gallery
    private void pickFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, IMAGEPICK_GALLERY_REQUEST);
    }

    // Upload the value of blog data into firebase
    public void uploadData(final String titl, final String description) {
        // show the progress dialog box
        pd.setMessage("Publishing Post");
        pd.show();
        final String timestamp = String.valueOf(System.currentTimeMillis());
        String filepathname = "Posts/" + "post" + timestamp;
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] data = byteArrayOutputStream.toByteArray();

        // initialising the storage reference for updating the data
        StorageReference storageReference1 = FirebaseStorage.getInstance().getReference().child(filepathname);
        storageReference1.putBytes(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // getting the url of image uploaded
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isSuccessful()) ;
                String downloadUri = uriTask.getResult().toString();
                if (uriTask.isSuccessful()) {
                    // if task is successful the update the data into firebase
                    HashMap<Object, String> hashMap = new HashMap<>();
                    hashMap.put("uid", uid);
                    hashMap.put("uname", name);
                    hashMap.put("uemail", email);
                    hashMap.put("udp", dp);
                    hashMap.put("title", titl);
                    hashMap.put("description", description);
                    hashMap.put("uimage", downloadUri);
                    hashMap.put("ptime", timestamp);
                    hashMap.put("plike", "0");
                    hashMap.put("pcomments", "0");

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Posts");
                    databaseReference.child(timestamp).setValue(hashMap)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    pd.dismiss();
                                    Toast.makeText(getContext(), "Published", Toast.LENGTH_LONG).show();
                                    title.setText("");
                                    des.setText("");
                                    image.setImageURI(null);
                                    imageuri = null;
                                    startActivity(new Intent(getContext(), MainActivity.class));
                                    getActivity().finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            pd.dismiss();
                            Toast.makeText(getContext(), "Failed", Toast.LENGTH_LONG).show();
                        }
                    });

                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Posts");
                    ref.child(timestamp).child("Skills").setValue(selection);

                    DatabaseReference refposts = FirebaseDatabase.getInstance().getReference("Posts").child(timestamp).child("ptime");
                    refposts.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            pid.add(dataSnapshot.getValue());
                            DatabaseReference refskills = FirebaseDatabase.getInstance().getReference("Skills");
                            for(int i=0;i<selection.size();i++){
                                refskills.child(selection.get(i)).child("Posts").child((String) pid.get(0)).setValue(pid.get(0));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    ArrayList<String> postsids = new ArrayList<String>();
                    ArrayList<String> usersids = new ArrayList<String>();
                    ArrayList<String> publishername = new ArrayList<String>();

                    DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference("Skills");
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            HashMap<String, Object> array = new HashMap<String, Object>();
                            array = (HashMap<String, Object>) snapshot.getValue();
                            String postid;
                            for(int i = 0; i<selection.size(); i++){
                                for (Map.Entry<String, Object> entry : array.entrySet()){
                                    if(selection.get(i).equals(entry.getKey())){
                                        HashMap<Object, Object> array2 = (HashMap<Object, Object>) entry.getValue();
                                        for (Map.Entry<Object, Object> entry2 : array2.entrySet()){
                                            postid = (timestamp);
                                            postsids.add(postid);
                                            if(entry2.getKey().equals("Users")){
                                                HashMap<Object, Object> array4 = (HashMap<Object, Object>) entry2.getValue();
                                                for(Object items : array4.values()){
                                                    if(items.equals((Object) FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                                                        continue;
                                                    }
                                                    else{
                                                        usersids.add((String) items);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                            System.out.println("Postsid ="+postsids);
                            System.out.println("User id = "+usersids);
                            DatabaseReference databaseReference2 = FirebaseDatabase.getInstance().getReference("Posts");
                            databaseReference2.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    HashMap<String, Object> array = new HashMap<String, Object>();
                                    array = (HashMap<String, Object>) snapshot.getValue();
                                    String name;
                                    for(int i=0;i< postsids.size();i++){
                                        for (Map.Entry<String, Object> entry : array.entrySet()){
                                            if(entry.getKey().equals(postsids.get(i))){
                                                HashMap<Object, Object> array2 = (HashMap<Object, Object>) entry.getValue();
                                                name = (String) array2.get("uname");
                                                publishername.add(name);
                                            }
                                        }
                                    }
                                    System.out.println("name="+publishername);
                                    DatabaseReference databaseReference3 = FirebaseDatabase.getInstance().getReference("Notification");
                                    for(int i=0;i<usersids.size();i++){

                                        for(int j=0;j< postsids.size();j++) {
                                            databaseReference3.child(usersids.get(i)).child(postsids.get(j)).child("postid").setValue(postsids.get(j));
                                            databaseReference3.child(usersids.get(i)).child(postsids.get(j)).child("uname").setValue(publishername.get(0));
                                            databaseReference3.child(usersids.get(i)).child(postsids.get(j)).child("description").setValue(publishername.get(0) + " added a post which might interest you!");
                                            System.out.println("Done");
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

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_LONG).show();
            }
        });
    }


    // Here we are getting data from image
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == getActivity().RESULT_OK) {
            if (requestCode == IMAGEPICK_GALLERY_REQUEST) {
                imageuri = data.getData();
                image.setImageURI(imageuri);
            }
            if (requestCode == IMAGE_PICKCAMERA_REQUEST) {
                image.setImageURI(imageuri);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}