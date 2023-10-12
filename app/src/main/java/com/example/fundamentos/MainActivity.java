package com.example.fundamentos;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    private int count = 0;
//    public void addCount(){count++;}
    private TextView display_count;
    public TextView getDisplayCount() {return display_count;}
    public void setDisplayCount(TextView display_count) {
        this.display_count = display_count;
        this.display_count.setText( Integer.toString(0) );
    }
    public void updateDisplay() {
        int count = Integer.parseInt(this.display_count.getText().toString());
        this.display_count.setText( Integer.toString(count+1) );
//        this.display_count.setText( Integer.toString(this.count) );
    }

    private Button adder;
    public Button getAdder() {return adder;}
    public void setAdder(Button adder) {
        this.adder = adder;
        this.adder.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        addCount();
                        updateDisplay();
                    }
                }
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDisplayCount(findViewById(R.id.display_count));
        setAdder(findViewById(R.id.adder));
//        this.count = 0;
    }
}