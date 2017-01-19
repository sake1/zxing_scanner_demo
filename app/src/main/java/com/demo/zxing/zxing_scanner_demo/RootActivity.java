package com.demo.zxing.zxing_scanner_demo;

import android.content.Intent;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeView;
import com.journeyapps.barcodescanner.camera.CameraManager;

public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        /**
         * OPTION 1, Going to the default version of barcode scanner
         * in zxing library
         */
        findViewById(R.id.root_option_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(RootActivity.this);

                /**
                 * this following code will specify what kind of barcode the scanner is going to look for
                 * if not specified, it will defaultly accept all kind of barcode
                 */
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
                /**
                 * IntentIntegrator.ONE_D_CODE_TYPES means it will look for the 1 dimensional barcode types
                 */

                integrator.initiateScan();
            }
        });

        /**
         * OPTION 2, Going to the default version of qr code scanner
         * in zxing library
         */
        findViewById(R.id.root_option_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RootActivity.this, SimpleScanner.class);
                startActivity(intent);
//                IntentIntegrator integrator = new IntentIntegrator(RootActivity.this);
//                integrator.setCaptureActivity(SimpleScanner.class);

                /**
                 * this following code will specify what kind of barcode the scanner is going to look for
                 * if not specified, it will defaultly accept all kind of barcode
                 */
//                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                /**
                 * IntentIntegrator.QR_CODE_TYPES means it will look for the 2 dimensional barcode types
                 */

//                integrator.initiateScan();
            }
        });

        /**
         * OPTION 3, Going to the custom layout version of barcode scanner
         * using journeyapps library (Which add some new feature to zxing scanner
         */
        findViewById(R.id.root_option_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(RootActivity.this);

                integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);

                /**
                 * this following line of code specify a custom activity to inflate the custom layout
                 *
                 * just like ListView require a custom adapter if we want to inflate something custom into it
                 * this scanner also require a class to add some additional features in the scanner
                 */
                integrator.setCaptureActivity(CustomScanner.class);
                /**
                 * In this case it is CustomScanner, a class that extend CaptureActivity
                 * that defined in this application
                 */

                integrator.initiateScan();
            }
        });

        /**
         * OPTION 4, Going to the custom layout version of qr code scanner
         * using journeyapps library (Which add some new feature to zxing scanner
         */
        findViewById(R.id.root_option_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(RootActivity.this);

                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                /**
                 * Note that the only diffrence between OPTION 3 and OPTION 4 listener is only
                 * the type of barcode we specify by setDesiredBarcodeFormats
                 */

                /**
                 * this following line of code specify a custom activity to inflate the custom layout
                 *
                 * just like ListView require a custom adapter if we want to inflate something custom into it
                 * this scanner also require a class to add some additional features in the scanner
                 */
                integrator.setCaptureActivity(CustomScanner.class);
                /**
                 * In this case it is CustomScanner, a class that extend CaptureActivity
                 * that defined in this application
                 */

                integrator.initiateScan();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * onActivityResult is used to handle callbacks from those scanner
         * when they successfuly scan something they will return to the activity that call them
         * with a bundle of data containing information
         * we can handle those information here, in onActivityResult
         */

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            /**
             * IntentIntegrator.REQUEST_CODE is used to make sure that the callback is indeed
             * from the scanner, not from another activity
             */
            if (resultCode == RESULT_OK) {
                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
                Toast.makeText(RootActivity.this, "Scan success!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
