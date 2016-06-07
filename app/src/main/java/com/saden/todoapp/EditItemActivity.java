package com.saden.todoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    EditText etEditItem;
    Button btnSaveItem;

    public void onEditItemSave(View v) {
        etEditItem = (EditText) findViewById(R.id.etEditItem);
        btnSaveItem = (Button) findViewById(R.id.btnSaveItem);
        int pos = (Integer) v.getTag();

        Intent data = new Intent();
        data.putExtra("item-text", etEditItem.getText().toString());
        data.putExtra("item-position", pos);
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        // grab the views
        btnSaveItem = (Button) findViewById(R.id.btnSaveItem);
        etEditItem = (EditText) findViewById(R.id.etEditItem);

        // grab the data passed from the main activity
        String itemText = getIntent().getStringExtra("item-text");
        Integer pos = getIntent().getIntExtra("item-position", 0);

        // set the position for the save button
        btnSaveItem.setTag(pos);
        // set the text
        etEditItem.setText(itemText);
        // put the cursor at the end of the text field
        etEditItem.setSelection(etEditItem.getText().length());
        // focus the text field
        etEditItem.requestFocus();
        // bring up the keyboard programmatically
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(etEditItem, InputMethodManager.SHOW_IMPLICIT);
    }
}
