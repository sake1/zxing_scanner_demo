package com.demo.zxing.zxing_scanner_demo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.BarcodeView;
import com.journeyapps.barcodescanner.Decoder;
import com.journeyapps.barcodescanner.DecoderFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by USER on 18/01/2017.
 */

public class SimpleScanner extends Activity {

    private BarcodeView barcodeView;

    private BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(BarcodeResult result) {
            Toast.makeText(SimpleScanner.this, result.getText(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void possibleResultPoints(List<ResultPoint> resultPoints) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_scanner);

        barcodeView = (BarcodeView) findViewById(R.id.barcode_scanner);
        barcodeView.decodeSingle(callback);
    }

    @Override
    protected void onResume() {
        super.onResume();

        barcodeView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        barcodeView.pause();
    }
}
