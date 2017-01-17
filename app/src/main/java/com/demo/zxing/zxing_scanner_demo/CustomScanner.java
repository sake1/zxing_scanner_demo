package com.demo.zxing.zxing_scanner_demo;

import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

public class CustomScanner extends CaptureActivity {

    /**
     * We can leave this class blank to leave it in a default state,
     * but if we want to use custom layout for our scanner
     * then we need to override initializeContent,
     * which then REQUIRED us to create an xml file that contain a
     * DecoratedBarcodeView to be returned
     */
    @Override
    protected DecoratedBarcodeView initializeContent() {
        /**
         * The following setContentView will inflate a layout with a scanner in it
         * but the scanner will be covered with mask
         *
         * Just to demonstrate how the custom layout work,
         * you can add anything other than that into the custom layout
         * like ImageView, bButton, etc as needed
         */
        setContentView(R.layout.activity_custom_scanner);

        return (DecoratedBarcodeView) findViewById(R.id.barcode_scanner);
    }
}
