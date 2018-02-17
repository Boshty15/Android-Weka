package com.example.bostjan.projekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.rules.JRip;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

import com.example.lib.Igralec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText edStGolov;
    EditText edStVsehStrelov;
    Button btt;
    AppMy app;
    Igralec igralec;
    Spinner spinner;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edStGolov = (EditText)findViewById(R.id.editTextStGolov);
        edStVsehStrelov = (EditText)findViewById(R.id.editTextSTStrelov);
        app = (AppMy)getApplication();
        btt = (Button)findViewById(R.id.buttonpotrdi);
        textView = (TextView)findViewById(R.id.textViewRezultat);

        spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pozition, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        igralec = app.getIgralec();

        edStGolov.setText(igralec.getTekme().get(0).getSteliNaGol() + "");
        edStVsehStrelov.setText(igralec.getTekme().get(0).getVsiStreli() + "");


    }
    public  void onClikPotrdi(View v){
        InputStream is = null;
        try {
            Integer index = spinner.getSelectedItemPosition();
            String[] pos = getResources().getStringArray(R.array.kratice);

            is = getBaseContext().getAssets().open("RokometniIgralci.arff");
            if(is != null){
                Log.i("DELAAAA","To je to!");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            Instances podatki = new Instances(reader);
            reader.close();
            podatki.setClassIndex(podatki.numAttributes() - 1);
            int number_of_atributes=4;
            FastVector pozition = new FastVector(6);
            pozition.addElement("LK");
            pozition.addElement("LZ");
            pozition.addElement("SZ");
            pozition.addElement("DZ");
            pozition.addElement("DK");
            pozition.addElement("PV");
            Attribute attl = new Attribute("pozition", pozition);

            Attribute att2 = new Attribute("StStrelov");
            Attribute att3 = new AttrWibute("StGolov");

            FastVector Class = new FastVector(3);
            Class.addElement("Slabo");
            Class.addElement("Povprecno");
            Class.addElement("Odlicno");
            Attribute attClass = new Attribute("Class", Class);

            FastVector wekaAtt = new FastVector(number_of_atributes);
            wekaAtt.addElement(attl);
            wekaAtt.addElement(att2);
            wekaAtt.addElement(att3);
            wekaAtt.addElement(attClass);

            Instances trainingSet = new Instances("Rel", wekaAtt, 1);
            trainingSet.setClassIndex(number_of_atributes-1);

            Instance example = new DenseInstance(number_of_atributes);
            example.setValue(attl, pos[index]);
            example.setValue(att2, Integer.parseInt(edStVsehStrelov.getText().toString()));
            example.setValue(att3, Integer.parseInt(edStGolov.getText().toString()));
            //example.setValue(attClass, "Odlicno");

            trainingSet.add(example);
            JRip tree = new JRip();
            tree.buildClassifier(podatki);
            Double value = tree.classifyInstance(trainingSet.instance(0));
            trainingSet.instance(0).setClassValue(value);
            Double doubleClassValue = trainingSet.instance(0).classValue();
            Integer classValue = doubleClassValue.intValue();
            textView.setText("Rezultat: \n\nIgralni položaj: " + pos[index] + "\nŠtevilo golov:" +Integer.parseInt(edStGolov.getText().toString()) + "\nŠtevilo strelov: " + Integer.parseInt(edStVsehStrelov.getText().toString()) + "\nOdločitev: " + trainingSet.classAttribute().value(classValue) );


        } catch (IOException e) {
            e.printStackTrace();
            Log.i("RTTOT","IO " + e);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("RTTOT", "IO " + e);
        }
    }
}
,