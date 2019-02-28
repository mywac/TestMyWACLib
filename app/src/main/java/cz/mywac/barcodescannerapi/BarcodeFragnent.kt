package cz.mywac.barcodescannerapi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.support.design.widget.Snackbar
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import cz.mywac.barcodescannerapi.barcodeView.BarcodeGraphic
import cz.mywac.barcodescannerapi.barcodeView.BarcodeGraphicTracker
import cz.mywac.barcodescannerapi.barcodeView.CameraSourcePreview
import cz.mywac.barcodescannerapi.barcodeView.GraphicOverlay

class BarcodeFragnent:Fragment(), BarcodeGraphicTracker.BarcodeUpdateListener {

    val RC_HANDLE_GMS = 9001
    lateinit var mPreview:CameraSourcePreview
    lateinit var graphicOverlay: GraphicOverlay<BarcodeGraphic>
    var gestureRecognizer:GestureDetector? = null
    var scaleGestureDetector:ScaleGestureDetector? = null

    override fun onBarcodeDetected(barcode: Barcode?) {


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootview = inflater.inflate(R.layout.camera_fragment,container,false)
        mPreview = rootview.findViewById(R.id.preview)
        graphicOverlay = rootview.findViewById(R.id.graphicOverlay)
        gestureRecognizer = GestureDetector(context,CaptureGestureListener())
        scaleGestureDetector = ScaleGestureDetector(context,ScaleListener())
        Snackbar.make(graphicOverlay,"tap to capture",Snackbar.LENGTH_LONG).show()
        return rootview
    }

    fun createCamera () {
        val context = context
        val barcodeDetector = BarcodeDetector.Builder(context).build()
//        val barcodeTracker =
    }


    class CaptureGestureListener: GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            return super.onSingleTapConfirmed(e)
        }
    }
    class ScaleListener:ScaleGestureDetector.OnScaleGestureListener {
        override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector?) {
        }

        override fun onScale(detector: ScaleGestureDetector?): Boolean {
            return false
        }

    }


}