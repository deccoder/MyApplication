package declanbrophy.myapplication;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

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

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.activity_view_team, null, true);

        TextView teamName = (TextView) listViewItem.findViewById(R.id.teamName);
        TextView systemAdmin = (TextView) listViewItem.findViewById(R.id.systemAdmin);
        TextView address = (TextView) listViewItem.findViewById(R.id.address);
        TextView email = (TextView) listViewItem.findViewById(R.id.email);

        Team team = teamOne.get(position);

        teamName.setText(team.getTeamName());
        systemAdmin.setText(team.getSystemAdmin());
        address.setText(team.getAddress());
        email.setText(team.getEmail());

        return  listViewItem;
    }
}
