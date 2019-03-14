# TestMyWACLib
scanner library with google vision

don't forget to add 
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
```
dependencies {
	implementation 'com.github.mywac:TestMyWACLib:0.1.0'
}
```
also must is to add permission for camera in manifest 
```
	<uses-permission android:name="android.permission.CAMERA"/>
```
