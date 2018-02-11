# Architecture2018 - VIPER Architecture on Android: My POV

### Why VIPER ?
A Clean Architecture for iOS Application Development. There are android architecture like MVP & MVVM but they make the presenter heavy with a lot of code.

### What does a VIPER architecture promotes ?
Separation of Business Logic from the presenter making it easy to port to any application such as even to a console application. 

### My Approach for using this Architecture :-
Idea : App has two screens, login authentication using Firebase Authentication and listing of items from Firebase DB.

<p align="center">
  <img src="https://raw.githubusercontent.com/generic-leo/Architecture2018/master/screenshots/screen_1.png" width="250">  
  <img src="https://raw.githubusercontent.com/generic-leo/Architecture2018/master/screenshots/screen_2.png" width="250">
</p>


### Outline of layers inner modules 

<p align="center">
  <img src="https://raw.githubusercontent.com/generic-leo/Architecture2018/master/screenshots/screen_3.png" width="750">
</p>


Firebase DB Structure : 
```
{
  "architectures" : {
    "mvp" : {
      "message" : "Model View Presenter",
      "title" : "MVP"
    },
    "mvp_clean" : {
      "message" : "Model View Presenter Clean Architecture",
      "title" : "MVP CLEAN"
    },
    "mvvm" : {
      "message" : "Model View ViewModel",
      "title" : "MVVM"
    },
    "viper" : {
      "message" : "VIPER",
      "title" : "VIPER"
    }
  }
}
```
Firebase Auth is Email Authentication 

### [Complete Article on Medium](https://medium.com/@prathamsawant/viper-architecture-on-android-my-pov-df37bebf3f3c)
Note : This project isn’t complete, it is there to represent a approach of using Viper on Android.
