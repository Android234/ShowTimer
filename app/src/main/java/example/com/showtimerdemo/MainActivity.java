package example.com.showtimerdemo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    int minTime = 3663;
    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = (TextView) findViewById(R.id.tvTimer);
        int hours = minTime / 60; //since both are ints, you get an int
        int minutes = minTime % 60;

        Log.e("Hour :: MM ", hours + " :: " + minutes);

        timer.setText(hours + " : " + minutes);

        new CountDownTimer(minTime * 60000, 60000) {
            @Override
            public void onTick(long l) {
                timer.setText("seconds remaining: " + String.format("%02d:%02d", TimeUnit.MILLISECONDS.toHours(l),
                        TimeUnit.MILLISECONDS.toMinutes(l) % TimeUnit.HOURS.toMinutes(1)));

                Log.e("time  : ", l + " ");
            }

            @Override
            public void onFinish() {
                timer.setText("try again");
            }
        }.start();

    }
}
