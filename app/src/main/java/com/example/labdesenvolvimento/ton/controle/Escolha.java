package com.example.labdesenvolvimento.ton.controle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.labdesenvolvimento.ton.MainActivity;
import com.example.labdesenvolvimento.ton.R;

/**
 * Created by Lab. Desenvolvimento on 27/10/2017.
 */

public class Escolha extends Activity implements View.OnClickListener{
    private Button passarEntrar, passarCadastro;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_entrar);
        passarCadastro = (Button) findViewById(R.id.menuCadastrar);
        passarEntrar = (Button) findViewById(R.id.menuEntrar);
    }
    @Override
    public void onClick(View v) {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(it);
    }
}
