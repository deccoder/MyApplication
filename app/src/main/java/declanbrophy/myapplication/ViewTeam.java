package declanbrophy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewTeam extends AppCompatActivity {

    ListView teamList;
    DatabaseReference teamDetails;
    //List to store teams in
    List<Team> teams;



    @Override
    protected void onStart() {
        super.onStart();

        teamDetails.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                teams.clear();
                //Returns all data from the database
                for (DataSnapshot teamSnapshot : dataSnapshot.getChildren()){
                    //Using team object to get values
                    Team team = teamSnapshot.getValue(Team.class);

                    teams.add(team);

                }

                TeamList adapter = new TeamList(ViewTeam.this, teams);
                teamList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_team);

        teamList = (ListView) findViewById(R.id.teamList);
        teams = new ArrayList<>();



    }
}
