package com.herrera.felipe.calculadora.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.herrera.felipe.calculadora.MainFragments.LogFragment;
import com.herrera.felipe.calculadora.MainFragments.NumbersFragment;
import com.herrera.felipe.calculadora.R;

import static com.herrera.felipe.calculadora.Operadores.*;

public class MainActivity extends AppCompatActivity implements NumbersFragment.CalcKeysListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onKeyPressed(String op) {
        LogFragment LF = (LogFragment) getFragmentManager().findFragmentById(R.id.main_log);
        switch (op){
            case OPERADOR_AC:
                LF.borrarTodo();
                break;
            case OPERADOR_CE:
                LF.borrarUltimo();
                break;
            case OPERADOR_SUMA:
            case OPERADOR_RESTA:
            case OPERADOR_POR:
            case OPERADOR_DIV:
            case OPERADOR_EXP:
                LF.switchOp(op);
                break;
            case OPERADOR_IGUAL:
                LF.result();
                break;
            case OPERADOR_INC:
                break;
            case OPERADOR_PUNTO:
                break;
            default:
                LF.ligarNumero(op);
                break;
        }
    }
}
