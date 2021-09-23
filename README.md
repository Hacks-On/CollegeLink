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

### How to test this application on your system :

- First of all, make sure you have [Git](https://git-scm.com/) installed in your system. Open CMD and paste - `git clone https://github.com/Hacks-On/CollegeLink`.
- Now, open Android Studio and open the cloned project.
- Let the gradle sync/build(some dependencies and SDKs will be downloaded and installed). Meanwhile, go to _Tools>Firebase_ and select :

  > Authentication>Authentication using a custom authentication system. Connect your app to Firebase and add the FirebaseAuth SDKs to your project.
  
  > Realtime Database>Get started with Realtime Database. Add the FirebaseDatabase SDKs to your project.
  
  > Cloud Storage for Firebase>Get started with Cloud Storage. Add the FirebaseStorage SDKs to your project.
  
- Please note that the above step helps you connect the cloned project to your own Firebase project on the [Firebase console](https://console.firebase.google.com). You can skip this step since the application is already connected to our Firebase project and the dependencies for the SDKs are already present in the gradle files(_which are being installed during gradle sync/build_).
- Once the gradle finishes building, you're good to go. Connect Android Studio to your android device or create a virtual device using the AVD manager. Now, run the app. _Voila!_

### External services/libraies used :

- Firebase Authentication(`implementation 'com.google.firebase:firebase-auth:19.0.0'`) : This Firebase service helps in authenticating the users and logging them it/out. It is currently being done using _email_ and _password_. 
- Firebase Realtime Database(`implementation 'com.google.firebase:firebase-database:19.0.0'`) : This Firebase service forms almost the complete back-end of this application
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

- `SplashScreenActivity.java` : Responsible for displaying a _splash screen_ everytime the user opens the application.
- `MainActivity.java` : Contains the code for creation of different fragments and the route to each of them.
- `RegisterActivity.java` : Responsible for registering a new user using their _email_ and _password_ or redirecting an existing user to the _login page_.
- `LoginActivity.java` : Responsible for authenticating an existing user and logging them in or redirecting them to the _register page_.
- `SkillPage.java` : Displays various checkboxes for the user to select their relevant skills and uploads the selection in the database.

- `ModelChat.java` : Contains _getters_ and _setters_ for retrieving/assigning values to various variables required to allow _chat_ functionality between two users.
- `AdapterChat.java` : Contains various functions to transfer data between _chat classes_ and display it using whichever view required.
- `ChatActivity.java` : Responsible for showing the _chat screen_ between two users and performing various functions around it.
- `ModelChatlist.java` : Contains _getters_ and _setters_ for retrieving/assigning values to various variables required to allow _displaying all the chats_ of the current user.
- `AdapterChatList.java` : Contains various functions to transfer data between _chatlist classes_ and display it using whichever view required.
- `ChatboxFragment.java` : Responsible for _displaying all the chats_ of the current user as received from the chatlist classes.

- `ModelUsers.java` : Contains _getters_ and _setters_ for retrieving/assigning values to various variables required to allow _displaying a list of registered users_.
- `AdapterUsers.java` : Contains various functions to transfer data between _user classes_ and display it using whichever view required.
- `UsersFragment.java` : Responsible for _displaying all the registered users_ as received from other user classes.

- `ModelPost.java` : Contains _getters_ and _setters_ for retrieving/assigning values to various variables required to allow _displaying all available posts_ on the homepage and other functionalities.
- `AdapterPosts.java` : Contains various functions to transfer data between _post classes_ and display it using whichever view required.
- `HomeFragment.java` : Responsible for displaying all the available posts with various functionalities.
- `PostDetailsActivity.java` : Responsible for displaying the _details of any post_ which the user clicks on.
- `PostLikedByActivity.java` : Responsible for _displaying a list of all the users who liked a certain post_.
- `AddpostFragment.java` : Allows taking inputs from the user in various fields and _adds all the details in the database_ for further usage.

- `ModelNotifications.java` : Contains _getters_ and _setters_ for retrieving/assigning values to various variables required to allow _displaying notifications_ to every user.
- `AdapterNotifications.java` : Contains various functions to transfer data between _notification classes_ and display it using whichever view required.
- `NotificationsActivity.java` : Responsible for notifying a user regarding publishing of a post which matches the user's skills. It displays a list of all such notifications.

- `ProfileFragment.java` : Responsible for displaying the details of the current user and allowing them to edit their _name_, _email_, _profile picture__ and _skills_.
- `EditProfilePage.java` : Allows the user to edit their details - _name_, _email_ and _profile picture_, same would be updated in the database.
- `ProfileSkillPage.java` : Allows the user to update their _skills_, same would be updated in the database.
- `TheirProfileActivity.java` : Reposible for displaying the details of any user selected from the user's list.

- `ModelComment.java` : Contains _getters_ and _setters_ for retrieving/assigning values to various variables required to allow users to _comment on the posts_ published by other users.
- `AdapterComment.java` : Contains various functions to transfer data between _comment classes/other classes_ and display it using whichever view required.

- `Sender.java` : Contains _getters_ and _setters_ for misc. functions related to _chat_ and _notifications_.
- `Data.java` : Contains _getters_ and _setters_ for misc. functions related to _chat_ and _notifications_.
- `Token.java` : Contains _getters_ and _setters_ for misc. functions related to _chat_ and _notifications_.

### Extra XML files created :

Whenever an Activity or Fragment is created, an XML file is also created along with it which defines the design and UI elements of that activity/fragment. But, apart from those files, we have created some extra XML files as well :

- `row_chat_left.xml` : Contains the design for displaying the messages of the _second person_ in the chat.
- `row_chat_right.xml` : Contains the design for displaying the messages of the _first person(the current user)_ in the chat.
- `row_chatlist.xml` : Contains the design of a dummy chatlist as it will be displayed in the chatbox fragment.
- `row_posts.xml` : Contains the design of a dummy post as it will be displayed on the user's feed.
- `row_notifications.xml` : Contains the design of a dummy notification as it will be displayed on the notifications screen.
- `row_users.xml` : Contains the design of a dummy user as it will be displayed in the users fragment.
- `row_comments.xml` : Contains the design of a dummy comment as it will be displayed on any post.

### Please note :

- First of all, connect your app to Firebase. Then, add the required Firebase SDKs for the Firebase services being used in the app(_FirebaseAuth, FirebaseDatabase, FirebaseStorage_). This can be done either by adding the required dependencies manually(these can be found at [_Firebase Documentation_](https://firebase.google.com/docs)) in the gradle files which will download the SDKs, or by using the IDE to add the SDKs automatically(go to _Tools>Firebase_ to do so).
- Update `AndroidManifest.xml` file as per the one present in this repository.
- Update _res>font_ folder.
- Update _res>values>colors_ folder.
- Update _res>drawables_ folder.
- Update _app>src>main>res>font_ folder. This folder contains the external fonts used.
- Update _res>values>colors.xml_ file. This folder contains the external colors used.
- Update _app>src>main>res>drawable_ folder. This folder contains the xml files used.
