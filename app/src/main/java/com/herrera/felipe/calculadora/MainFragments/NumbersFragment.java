package com.herrera.felipe.calculadora.MainFragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.herrera.felipe.calculadora.R;

/**
 * Created by Felipe on 14-08-2017.
 */

public class NumbersFragment extends Fragment implements View.OnClickListener{

    private View rootView;
    //region Buttons
    private Button bPoint;
    private Button b0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button bEqual;
    private Button bSuma;
    private Button bRest;
    private Button bMult;
    private Button bDiv;
    private Button bPow;
    private Button bInc;
    private Button bCE;
    private Button bAC;
    //endregion
    private CalcKeysListener calcListener;

    Activity parent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.main_numbers, container, false);

        //region Assign buttons
        b0 = (Button) rootView.findViewById(R.id.b0);
        b1 = (Button) rootView.findViewById(R.id.b1);
        b2 = (Button) rootView.findViewById(R.id.b2);
        b3 = (Button) rootView.findViewById(R.id.b3);
        b4 = (Button) rootView.findViewById(R.id.b4);
        b5 = (Button) rootView.findViewById(R.id.b5);
        b6 = (Button) rootView.findViewById(R.id.b6);
        b7 = (Button) rootView.findViewById(R.id.b7);
        b8 = (Button) rootView.findViewById(R.id.b8);
        b9 = (Button) rootView.findViewById(R.id.b9);
        bPoint = (Button) rootView.findViewById(R.id.bPunto);
        bEqual = (Button) rootView.findViewById(R.id.bIgual);
        bSuma = (Button) rootView.findViewById(R.id.bMas);
        bRest = (Button) rootView.findViewById(R.id.bMenos);
        bMult = (Button) rootView.findViewById(R.id.bPor);
        bDiv = (Button) rootView.findViewById(R.id.bDiv);
        bPow = (Button) rootView.findViewById(R.id.bPow);
        bInc = (Button) rootView.findViewById(R.id.bInc);
        bCE = (Button) rootView.findViewById(R.id.bCE);
        bAC = (Button) rootView.findViewById(R.id.bAC);
        //endregion

        //region Set ClickListener to buttons
        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bPoint.setOnClickListener(this);
        bEqual.setOnClickListener(this);
        bSuma.setOnClickListener(this);
        bRest.setOnClickListener(this);
        bMult.setOnClickListener(this);
        bDiv.setOnClickListener(this);
        bPow.setOnClickListener(this);
        bInc.setOnClickListener(this);
        bCE.setOnClickListener(this);
        bAC.setOnClickListener(this);
        //endregion
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.calcListener = (CalcKeysListener) getActivity();
    }

    @Override
    public void onClick(View v) {
        this.calcListener.onKeyPressed( ((Button)v).getText().toString() );
    }

    public interface CalcKeysListener {

        /**
         * Método a llamar al presionar un operador o número
         * @param op Descriptor de operador
         */
        public void onKeyPressed(String op);
    }
}
