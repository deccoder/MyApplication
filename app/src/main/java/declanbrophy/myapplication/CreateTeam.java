package declanbrophy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CreateTeam extends AppCompatActivity {

    Button save;
    EditText teamName, systemAdmin, address, email;
    DatabaseReference teamDetails;
    Team teamOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);

        teamOne = new Team();
        teamDetails = FirebaseDatabase.getInstance().getReference("teams");

        save = (Button) findViewById(R.id.save);
        teamName = (EditText) findViewById(R.id.teamName);
        systemAdmin = (EditText) findViewById(R.id.systemAdmin);
        address = (EditText) findViewById(R.id.address);
        email = (EditText) findViewById(R.id.email);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTeam();

                String name = teamName.getText().toString();
                String sAdmin = systemAdmin.getText().toString();
                String location = address.getText().toString();
                String contact = email.getText().toString();

                teamOne.setTeamName(name);
                teamOne.setSystemAdmin(sAdmin);
                teamOne.setAddress(location);
                teamOne.setEmail(contact);
            }
        });



    }

private void addTeam(){
    String name = teamName.getText().toString();
    String sAdmin = systemAdmin.getText().toString();
    String location = address.getText().toString();
    String contact = email.getText().toString();

    String id = teamDetails.push().getKey();

    Team teamOne = new Team(name, sAdmin, location, contact);

    teamDetails.child(id).setValue(teamOne);

    Toast.makeText(CreateTeam.this, "Team Details Saved", Toast.LENGTH_LONG).show();
}

}

