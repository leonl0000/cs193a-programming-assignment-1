/*


 */


package evilinteligence.timeunits;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int timer_which = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toggleTimer(View view) {
        Button toggler = (Button) view;
        toggler.setText("Stop!!!");
        toggler.setBackgroundColor(Color.RED);//Doesn't work
        int min = Integer.parseInt(((TextView) findViewById(R.id.mins)).getText().toString());
        int sec = Integer.parseInt(((TextView) findViewById(R.id.secs)).getText().toString());
        double time = (60 * min + sec) * 1000;



        Toast.makeText(this, "Actual timer not yet implemented LOL", Toast.LENGTH_SHORT).show();

        TextView count = null;
        switch (timer_which) {
            case 1:
                count = (TextView) findViewById(R.id.t1_count);
                break;
            case 2:
                count = (TextView) findViewById(R.id.t2_count);
                break;
            case 3:
                count = (TextView) findViewById(R.id.t3_count);
                break;
        }
        if(count!=null)
            count.setText(String.valueOf(Integer.parseInt(count.getText().toString()) + 1));

    }

    public void set_timer(View view) {
        String min = "", sec = "";
        int which = 0;

        if(view.getId() == R.id.t1_set) {
            min = ((EditText) findViewById(R.id.t1_min)).getText().toString();
            sec = ((EditText) findViewById(R.id.t1_sec)).getText().toString();
            which = 1;
        } else if(view.getId() == R.id.t2_set) {
            min = ((EditText) findViewById(R.id.t2_min)).getText().toString();
            sec = ((EditText) findViewById(R.id.t2_sec)).getText().toString();
            which = 2;
        } else if(view.getId() == R.id.t3_set) {
            min = ((EditText) findViewById(R.id.t3_min)).getText().toString();
            sec = ((EditText) findViewById(R.id.t3_sec)).getText().toString();
            which = 3;
        }

        int int_min = Integer.parseInt(min);
        int int_sec = Integer.parseInt(sec);
        if(int_min < 0 || int_min > 999)
            Toast.makeText(this, "invalid minutes range (0-999)",Toast.LENGTH_SHORT).show();
        else if(int_sec < 0 || int_sec > 99)
            Toast.makeText(this, "invalid seconds range (0-99)",Toast.LENGTH_SHORT).show();
        else {
            TextView MINS = (TextView) findViewById(R.id.mins);
            TextView SECS = (TextView) findViewById(R.id.secs);
            MINS.setText(min);
            SECS.setText(sec);
            timer_which = which;
        }
    }
}
