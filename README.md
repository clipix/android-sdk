# Clipix Android SDK
==========================

How to use:
-----

1- Add the following to your build.gradle:
```groovy
dependencies {
compile 'com.clipix.sdk:android-clipix-sdk:1.0.2'
}
repositories {
  maven {
    url  "http://dl.bintray.com/clipix/clipix"
  }
}
```
2- Create a Clipix save button in an XML layout:

```xml
<com.clipix.save.ClipixButton
android:id="@+id/button"
android:layout_width="wrap_content"
android:layout_height="wrap_content"/>
```
3- Find the button and configure

```java
 ClipixButton saveButton = (ClipixButton) findViewById(R.id.button);
 saveButton.setUrl("http://www.example.com");
```
4- Build and run the app.

Optional properties

```java
saveButton.setImageUrl("http://www.example.com/image.png"); //Clip image
saveButton.setDescription("Description"); // Clip description
saveButton.setColor(ClipixButton.Style.STYLE_ORANGE); //Button style gray, white or orange
saveButton.setLanguage(ClipixButton.Language.English); //Button display language
saveButton.setButtonText(ClipixButton.ButtonText.SAVE_THIS);
saveButton.setButtonText(ClipixButton.ButtonText.SAVE, ClipixButton.Language.English);
saveButton.setPrice(20); //For product type clips 
saveButton.setCurrencyType(ClipixButton.CurrencyType.USD)
```

Optional xml parameters

```xml
app:color_style="orange" //  gray, white or orange
app:button_text="save_this" // save or save_this
```

