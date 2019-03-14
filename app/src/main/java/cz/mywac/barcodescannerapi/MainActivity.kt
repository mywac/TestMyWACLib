package cz.mywac.barcodescannerapi

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.widget.Toast
import cz.mywac.barcodescannerapi.javabarcode.BarcodeConstants


class MainActivity : AppCompatActivity() {
    val permissions = arrayOf<String>(Manifest.permission.CAMERA)
    val RC_HANDLE_CAMERA_PERM = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container,MainFragment())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == BarcodeConstants.BARCODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra(BarcodeConstants.BARCODERESULT);

                Toast.makeText(this,result,Toast.LENGTH_LONG).show();
            }

        }
        super.onActivityResult(requestCode, resultCode, data)

    }
}
