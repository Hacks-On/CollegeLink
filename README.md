# CollegeLink
> Where students meet students and skills develop faster than ever!

### Introduction :

This project is aimed at increasing competitiveness among students(preferably students of a specific college) by creating a platform for connecting, conversing and competing in various events held worldwide.

College - Link is an android application wherein college students can register, create their profiles, add their skills, connect to other students of various fields and expand their network meanwhile forming a perfect team for their next competition! Being unaware of any upcoming event is out of the question now!

### Main features of the application :

- _Register/login_ using your email id and password.
- Add your _skills_.
- _Add a post_ along with the skills associated with it.
- View your _feed_, where your post and other users' post will be displayed.
- _Get notified_ when a post is added which matches your skill(s).
- _Like_ other users' posts.
- _Comment_ on other users' posts.
- _Chat_ with other users.
- _View the list_ of all registered users.
- View _other users' profiles_.
- Block/unblock any user.

### Side features of the application :

- Edit your _skills_, _name_, _email_, _password_ and _profile picture_.
- View the number of _likes_ and _comments_ on every post.
- See a list of _all users who liked_ a certain post.
- View all _comments_ on every post.
- _Search for a particular post_ on the homepage using words from its title or description.
- _Search for a particular user_ on the users page by their name or any corresponding alphabets from their name.
- Go to the _chat screen_ directly from any user's post.
- See the _last seen_ of any user you're chatting to.

### Visualizing the project :

