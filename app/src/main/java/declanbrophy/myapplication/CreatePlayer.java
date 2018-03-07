package declanbrophy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class CreatePlayer extends AppCompatActivity {

    Button add;
    EditText name,email,squadNumber,pinNumber;
    DatabaseReference databaseReference;
    List<Players> players;
    private static String playerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_player);

        players = new ArrayList<Players>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Players");

        add = (Button) findViewById(R.id.add);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        squadNumber = (EditText) findViewById(R.id.squadNumber);
        pinNumber = (EditText) findViewById(R.id.pinNumber);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = name.getText().toString();

                if (TextUtils.isEmpty(playerId)) {
                    String playerId = databaseReference.push().getKey();
                    Players players = new Players(playerId,playerName);
                    databaseReference.child(playerId).setValue(players);
                }else if (TextUtils.isEmpty(playerId)) {
                    String playerId = databaseReference.push().getKey();
                    String pEmail = email.getText().toString();
                    Players players = new Players(playerId,pEmail);
                    databaseReference.child(playerId).setValue(players);
                }else if (TextUtils.isEmpty(playerId)) {
                    String playerId = databaseReference.push().getKey();
                    String pSquadNumber = squadNumber.getText().toString();
                    Players players = new Players(playerId,pSquadNumber);
                    databaseReference.child(playerId).setValue(players);
                }else  {
                    String playerId = databaseReference.push().getKey();
                    String playerPin = pinNumber.getText().toString();
                    Players players = new Players(playerId,playerPin);
                    databaseReference.child(playerId).setValue(players);

                    Toast.makeText(CreatePlayer.this, "Player details added", Toast.LENGTH_SHORT).show();
                }
            }
        });
}

}