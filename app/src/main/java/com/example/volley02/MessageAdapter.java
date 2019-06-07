package com.example.volley02;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.IO;
import io.socket.client.Socket;

public class MessageAdapter extends Fragment {

    private TextView tvMain;
    private EditText etMsg;
    private Button btnSubmit;
    private Socket socket;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContentView(R.layout.activity_main);
        tvMain = findViewById(R.id.tvMain);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener((view)->{
            JsonObject preJsonObject = new JsonObject();
            preJsonObject.addProperty("comment", etMsg.getText()+"");
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(preJsonObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            socket.emit("reqMsg", jsonObject);
            etMsg.setText("");
        });

        try {
            socket = IO.socket("http://203.250.133.143:14732/chat");
            socket.on(Socket.EVENT_CONNECT, (Object... objects) -> {
                JsonObject preJsonObject = new JsonObject();
                preJsonObject.addProperty("roomName", "myroom");
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(preJsonObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                socket.emit("joinRoom",jsonObject);
            }).on("recMsg", (Object... objects) -> {
                JsonParser jsonParsers = new JsonParser();
                JsonObject jsonObject = (JsonObject) jsonParsers.parse(objects[0] + "");

            });
            socket.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ContentView(int activity_main) {
    }

    private TextView findViewById(int etMsg) {
        return null;
    }

    private void runOnUiThread(Object comment) {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }



}