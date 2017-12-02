package declanbrophy.myapplication;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText emailAddress,password;
        final Button register,signIn;
        final FirebaseAuth auth;

        final String Tag = "Main Activity";

        auth=FirebaseAuth.getInstance();

        emailAddress=(EditText) findViewById(R.id.emailAddress);
        password=(EditText) findViewById(R.id.password);
        register=(Button) findViewById(R.id.register);
        signIn=(Button) findViewById(R.id.signIn);



        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String inputEmail = emailAddress.getText().toString();
                final String inputPassword = password.getText().toString();

                if (TextUtils.isEmpty(inputEmail)) {
                    Toast.makeText(getApplicationContext(), "Enter email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(inputPassword)) {
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                

                auth.signInWithEmailAndPassword(inputEmail,inputPassword)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    if (password.length() < 6) {
                                        password.setError(getString(R.string.minimum_password));
                                    }
                                }
                            }
                        });
                register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String inputEmail = emailAddress.getText().toString().trim();
                        String inputPassword = password.getText().toString().trim();

                        if (TextUtils.isEmpty(inputEmail)) {
                            Toast.makeText(getApplicationContext(), "Enter email address", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (TextUtils.isEmpty(inputPassword)) {
                            Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (password.length() < 6) {
                            Toast.makeText(getApplicationContext(), "Minimum password length is 6 characters! Please try again", Toast.LENGTH_LONG).show();
                            return;
                        }
                        auth.createUserWithEmailAndPassword(inputEmail,inputPassword)
                                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        Toast.makeText(MainActivity.this, "Registered Successfully" +task.isSuccessful(), Toast.LENGTH_SHORT).show();

                                        if (!task.isSuccessful()) {
                                            Toast.makeText(MainActivity.this, "Authentication Failed" +task.getException(), Toast.LENGTH_SHORT).show();
                                        }else {
                                            startActivity(new Intent(MainActivity.this, MainMenu.class));
                                            finish();
                                        }
                                    }


                                });
                    }
                });
            }
        });
    }
}
