package com.example.phonenumberspinnerespresso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    private String mSpinnerLabel = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the spinner.
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        // Create ArrayAdapter using the string array and default
        // spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    /**
     * Retrieves the text and spinner item and shows them in text_phonelabel.
     *
     * @param view  The view containing editText_main.
     */
    public void showText(View view) {
        EditText editText = findViewById(R.id.editText_main);
        TextView textView = findViewById(R.id.text_phonelabel);
        if (editText != null) {
            // Assign to showString both the entered string and mSpinnerLabel.
            String showString = (editText.getText().toString() +
                    " - " + mSpinnerLabel);
            // Display a Toast message with showString
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
            // Set the TextView to showString.
            textView.setText(showString);
        }
    }

    /**
     * Retrieves the selected item in the spinner using getItemAtPosition,
     * and assigns it to mSpinnerLabel.
     *
     * @param adapterView   The adapter for the spinner, where the selection
     *                      occurred.
     * @param view          The view within the adapterView that was clicked.
     * @param i             The position of the view in the adapter.
     * @param l             The row id of the item that is selected (not
     *                      used here).
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView,
                               View view, int i, long l) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
        showText(view);
    }

    /**
     * Logs the fact that nothing was selected in the spinner.
     *
     * @param adapterView   The adapter for the spinner, where the selection
     *                      should have occurred.
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, "onNothingSelected: ");
    }

}