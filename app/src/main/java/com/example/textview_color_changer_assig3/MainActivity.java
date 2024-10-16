package com.example.textview_color_changer_assig3;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // here we declare variables for the UI components
    private TextView txtview1, txtview2,txtview3;
    private EditText editTxt;
    private Button submitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //here we will initialize views

        txtview1 = findViewById(R.id.txtview1);
        txtview2= findViewById(R.id.txtview2);
        txtview3= findViewById(R.id.txtview3);
        editTxt = findViewById(R.id.editTxt);
        submitbtn= findViewById(R.id.submitbtn);

        //Now here we will attach the click listener to our submit button
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the input from the EditText
                String input = editTxt.getText().toString().trim();

                //here we will check if the input is valid

                if (TextUtils.isEmpty(input)) {

                    Toast.makeText(MainActivity.this, "Please Enter a Number", Toast.LENGTH_LONG).show();
                    return;
                }

                //In this part of code we will handle the Exception.
                //Now as in the xml part we have mentioned input type as Number so this part of the code doesn't get implemented as it only allows you to just Enter the number.

                int number;
                try {
                    number = Integer.parseInt(input);  //this method will throw exception if suppose a non-numeric string is entered(for eg. "abc")
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_LONG).show();
                    //catch block handles this exception by displaying a toast message.
                    return;
                }

                //Reset all TextViews to green.
                //So,whenever we enter any number other than 1,2,3 at that time the color of all textview will be set to green

                txtview1.setTextColor(Color.GREEN);
                txtview2.setTextColor(Color.GREEN);
                txtview3.setTextColor(Color.GREEN);

                //Now our Main task is to change the color of the specific TextView based on the entered number so for that we will use switch case, we can also use if-else

                switch (number) {

                    case 1:
                        txtview1.setTextColor(Color.RED);
                        break;
                    case 2:
                        txtview2.setTextColor(Color.RED);
                        break;
                    case 3:
                        txtview3.setTextColor(Color.RED);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Enter a number between 1 and 3", Toast.LENGTH_LONG).show();
                        break;
                }

                /*
                 * if (number==1){
                 * txtview1.setTextColor(Color.RED);
                 * } else if(number==2){
                 * txtview2.setTextColor(Color.RED);
                 * }
                 * */

            }
        });
    }
}