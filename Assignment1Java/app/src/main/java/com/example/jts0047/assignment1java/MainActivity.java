package com.example.jts0047.assignment1java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mCelcius, mFahrenheit, mKilometer, mMile, mKilogram, mPound,
             mLitre, mGallon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Code for Celcius Fahrenheit conversions
        mCelcius = findViewById(R.id.CelciusText);
        mFahrenheit = findViewById(R.id.FahrenheitText);

        mCelcius.addTextChangedListener(celciusWatcher);
        mFahrenheit.addTextChangedListener(fahrenheitWatcher);

        // Code for km mile conversions
        mKilometer = findViewById(R.id.KmText);
        mMile = findViewById(R.id.MileText);

        mKilometer.addTextChangedListener(KmWatcher);
        mMile.addTextChangedListener(MileWatcher);

        // Code for kg pound conversion
        mKilogram = findViewById(R.id.KgText);
        mPound = findViewById(R.id.PoundText);

        mKilogram.addTextChangedListener(kgWatcher);
        mPound.addTextChangedListener(poundWatcher);

        //Code for litre gallon conversion
        mLitre = findViewById(R.id.litreText);
        mGallon = findViewById(R.id.gallonText);

        mLitre.addTextChangedListener(litreWatcher);
        mGallon.addTextChangedListener(gallonWatcher);

    }

    private final TextWatcher celciusWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mFahrenheit.removeTextChangedListener(fahrenheitWatcher);
            double celcius = 0.0, fahrenheit = 0.0;

            if (s.length() == 0) {
                mFahrenheit.setText("");
            }

            if (s.length() > 0) {
                if (s.length() == 1 && (int) s.toString().charAt(0) == 45){
                    //do nothing
                }
                else {
                    celcius = Double.parseDouble(s.toString());
                    fahrenheit = (celcius * 9.0 / 5.0) + 32.0;
                    mFahrenheit.setText(Double.toString(fahrenheit));
                }

            }
            mFahrenheit.addTextChangedListener(fahrenheitWatcher);

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher fahrenheitWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mCelcius.removeTextChangedListener(celciusWatcher);
            double celcius = 0.0, fahrenheit = 0.0;

            if (s.length() == 0) {
                mCelcius.setText("");
            }

            if (s.length() > 0) {
                if (s.length() == 1 && (int) s.toString().charAt(0) == 45){
                    //do nothing
                }
                else {
                    fahrenheit = Double.parseDouble(s.toString());
                    celcius = (fahrenheit - 32.0) * (5.0 / 9.0);
                    mCelcius.setText(Double.toString(celcius));
                }

            }
            mCelcius.addTextChangedListener(celciusWatcher);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher KmWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mMile.removeTextChangedListener(MileWatcher);
            double km = 0.0, mile = 0.0;

            if (s.length() == 0) {
                mMile.setText("");
            }

            if (s.length() > 0) {
                km = Double.parseDouble(s.toString());
                mile = km * 0.62137;

                mMile.setText(Double.toString(mile));
            }
            mMile.addTextChangedListener(MileWatcher);

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher MileWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mKilometer.removeTextChangedListener(KmWatcher);
            double km = 0.0, mile = 0.0;

            if (s.length() == 0) {
                mKilometer.setText("");
            }

            if (s.length() > 0) {
                mile = Double.parseDouble(s.toString());
                km = mile / 0.62137;

                mKilometer.setText(Double.toString(km));
            }
            mKilometer.addTextChangedListener(KmWatcher);


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher kgWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mPound.removeTextChangedListener(poundWatcher);
            double kg = 0.0, pound = 0.0;

            if (s.length() == 0) {
                mPound.setText("");
            }

            if (s.length() > 0) {
                kg = Double.parseDouble(s.toString());
                pound = kg * 2.20462262185 ;

                mPound.setText(Double.toString(pound));
            }
            mPound.addTextChangedListener(poundWatcher);


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher poundWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mKilogram.removeTextChangedListener(kgWatcher);
            double kg = 0.0, pound = 0.0;

            if (s.length() == 0) {
                mKilogram.setText("");
            }

            if (s.length() > 0) {
                pound = Double.parseDouble(s.toString());
                kg = pound * 0.45359237 ;

                mKilogram.setText(Double.toString(kg));
            }
            mKilogram.addTextChangedListener(kgWatcher);


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher litreWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mGallon.removeTextChangedListener(gallonWatcher);
            double litre = 0.0, gallon = 0.0;

            if (s.length() == 0) {
                mGallon.setText("");
            }

            if (s.length() > 0) {
                litre = Double.parseDouble(s.toString());
                gallon = litre / 3.78541 ;

                mGallon.setText(Double.toString(gallon));
            }
            mGallon.addTextChangedListener(gallonWatcher);


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final TextWatcher gallonWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mLitre.removeTextChangedListener(litreWatcher);
            double litre = 0.0, gallon = 0.0;

            if (s.length() == 0) {
                mLitre.setText("");
            }

            if (s.length() > 0) {
                gallon = Double.parseDouble(s.toString());
                litre = gallon * 3.78541 ;

                mLitre.setText(Double.toString(litre));
            }
            mLitre.addTextChangedListener(litreWatcher);

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