- We've made a video showcasing the application and explaining how it actually works. Watch the video [here](https://www.youtube.com/watch?v=0lw2pKzXH-c).
- This project has been listed on [Devfolio](https://devfolio.co/). View it [here](https://devfolio.co/submissions/college-link-09c6).
- We made a presentation before actually creating the application which served as a guidance tool. View that presentation [here](https://docs.google.com/presentation/d/1TQJt-f1rSa-WfJTiyON4Zf9FLmPL4AJWx4m7xmmdeKY/edit#slide=id.geccdadaaa4_0_20).

### Download the APK file :

- We are currently in progress for publishing the app on Playstore so it's not available there yet.
- On the right-hand side of this repository, you'll find the _latest release_ of this application. You can download the apk file as well as the source code for this app by clicking on that tag.
- You can download and install the apk file on your _android_ device from [here](https://drive.google.com/file/d/1CZK77beR0V7axYgvQXRKJVFWt5seFhs9/view?usp=sharing) as well.

### How to test this application on your own system :

- First of all, make sure you have [Git](https://git-scm.com/) installed in your system. Open CMD and paste - `git clone https://github.com/Hacks-On/CollegeLink`.
- Now, open Android Studio and open the cloned project.
- Let the gradle sync/build(some dependencies and SDKs will be downloaded and installed). Meanwhile, go to _Tools>Firebase_ and select :

  > Authentication>Authentication using a custom authentication system. Connect your app to Firebase and add the FirebaseAuth SDKs to your project.
  
  > Realtime Database>Get started with Realtime Database. Add the FirebaseDatabase SDKs to your project.
  
  > Cloud Storage for Firebase>Get started with Cloud Storage. Add the FirebaseStorage SDKs to your project.
  
- Please note that the above step helps you connect the cloned project to your own Firebase project on the [Firebase console](https://console.firebase.google.com). You can skip this step since the application is already connected to _our_ Firebase project and the dependencies for the SDKs are already present in the gradle files(_which are being installed during gradle sync/build_).
- Once the gradle finishes building, you're good to go. Connect Android Studio to your android device or create a virtual device using the AVD manager. Now, run the app. _Voila!_
- If you encounter any bugs while using the application or want to suggest any improvements/features, feel free to create an _issue_ for the same and we'll look into it!

### External services/libraries used :

- Firebase Authentication(`implementation 'com.google.firebase:firebase-auth:19.0.0'`) : This Firebase service helps in authenticating the users and logging them it/out. It is currently being done using _email_ and _password_. 
- Firebase Realtime Database(`implementation 'com.google.firebase:firebase-database:19.0.0'`) : This Firebase service forms almost the complete back-end of this application. Almost all the data being fetched in the application is stored and retreived using this database only.
- Firebase Storage(`implementation 'com.google.firebase:firebase-storage:19.0.0'`) : To upload images or any graphical content, we need a storage unit apart from the database for these items. This task is accomplished using Firebase Storage wherein all the images uploaded by the user(_post images_ and _profile pictures_) are stored.
- Volley library(`implementation 'com.android.volley:volley:1.1.1'`) : This is an _HTTP library_ aimed at making _networking_ for android apps much more easier and faster.
- Circle Image View(`implementation 'de.hdodenhof:circleimageview:3.1.0'`) : This library is used to display any image inside a _circular_ container/frame.
- Gson library(`implementation 'com.google.code.gson:gson:2.8.6'`) : This library is aimed at converting _JSON strings_ into their corresponding _Java objects_ and vice-versa.

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

- `UserHelper.java` : Contains _getters_ and _setters_ for helping the user register/login. This file is currently _not in use_.

### Extra XML files created :

Whenever an Activity or Fragment is created, an XML file is also created along with it which defines the design and UI elements of that activity/fragment. But, apart from those files, we have created some extra XML files as well :

- `row_chat_left.xml` : Contains the design for displaying the messages of the _second person_ in the chat.
- `row_chat_right.xml` : Contains the design for displaying the messages of the _first person(the current user)_ in the chat.
- `row_chatlist.xml` : Contains the design of a _dummy chatlist_ as it will be displayed in the chatbox fragment.
- `row_posts.xml` : Contains the design of a _dummy post_ as it will be displayed on the user's feed.
- `row_notifications.xml` : Contains the design of a _dummy notification_ as it will be displayed on the notifications screen.
- `row_users.xml` : Contains the design of a _dummy user_ as it will be displayed in the users fragment.
- `row_comments.xml` : Contains the design of a _dummy comment_ as it will be displayed on any post.
- `dialog_update_password.xml` : Contains the design for the _dialog box_ which pops up when the button for changing password is clicked.

### Please note :

- First of all, connect your app to Firebase. Then, add the required Firebase SDKs for the Firebase services being used in the app(_FirebaseAuth, FirebaseDatabase, FirebaseStorage_). This can be done either by adding the required dependencies manually(these can be found at [_Firebase Documentation_](https://firebase.google.com/docs)) in the gradle files which will download the SDKs, or by using the IDE to add the SDKs automatically(go to _Tools>Firebase_ to do so).
- Update `AndroidManifest.xml` file as per the one present in this repository. Do note that all the activities present in the project are mentioned in this file.
- Update _app>src>main>res>drawable_ folder. This folder contains the xml files used.
- Update _app>src>main>res>font_ folder. This folder contains the external fonts used.
- Update _res>values>colors.xml_ file. This folder contains the external colors used.
- Update _res>values>strings.xml_ file. This folder contains the external strings used.

### Future enhancements :

- Making _different database segments_ for _different colleges_ and assigning a _unique key_ to students of a particular college. This way, this app can be uniquely used by each college throughout the world. Although, to implement this, a strong and huge database will be required. Luckily, Firebase itself offers such a service(_paid_) which can make this application production-ready.
- Adding the feature to _create a group_ by selecting certain users and starting a group chat.
- Adding _voice chat/meet_ feature.
- Adding the feature to add _videos_ and _links_ in your posts as well.
- Creating _drop-down menus for adding a lot more skills_ from every tech-domain.
- Extending the app to _non-tech fields_ as well. A seperate space can be created for users interested in these fields and same functionalities can be implemented in that space as well.
- _UI/UX improvements_ to match the modern trends of social media.
- Improving the accessibility of _posts_, _users_ and _notifications_ and making them more detailed.

### Connect with the developers :

If you liked our app or want to collaborate in future projects, do connect with us :

- [Kritik Modi](https://www.linkedin.com/in/kritik-modi-2b5415162/)
- [Ritabrata Nag](https://www.linkedin.com/in/nritabrata/)
- [Shubham Shreshth](https://www.linkedin.com/in/shubham-shreshth-83602315b/)
- [Pururaj Singh Rajawat](https://www.linkedin.com/in/pururaj23/)
- [Ishan Das](https://www.linkedin.com/in/ishan-das-4a21791b3/)

