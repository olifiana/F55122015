package com.olifiana.f55122015;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidht, edtHeight, edtLength;
    private Button btncalCulculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidht = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        btncalCulculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btncalCulculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inputLrngth = edtLength.getText().toString().trim();
            String inputWidth = edtWidht.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();
            boolean isEmpttFields = false;
            if (TextUtils.isEmpty(inputLrngth)){
                isEmpttFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidth)){
                isEmpttFields = true;
                edtWidht.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)){
                isEmpttFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmpttFields){
                double volume = Double.parseDouble(inputLrngth) * Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}