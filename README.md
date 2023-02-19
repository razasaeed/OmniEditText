# OmniEditText
"Omni" is a prefix that comes from the Latin word "omnis", meaning "all" or "everything". Therefore, "OmniEditText" could be interpreted as an EditText that can handle all types of input and formatting.

[![Build Status](https://api.travis-ci.org/razasaeed/OmniEditText.svg?branch=develop)](https://travis-ci.org/razasaeed/OmniEditText)
[![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=24) ![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/razasaeed/OmniEditText) [![Image of https://github.com/razasaeed/MyCounter](https://github.com/razasaeed/MyCounter/blob/master/svg/profile/badge.svg)](https://github.com/razasaeed/MyCounter)

# Features
- [x] Rounded corners EditText
- [x] Min value can be set
- [x] Shows error if input is less than min value
- [x] Max value can be set
- [x] Shows error if input exceeds max value
- [x] Clear button can be enabled
- [x] Clear button icon can be changed
- [ ] Prefix can be set
- [ ] Suffix can be set
- [ ] Regex can be set
- [ ] Matches the input with regex
- [ ] Shows error if input doesn't match regex

# Implementation

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

# XML
