package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Flight_Details extends AppCompatActivity {

    TextView textView, textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Flight_Details);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        Intent i = getIntent();
        int pax = i.getIntExtra("pax", 0);
        int type = i.getIntExtra("cb", 1);

        if (type == 1) {
            textView.setText("You have selected One Way Trip");
        } else {
            textView.setText("You have selected Two Way Trip");
        }

        textView2.setText("Your air ticket costs $" + String.valueOf(calculatePax(pax, type)));

    }

    public int calculatePax(int pax, int type) {
        if (type == 1) {
            return 100 * pax;
        } else {
            return 100 * pax * 2;
        }
    }
}
