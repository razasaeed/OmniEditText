# OmniEditText
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://travis-ci.org/razasaeed/OmniEditText)
[![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=24) ![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/razasaeed/OmniEditText) [![Image of https://github.com/razasaeed/MyCounter](https://github.com/razasaeed/MyCounter/blob/master/svg/profile/badge.svg)](https://github.com/razasaeed/MyCounter)

"Omni" is a prefix that comes from the Latin word "omnis", meaning "all" or "everything". Therefore, "OmniEditText" could be interpreted as an EditText that can handle all types of input and formatting.

## Features
- [x] Rounded corners EditText
- [x] Min value can be set
- [x] Shows error if input is less than min value
- [x] Max value can be set
- [x] Shows error if input exceeds max value
- [x] Clear button can be enabled
- [x] Clear button icon can be changed
- [ ] Input type can be set
- [ ] Prefix can be set
- [ ] Suffix can be set
- [ ] Regex can be set
- [ ] Matches the input with regex
- [ ] Shows error if input doesn't match regex

## Implementation

Step 1. Add the JitPack repository

In older Android Studio versions, add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

In newer Android Studio versions, add it in your root settings.gradle inside dependencyResolutionManagement block:
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency in gradle (Module)
```
implementation 'com.github.razasaeed:OmniEditText:x.y.z'
```

## XML
```
<com.omni.input.OmniEditText
        android:id="@+id/omniEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="20dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:omniHintText="@string/hint_text"
        app:omniHintColor="@color/white"
        app:omniTextColor="@color/black"
        app:omniMaxValue="50"
        app:omniMinValue="10"
        app:omniEnableClearButton="true"
        app:omniClearButtonIcon="@drawable/clear"/>
```

## Attributes

 |        Attributes               |            Description            |         Default Value         |
 | ------------------------------- | -------------------------------   | --------------------------    |
 | omniHintText                    | sets input hint                   |  blank by default             |
 | omniHintColor                   | set hint color of edittext        |  grey color by default        |
 | omniTextColor                   | set text color of edittext        |  black color by default       |
 | omniMaxValue                    | set maximum value of edittext     |  no value by default          |
 | omniMinValue                    | set minimum value of edittext     |  no value by default          |
 | omniEnableClearButton           | enables clear icon if not null    |  disabled by default          |
 | omniClearButtonIcon             | changes clear icon                |  default red icon             |
 
## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.
