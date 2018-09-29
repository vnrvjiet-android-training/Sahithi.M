package com.example.sahithi.firebasedemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance ();
        String email;
        String password;
        mAuth.createUserWithEmailAndPassword ("sahithi@gmail.com", "123456")
                .addOnCompleteListener (this, new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful ()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d ("Log", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser ();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d ("Log", "createUserWithEmail:failure", task.getException ());
                            Toast.makeText (MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show ();
                        }

                        // ...
                    }
                });
    }
}




