package declanbrophy.myapplication;


import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class TeamList extends ArrayAdapter<Team> {

    private Activity context;
    private List<Team> teamOne;



    public TeamList(Activity context, List<Team> teamOne){
        super(context, R.layout.activity_view_team);
        this.context = context;
        this.teamOne = teamOne;
    }
}
