package com.example.leon.uhacks2016;

import android.bluetooth.BluetoothSocket;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    private BluetoothSocket BlueSocket;
    public BluetoothAdapter BlueAdapt;
    public static final int REQUEST_ENABLE_BT = 1;
    public BroadcastReceiver mReceiver = null;
    static ArrayList<String> devices;
    NotificationCompat.Builder notification;
    NotificationManager NM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        notification = new NotificationCompat.Builder(this);
        notification.setContentTitle("FIND YOUR DRUNK FRIEND");
        NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setContentText("");

        BlueAdapt = BluetoothAdapter.getDefaultAdapter();
        if(BlueAdapt == null){
            //Bluetooth not supported
        }
        BluetoothConnect xConnect =new BluetoothConnect();


        devices = new ArrayList<String>();//need the name of the listview for this
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        xConnect.forceEnableBluetooth();
        xConnect.findDevices();
        NM.notify(0, notification.build());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void forceEnableBluetooth(){
//        if (!BlueAdapt.isEnabled()) {
//            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
//        }
//    }
//
//    public void findDevices(){
//        mReceiver = new BroadcastReceiver() {
//            public void onReceive(Context context, Intent intent) {
//                String action = intent.getAction();
//                // When discovery finds a device
//                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
//                    // Get the BluetoothDevice object from the Intent
//                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//                    // Add the name and address to an array adapter to show in a ListView
//                    devices.add(device.getName() + "\n" + device.getAddress());
//                    Log.v("MYSHIT", "YOOOOOOOO");
//                    Log.v("MYSHIT", devices.toString());
//                }
//
//
//            }
//        };
//
//        // Register the BroadcastReceiver
//        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
//        registerReceiver(mReceiver, filter); // Don't forget to unregister during onDestroy
//
//    }

    public void PostConnection(){


    }

}
