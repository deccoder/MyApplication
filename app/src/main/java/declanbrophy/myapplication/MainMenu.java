package declanbrophy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static declanbrophy.myapplication.R.id.teamButton;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Initialize and create contents of user interface
        final Button teamButton = (Button) findViewById(R.id.teamButton);
        final Button viewTeam = (Button) findViewById(R.id.viewTeam);
        final Button playerButton = (Button) findViewById(R.id.playerButton);
        final Button viewPlayer = (Button) findViewById(R.id.viewPlayers);
        final Button eventButton = (Button) findViewById(R.id.eventButton);
        final Button viewEvent = (Button) findViewById(R.id.viewEvent);

        //Brings user to create team details page
        teamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, CreateTeam.class);
                startActivity(intent);
            }
        });
        //Brings user to view the team/teams that have been created
        viewTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ViewTeam.class);
            }
        });
        //Brings user to adding players to the team
        playerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, CreatePlayer.class);
                startActivity(intent);
            }
        });
        //Brings user to player details that have been added to the team
        viewPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ViewPlayer.class);
            }
        });
        //Brings user to create a schedule of matches and training
        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, CreateEvent.class);
            }
        });
        //Brings user to calendar of events organised for the team
        viewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ViewEvents.class);
            }
        });

    }
}
