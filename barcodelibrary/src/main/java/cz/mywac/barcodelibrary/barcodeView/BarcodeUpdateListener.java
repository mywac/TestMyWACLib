package cz.mywac.barcodelibrary.barcodeView;

import android.support.annotation.UiThread;
import com.google.android.gms.vision.barcode.Barcode;

public interface BarcodeUpdateListener {
    @UiThread
    void onBarcodeDetected(Barcode barcode);
}
