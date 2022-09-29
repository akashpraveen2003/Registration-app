package com.example.admissionregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import java.util.*;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout name, parent_name, dob, community, number,email,secondary_school,higher_secondary_school,twelth_mark,tenth_mark,cutoff,pincode,city,area,street;
    CheckBox male,female,others;
    Button register;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        parent_name = findViewById(R.id.parent_name);
        dob = findViewById(R.id.dob);
        community = findViewById(R.id.community);
        number = findViewById(R.id.phone_no);
        email=findViewById(R.id.email_address);
        secondary_school=findViewById(R.id.school_name);
        higher_secondary_school=findViewById(R.id.school_name_hsc);
        tenth_mark=findViewById(R.id.ten_mark);
        twelth_mark=findViewById(R.id.twelve_mark);
        cutoff=findViewById(R.id.cut_off);
        pincode=findViewById(R.id.pincode);
        city=findViewById(R.id.city);
        area=findViewById(R.id.area);
        street=findViewById(R.id.street);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        others=findViewById(R.id.others);
        register=(Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Validate_community() && Validate_gender() && Validate_higher_secondary_school() && Validate_area() && Validate_city() && Validate_cutoff() && Validate_email() && Validate_name() && Validate_number() && Validate_parent_name() && Validate_pincode() && Validate_secondary_school() && Validate_street() && Validate_tenth_mark() && Validate_twelfth_Mark() ){
                    Intent i = new Intent(getApplicationContext(),NextActivitty.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Registration Unsuccessful",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean Validate_community(){
        String s=community.getEditText().getText().toString();
        s=s.toUpperCase();
        String[] sa=new String[]{
          "MBC","BC","OC","SC","ST","SCA"
        };
        for(int i=0;i<6;i++){
            if(s.equals(sa[i])){
                community.setError(null);
                community.setErrorEnabled(false);
                return true;
            }
        }
        community.setError("Enter a correct community");
        return false;
    }
    private boolean Validate_gender(){
        int tru=0;
        if(male.isChecked()){
            tru++;
        }
        if(female.isChecked()){
            tru++;
        }
        if(others.isChecked()){
            tru++;
        }
        if(tru==0){
            male.setError("Please Tick Your Gender ");
            female.setError("Please Tick Your Gender ");
            others.setError("Please Tick Your Gender");
        }
        if(tru==1){
            male.setError(null);
            female.setError(null);
            others.setError(null);
            return true;
        }
        else{
            male.setError("Tick Only one gender");
            female.setError("Tick Only one gender");
            others.setError("Tick Only one gender");
            return false;
        }
    }
    private boolean Validate_name() {
        String value = name.getEditText().getText().toString().trim(); // trim to avoid more spaces at end
        if (value.isEmpty()) {
            name.setError("Field cannot be empty");
            return false;
        }
        else
        {
            name.setError(null);
            name.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validate_parent_name() {
        String value = parent_name.getEditText().getText().toString().trim(); // trim to avoid more spaces at end
        if (value.isEmpty()) {
            parent_name.setError("Field cannot be empty");
            return false;
        }
        else
        {
            parent_name.setError(null);
            parent_name.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validate_number()
    {
        String val=number.getEditText().getText().toString().trim();
        String MobilePattern = "[0-9]{10}";

        if(val.isEmpty())
        {
            number.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(MobilePattern))
        {
            number.setError("Please enter a valid mobile number");
            return false;
        }
        else
        {
            number.setError(null);
            number.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validate_email()
    {
        String val=email.getEditText().getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty())
        {
            email.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(emailPattern))
        {
            email.setError("Please enter a valid email address");
            return false;
        }
        else
        {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validate_cutoff()
    {
        String val=cutoff.getEditText().getText().toString().trim();
        float cutoff1=Float.parseFloat(val);
        if(val.isEmpty())
        {
            cutoff.setError("Field cannot be empty");
            return false;
        }
        else if(cutoff1<=0.0 || cutoff1>=200.0)
        {
            cutoff.setError("Please enter a valid cutoff mark");
            return false;
        }
        else
        {
            cutoff.setError(null);
            cutoff.setErrorEnabled(false);
            return true;
        }
    }

    private boolean Validate_pincode()
    {
        String val=pincode.getEditText().getText().toString().trim();
        if(val.isEmpty() || val.charAt(0)=='0')
        {
            pincode.setError("Field cannot be empty");
            return false;
        }
        else if(val.length()!=6 ){
            pincode.setError("Enter a valid pincode");
            return false;
        }
        else
        {
            pincode.setError(null);
            pincode.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validate_city()
    {
        String val=city.getEditText().getText().toString().trim();
        if(val.isEmpty())
        {
            city.setError("Field cannot be empty");
            return false;
        }
        else
        {
            pincode.setError(null);
            pincode.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validate_area() {
        String val = city.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            area.setError("Field cannot be empty");
            return false;
        } else {
            area.setError(null);
            area.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validate_street() {
        String val = street.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            street.setError("Field cannot be empty");
            return false;
        }
        else
        {
            street.setError(null);
            street.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validate_tenth_mark() {
        String val = tenth_mark.getEditText().getText().toString().trim();
        int values=Integer.parseInt(val);
        if (val.isEmpty()) {
            tenth_mark.setError("Field cannot be empty");
            return false;
        }
        else if(values<0 || values>100)
        {
            tenth_mark.setError("Enter a valid mark");
            return false;
        }
        else
        {
            tenth_mark.setError(null);
            tenth_mark.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validate_higher_secondary_school() {
        String val = higher_secondary_school.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            higher_secondary_school.setError("Field cannot be empty");
            return false;
        }
        else
        {
            higher_secondary_school.setError(null);
            higher_secondary_school.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validate_secondary_school() {
        String val = secondary_school.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            secondary_school.setError("Field cannot be empty");
            return false;
        } else {
            secondary_school.setError(null);
            secondary_school.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validate_twelfth_Mark(){
        String val = twelth_mark.getEditText().getText().toString().trim();
        int values=Integer.parseInt(val);
        if (val.isEmpty()) {
            twelth_mark.setError("Field cannot be empty");
            return false;
        }
        else if(values<0 || values>100)
        {
            twelth_mark.setError("Enter a valid mark");
            return false;
        }
        else
        {
            twelth_mark.setError(null);
            twelth_mark.setErrorEnabled(false);
            return true;
        }
    }
}