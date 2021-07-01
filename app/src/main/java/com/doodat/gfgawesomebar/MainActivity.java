package com.doodat.gfgawesomebar;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.awesomebar.ActionItem;
import com.github.florent37.awesomebar.AwesomeBar;

public class MainActivity extends AppCompatActivity {

    AwesomeBar bar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        bar = findViewById(R.id.bar);

        // adding action button in AwesomeBar with drawable and text
        bar.addAction(R.drawable.awsb_ic_edit_animated, "Add Post");

        // adding OverFlowItem item in AwesomeBar
        bar.addOverflowItem("Settings");
        bar.addOverflowItem("About");

        bar.setActionItemClickListener(new AwesomeBar.ActionItemClickListener() {
            @Override
            public void onActionItemClicked(int position, ActionItem actionItem) {
                // toast is shown when action item is pressed.
                Toast.makeText(getBaseContext(), actionItem.getText()+" clicked", Toast.LENGTH_LONG).show();
            }
        });

        bar.setOverflowActionItemClickListener(new AwesomeBar.OverflowActionItemClickListener() {
            @Override
            public void onOverflowActionItemClicked(int position, String item) {
                // toast is shown when an OverFlowAction item is pressed.
                Toast.makeText(getBaseContext(), item+" clicked", Toast.LENGTH_LONG).show();
            }

        });

        bar.setOnMenuClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opens the navigation drawer from start
                drawerLayout.openDrawer(Gravity.START);
            }
        });

        // changing true and false changes the icon for navigation drawer
        bar.displayHomeAsUpEnabled(false);
    }
}