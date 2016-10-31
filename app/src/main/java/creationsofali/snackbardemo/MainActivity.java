package creationsofali.snackbardemo;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencing the view
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        // Simple snackbar without action callback
        findViewById(R.id.simpleSnackBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout, "Simple Snackbar!", Snackbar.LENGTH_LONG).show();
            }
        });

        //Snackbar with action callback
        findViewById(R.id.actionCallback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Message deleted", Snackbar.LENGTH_INDEFINITE)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Define action callback here
                                Snackbar.make(coordinatorLayout, "Message restored", Snackbar.LENGTH_SHORT).show();
                            }
                        });
                snackbar.setDuration(8000);//Set how long to show the view, in milliseconds. 8000 = 8s
                snackbar.show();
            }
        });

        //Snackbar with custom colors and action callback as well
        findViewById(R.id.withCustomColors).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Oups failed! connection is weak.",
                        Snackbar.LENGTH_LONG).setAction("Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Define action callback here
                                Toast.makeText(MainActivity.this, "Retrying, please wait...", Toast.LENGTH_LONG).show();
                            }
                        });
                //Changing action text color
                snackbar.setActionTextColor(Color.CYAN);

                //Changing the feedback text color
                View snackbarView = snackbar.getView();
                TextView snackbarText = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                snackbarText.setTextColor(Color.YELLOW);

                snackbar.show();
            }
        });

        //FAB onClickListener
        findViewById(R.id.fabDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout, "Uh.. Any cool notification, done!", Snackbar.LENGTH_LONG)
                        .setAction("EXIT", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Uh.. Just like always, action callback code goes in here
                                finish();
                            }
                        })
                        .setActionTextColor(Color.RED) //Action call back text color
                        .show();
            }
        });


    }
}
