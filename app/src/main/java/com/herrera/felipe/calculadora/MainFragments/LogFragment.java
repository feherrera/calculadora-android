package com.herrera.felipe.calculadora.MainFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.herrera.felipe.calculadora.Operadores;
import com.herrera.felipe.calculadora.R;
import static com.herrera.felipe.calculadora.Operadores.*;

/**
 * Created by Felipe on 14-08-2017.
 */

public class LogFragment extends Fragment {

    private View rootView;
    private String num1 = "0";
    private String operador = "";
    private String num2 = "0";
    private boolean resultado = true; //si lo escrito es un resultado se sobreescribe

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.main_log, container, false);
        return rootView;
    }

    //region Operaciones aritméticas
    /**
     * Suma dos números
     * @param n1 primer número
     * @param n2 segundo número
     * @return string con la suma de los números
     */
    private String sumar(String n1, String n2){
        return "" + (new Integer(num1) + new Integer(num2));
    }

    /**
     * Resta dos números
     * @param n1 primer número
     * @param n2 segundo número
     * @return string con la resta de los números
     */
    private String restar(String n1, String n2){
        return "" + (new Integer(num1) - new Integer(num2));
    }

    /**
     * Multiplica dos números
     * @param n1 primer número
     * @param n2 segundo número
     * @return string con la multiplicación de los números
     */
    private String multiplicar(String n1, String n2){
        return "" + (new Integer(num1) * new Integer(num2));
    }

    /**
     * Divide dos números. No valida que n2 no sea 0.
     * @param n1 primer número
     * @param n2 segundo número, debe ser distinto a 0
     * @return string con la división de los números
     */
    private String dividir(String n1, String n2){
        return "" + (new Integer(num1) / new Integer(num2));
    }

    /**
     * Divide dos números. No valida que n2 no sea 0.
     * @param n1 primer número
     * @param n2 segundo número, debe ser distinto a 0
     * @return string con la división de los números
     */
    private String exponenciar(String n1, String n2){
        return "" + Math.pow(new Integer(num1), new Integer(num2));
    }
    //endregion

    //region Actualizar vistas
    private void textView1(){
        TextView t1 = (TextView) rootView.findViewById(R.id.num1);
        t1.setText(num1);
    }

    private void textView2(){
        TextView t2 = (TextView) rootView.findViewById(R.id.num2);
        t2.setText(operador + " " + num2);
    }
    //endregion

    /**
     * Método que vueelve todo a cero
     * @return Confirmación de modificación
     */
    public boolean borrarTodo(){
        num1 = "0";
        num2 = "0";
        operador = "";
        resultado = true;

        textView1();
        textView2();
        return true;
    }

    /**
     * Append n to num1 or num2
     * @param n dígito ingresado
     * @return Confirmación
     */
    public boolean ligarNumero(String n){
        if (operador.equals("")){
            num1 = (resultado) ? n : num1 + n;
            textView1();
        }
        else{
            num2 = (num2.equals("0")) ? n : num2 + n;
            textView2();
        }
        resultado = false;
        return true;
    }

    /**
     * Borra el último número ingresado
     * Si el último elemento fue un operador, no hace nada
     * @return true: elemento borrado, false: no hace nada
     */
    public boolean borrarUltimo() {
        if (operador.equals("")) {
            if (resultado) return false;

            if (num1.length() == 1) {
                num1 = "0";
                resultado = true;
            } else {
                num1 = num1.substring(0, num1.length() - 1);
            }
            textView1();
            return true;
        } else {
            if (num2.equals("0")) {
                operador = "";
                resultado = true;
                return false;
            }
            num2 = (num2.length() == 1) ? "0" : num2.substring(0, num2.length() - 1);
            textView2();
            return true;
        }
    }

    /**
     * Calcula el resultado de la operación existente
     * @return true: operación realizada, false: operación inexistente
     */
    public boolean result(){
        if (operador.equals("")) return false;

        if( !doOp() ) return false;
        operador = "";

        textView1();
        textView2();
        return true;
    }

    /**
     * Determina la operación a realizar y la ejecuta
     * @return Confirmación de ejecución, false: 0 div
     */
    private boolean doOp(){
        switch (operador){
            case Operadores.OPERADOR_SUMA:
                num1 = sumar(num1, num2);
                break;
            case Operadores.OPERADOR_RESTA:
                num1 = restar(num1, num2);
                break;
            case Operadores.OPERADOR_POR:
                num1 = multiplicar(num1, num2);
                break;
            case Operadores.OPERADOR_DIV:
                if (num2.equals("0")) return false;
                num1 = dividir(num1, num2);
                break;
            case Operadores.OPERADOR_EXP:
                num1 = exponenciar(num1, num2);
                break;
        }
        num2 = "0";
        resultado = true;
        return true;
    }

    /**
     * Método a llamar al presionar un operador aritmético (+,-,x,/, Exp)
     * @param op operador
     * @return Confirmación del cambio
     */
    public boolean switchOp(String op){
        if (!num2.equals("0"))
            if (!doOp()) return false;
        this.operador = op;
        textView1();
        textView2();
        return true;
    }
}
