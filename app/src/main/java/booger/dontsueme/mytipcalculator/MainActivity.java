package booger.dontsueme.mytipcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Set up arrays
                double[] tipAmountPerPerson= new double[3];
                double[] tipAmountTotal= new double[3];
                double[] tipArray = new double[3];
                tipArray[0]=.15;
                tipArray[1]=.20;
                tipArray[2]=.25;
                //Text views for output
                TextView fifteenTipOutput = (TextView) findViewById(R.id.fifteenOutTipText);
                TextView fifteenTotalOutput = (TextView) findViewById(R.id.fifteenOutTotalText);
                TextView twentyTipOutput = (TextView) findViewById(R.id.twentyOutTipText);
                TextView twentyTotalOutput = (TextView) findViewById(R.id.twentyOutTotalText);
                TextView twentyfiveTipOutput = (TextView) findViewById(R.id.twentyfiveOutTipText);
                TextView twentyfiveTotalOutput = (TextView) findViewById(R.id.twentyfiveOutTotalText);

                //Text views for getting user input
                TextView amount = (TextView) findViewById(R.id.billAmountUser);
                TextView party = (TextView) findViewById(R.id.partySizeUser);

                //Parse user input
                double amountUser = Double.parseDouble(amount.getText().toString());
                double partyUser = Double.parseDouble(party.getText().toString());

                //Calculate stuff
                for(int i=0;i<3;i++){
                    tipAmountPerPerson[i]=((tipArray[i]* amountUser)/partyUser);
                }
                for(int i=0;i<3;i++){
                    tipAmountTotal[i]=((tipArray[i]* amountUser)+amountUser)/partyUser;
                }

                //Write the calculated amounts to the output views
                fifteenTipOutput.setText(Double.toString(tipAmountPerPerson[0]));
                fifteenTotalOutput.setText(Double.toString(tipAmountTotal[0]));
                twentyTipOutput.setText(Double.toString(tipAmountPerPerson[1]));
                twentyTotalOutput.setText(Double.toString(tipAmountTotal[1]));
                twentyfiveTipOutput.setText(Double.toString(tipAmountPerPerson[2]));
                twentyfiveTotalOutput.setText(Double.toString(tipAmountTotal[2]));
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
