package com.example.droidcafeinput;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent=getIntent();
        String order=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView=findViewById(R.id.order_textview);
        textView.setText(order);

        //create the spinner
        Spinner spinner=findViewById(R.id.label_spinner);
        if(spinner!=null){
            spinner.setOnItemSelectedListener(this);
        }
        //create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        //specify the layout to use when this list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply the adapter to the spinner
        if(spinner!=null){
            spinner.setAdapter(adapter);
        }

    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
    public void onRadioButtonClicked(View view) {
        //Is button now checked?
        boolean checked=((RadioButton)view).isChecked();

        //check which radio button was clicked
        switch (view.getId()){
            case R.id.sameday:
                if(checked)
                //same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if(checked)
                    //same day service
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if(checked)
                    //same day service
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                //do something
                break;


        }

        /**
         * this also work
         */
//        RadioButton radioButton=(RadioButton)view;
//        String text=radioButton.getText().toString();
//        displayToast(text);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel=adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void showDatePicker(View view) {
        DialogFragment newFragment= new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"date picker");
    }

    public void processDatePicker(int year, int month, int day){
        String year_string=Integer.toString(year);
        String month_string=Integer.toString(month+1);
        String day_string=Integer.toString(day);
        String dateMessage=month_string+"/"+day_string+"/"+year_string;
        Toast.makeText(this, "Date:"+dateMessage, Toast.LENGTH_SHORT).show();
    }
}