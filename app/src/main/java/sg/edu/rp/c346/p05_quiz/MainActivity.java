package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit, btnPlus, btnMinus;
    CheckBox cbOne, cbTwo;
    TextView noPax;

    int paxState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        cbOne = findViewById(R.id.cbOne);
        cbTwo = findViewById(R.id.cbTwo);
        noPax = findViewById(R.id.noPax);
        paxState = Integer.parseInt(noPax.getText().toString());

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paxState++;
                Log.d("MainActivity", String.valueOf(paxState));
                noPax.setText(String.valueOf(paxState));
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paxState > 0) {
                    paxState--;
                }
                noPax.setText(String.valueOf(paxState));
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbOne.isChecked() || cbTwo.isChecked()) {
                    if (cbOne.isChecked() && cbTwo.isChecked()) {
                        Toast.makeText(MainActivity.this, "Please select 1 checkbox", Toast.LENGTH_SHORT).show();
                    } else {
                        if (paxState > 0) {
                            Intent intent = new Intent(MainActivity.this, Flight_Details.class);
                            if (cbOne.isChecked()) {
                                intent.putExtra("cb", 1);
                            } else if (cbTwo.isChecked()) {
                                intent.putExtra("cb", 2);
                            } else {
                                intent.putExtra("cb", 1);
                            }
                            intent.putExtra("pax", paxState);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter number of pax", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Both checkboxes selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
