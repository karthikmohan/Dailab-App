package com.iitd.dailab.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.materialtextfield.MaterialTextField;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.iitd.dailab.Adapter.ChatListAdapter;
import com.iitd.dailab.Model.Chat;
import com.iitd.dailab.R;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by Alienware on 26-05-2017.
 */

public class CoachFragment extends AppCompatActivity {


    // TODO: change this to your own Firebase URL
    private static final String FIREBASE_URL = "https://dailab-8e134.firebaseio.com/";

    private String mUsername;
    private Firebase mFirebaseRef;
    private ValueEventListener mConnectedListener;
    private ChatListAdapter mChatListAdapter;
    private EditText inputText;
    private FirebaseUser user;
    private ProgressWheel progresswheel;
    private MaterialTextField mat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coach);
        Firebase.setAndroidContext(this);
        user = FirebaseAuth.getInstance().getCurrentUser();
        initViews();
    }

    private void initViews(){
        // Make sure we have a mUsername
        setupUsername();

        //setTitle("Chatting as " + mUsername);

        // Setup our Firebase mFirebaseRef
        mFirebaseRef = new Firebase(FIREBASE_URL).child("chat");

        // Setup our input methods. Enter key on the keyboard or pushing the send button
        inputText = (EditText) findViewById(R.id.edit_text);
        mat = (MaterialTextField) findViewById(R.id.matedit);
        mat.expand();

        progresswheel = (ProgressWheel)findViewById(R.id.progress_wheel);

        findViewById(R.id.sendButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Setup our view and list adapter. Ensure it scrolls to the bottom as data changes
        final ListView listView = (ListView) findViewById(R.id.list);
        //final ListView listView = getListView();
        // Tell our list adapter that we only want 50 messages at a time
        mChatListAdapter = new ChatListAdapter(mFirebaseRef.limit(50), this, R.layout.chat_message, mUsername);
        try {
            listView.setAdapter(mChatListAdapter);
        }catch (Exception ignored)
        {
        }
        mChatListAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                try{
                    listView.setSelection(mChatListAdapter.getCount() - 1);
                }catch (Exception ignored){}

            }
        });

        // Finally, a little indication of connection status
        mConnectedListener = mFirebaseRef.getRoot().child(".info/connected").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean connected = (Boolean) dataSnapshot.getValue();
                if (connected) {
                    //Toast.makeText(getContext(), "Connected to Chat", Toast.LENGTH_SHORT).show();
                    progresswheel.setVisibility(View.GONE);
                } else {
                    //Toast.makeText(getContext(), "Disconnected from Chat", Toast.LENGTH_SHORT).show();
                    progresswheel.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        mFirebaseRef.getRoot().child(".info/connected").removeEventListener(mConnectedListener);
        mChatListAdapter.cleanup();
    }

    private void setupUsername() {
        if (user != null) {
            if(user.isAnonymous())
            {
                SharedPreferences prefs = getSharedPreferences("ChatPrefs", 0);
                mUsername = prefs.getString("username", null);
                if (mUsername == null) {
                    Random r = new Random();
                    // Assign a random user name if we don't have one saved.
                    mUsername = "DAILAB" + r.nextInt(100000);
                    prefs.edit().putString("username", mUsername).apply();
                }
            }
            else {// User is signed in
                mUsername = user.getDisplayName();
            }
        } else {
            SharedPreferences prefs = getSharedPreferences("ChatPrefs", 0);
            mUsername = prefs.getString("username", null);
            if (mUsername == null) {
                Random r = new Random();
                // Assign a random user name if we don't have one saved.
                mUsername = "DAILAB" + r.nextInt(100000);
                prefs.edit().putString("username", mUsername).apply();
            }
        }
    }

    private void sendMessage() {

        String input = inputText.getText().toString();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null && user.isAnonymous()) {
            // Create our 'model', a Chat object
            Chat chat = new Chat("*Only signed-in users' messages will be displayed*", mUsername);
            // Create a new, auto-generated child of that chat location, and save our chat data there
            mFirebaseRef.push().setValue(chat);
            inputText.setText("");
        }
        else {
            if (!input.equals("")) {
                // Create our 'model', a Chat object
                Chat chat = new Chat(input, mUsername);
                // Create a new, auto-generated child of that chat location, and save our chat data there
                mFirebaseRef.push().setValue(chat);
                inputText.setText("");
            }
        }
    }

}