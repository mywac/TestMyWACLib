package cz.mywac.barcodescannerapi

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import cz.mywac.barcodescannerapi.javabarcode.BarcodeCaptureActivity

class MainFragment:Fragment(),View.OnClickListener {
    override fun onClick(v: View?) {
        if (v?.id == R.id.barcode_btn) {
//            fragmentManager?.beginTransaction()?.
//                replace(R.id.container,BarcodeFragnent())?.
//                addToBackStack(null)?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)?.
//                commit()
            val intent = Intent(context,BarcodeCaptureActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.main_fragment,container,false)
        val barcodeBtn = rootView.findViewById<Button>(R.id.barcode_btn)
        barcodeBtn.setOnClickListener(this)
        return rootView
    }
}