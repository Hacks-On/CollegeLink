# CollegeLink

### This repository currently contains the source code for :

- Splash screen(_incomplete_)
- Login/register pages(_incomplete_)
- Skills page(_complete_)
- Homepage(_complete_)
- Addpost fragment(_incomplete_)
- Profile fragment(_complete_)
- Profile skills page(_complete_)
- Edit profile page(_complete_)
- Notifications fragment(_incomplete_)
- Users fragment(_complete_)
- Users' profile page(_incomplete_)
- Chatbox fragment(_incomplete_)
- Home fragment(_incomplete_)

### External services/libraies used :

- Firebase Authentication(`implementation 'com.google.firebase:firebase-auth:19.0.0'`)
- Firebase Realtime Database(`implementation 'com.google.firebase:firebase-database:19.0.0'`)
- Firebase Storage(`implementation 'com.google.firebase:firebase-storage:19.0.0'`)
- Volley library(`implementation 'com.android.volley:volley:1.1.1'`)
- Circle Image View(`implementation 'de.hdodenhof:circleimageview:3.1.0'`)
- Gson library(`implementation 'com.google.code.gson:gson:2.8.6'`)

### Java files created :

- `ModelChat.java` : Contains various functions used to fetch keys/data related to the chat fragment wherever required.

### Please note :

- First of all, connect your app to Firebase. Then, add the required Firebase SDKs for the Firebase services being used in the app(_FirebaseAuth, FirebaseDatabase, FirebaseStorage_). This can be done either by adding the required dependencies manually(these can be found at [_Firebase Documentation_](https://firebase.google.com/docs)) in the gradle files which will download the SDKs, or by using the IDE to add the SDKs automatically(go to _Tools>Firebase_ to do so).
- Update `AndroidManifest.xml` file as per the one present in this repository.
- Update _res>font_ folder.
- Update _res>values>colors_ folder.
- Update _res>drawables_ folder.
- Update _app>src>main>res>font_ folder. This folder contains the external fonts used.
- Update _res>values>colors.xml_ file. This folder contains the external colors used.
- Update _app>src>main>res>drawable_ folder. This folder contains the xml files used.
