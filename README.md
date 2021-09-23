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
- Notifications page(_incomplete_)
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

### Concepts used :

- **Authentication** : For any social media application wherein multiple users can connect to each other, authentication is a must. Else, the application may be used in ways it's not supposed to be used. Therefore, we have used FirebaseAuth service for authenticating the users.
- **DBMS** : The complete backend of this application is dependent on a cloud-hosted database known as Firebase. Databases are powerful tools which help us store data of various types in an organized way. Firebase offers a lot of features for easy manipulation of the database using Android Studio.
- **Fragmentation** : Instead of using different activities for different functions of the application, we have used fragments.
- **Model classes** : Model classes contain getters and setters for the variables defined in them. These are used in the corresponding Adapter classes/other classes.
- **Adapter classes** : Adapter classes are a link between the front-end and the back-end of the application. They are responsible for transferring data between multiple classes and displaying it as per requirement.

### Java files created :

- `ModelChat.java` : Contains _getters_ and _setters_ for retrieving/assigning values to various variables required to allow chat functionality between two users.
- `AdapterChat.java` : Contains various functions to transfer data between chat classes and display it using whichever view required.
- `ChatActivity.java` : Responsible for showing the chat screen between two users and performing various functions around it.
- `ModelChatlist.java` : Contains _getters_ and _setters_ for retrieving/assigning values to various variables required to allow displaying all the chats of the current user.
- `AdapterChatList.java` : Contains various functions to transfer data between chatlist classes and display it using whichever view required.
- `ChatboxFragment.java` : Responsible for displaying all the chats of the current user as received from the chatlist classes.

- `ModelUsers.java` : Contains _getters_ and _setters_ for retrieving/assigning values to various variables required to allow displaying a list of registered users.
- `AdapterUsers.java` : Contains various functions to transfer data between user classes and display it using whichever view required.
- `UsersFragment.java` : Responsible for displaying all the registered users as received from other user classes.

### Please note :

- First of all, connect your app to Firebase. Then, add the required Firebase SDKs for the Firebase services being used in the app(_FirebaseAuth, FirebaseDatabase, FirebaseStorage_). This can be done either by adding the required dependencies manually(these can be found at [_Firebase Documentation_](https://firebase.google.com/docs)) in the gradle files which will download the SDKs, or by using the IDE to add the SDKs automatically(go to _Tools>Firebase_ to do so).
- Update `AndroidManifest.xml` file as per the one present in this repository.
- Update _res>font_ folder.
- Update _res>values>colors_ folder.
- Update _res>drawables_ folder.
- Update _app>src>main>res>font_ folder. This folder contains the external fonts used.
- Update _res>values>colors.xml_ file. This folder contains the external colors used.
- Update _app>src>main>res>drawable_ folder. This folder contains the xml files used.
