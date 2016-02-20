package com.example.leon.uhacks2016;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.io.IOException;
import java.util.UUID;


/**
 * Created by Leon on 2/20/2016.
 */
//public class BluetoothPostConn extends Thread{
//    private final BluetoothServerSocket bluetoothServerSocket;
//    private final static UUID uuid = UUID.fromString("fc5ffc49-00e3-4c8b-9cf1-6b72aad1001a");
//
//    public BluetoothPostConn(BluetoothAdapter BlueAdapt) {
//        BluetoothServerSocket temp = null;
//        try {
//            temp = BlueAdapt.listenUsingRfcommWithServiceRecord("Insert App Name", uuid);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        bluetoothServerSocket = temp;
//    }
//
//    public void run() {
//        BluetoothSocket bluetoothSocket;
//        // This will block while listening until a BluetoothSocket is returned
//        // or an exception occurs
//        while (true) {
//            try {
//                bluetoothSocket = bluetoothServerSocket.accept();
//            } catch (IOException e) {
//                break;
//            }
//            // If a connection is accepted
//            if (bluetoothSocket != null) {
//
//                runOnUiThread(new Runnable() {
//                    public void run() {
//                        Toast.makeText(getApplicationContext(), "A connection has been accepted.",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                // Manage the connection in a separate thread
//
//                try {
//                    bluetoothServerSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
//    }
//
//    // Cancel the listening socket and terminate the thread
//    public void cancel() {
//        try {
//            bluetoothServerSocket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
