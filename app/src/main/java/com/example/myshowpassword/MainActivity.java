package com.example.myshowpassword;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEmail = findViewById(R.id.text_input_email);
        textInputUsername = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_pasword);

    }
    private boolean validateEmail (){
    String EmailInput = textInputEmail.getEditText().getText().toString().trim();
    if (EmailInput.isEmpty()){
        textInputEmail.setError("field can't empty");
        return false;
    }
    else {
        textInputEmail.setError(null);   // dont show error all
        return true;
    }

    }
   private boolean validateUsername (){
        String UsernameInput = textInputUsername.getEditText().getText().toString().trim();
        if (UsernameInput.isEmpty()){
            textInputUsername.setError("field can't empty");
            return false;
        }else if (UsernameInput.length() > 15){
            textInputUsername.setError("username too long");
            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }
   }
    private boolean validatePassword (){
        String PasswordInput = textInputPassword.getEditText().getText().toString().trim();
        if (PasswordInput.isEmpty()){
            textInputPassword.setError("field can't empty");
            return false;
        }
        else {
            textInputPassword.setError(null);   // dont show error all
            return true;
        }

    }
    public void confirmInput(View view){
  if ( !validateEmail() | !validateUsername() | !validatePassword()){
      return;
  }
     String input = "Email:" + textInputEmail.getEditText().getText().toString().trim();
          input += "\n";
          input += "Username: "+ textInputUsername.getEditText().getText().toString().trim();
          input += "\n";
          input += "password: " + textInputPassword.getEditText().getText().toString().trim();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}
