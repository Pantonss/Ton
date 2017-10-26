package com.example.labdesenvolvimento.ton;

        import android.app.Activity;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.example.labdesenvolvimento.ton.controle.Cadastro;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends Activity implements View.OnClickListener {

    private EditText userEmail, userSenha;
    private Button logar;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmail = (EditText) findViewById(R.id.entrarEmail);
        userSenha  = (EditText) findViewById(R.id.entrarSenha);
        logar = (Button) findViewById(R.id.entrarEntrar);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        if(firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), Cadastro.class));
        }

        logar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = userEmail.getText().toString().trim();
        String senha = userSenha.getText().toString().trim();
        userLogin(email, senha);
    }

    private void userLogin(String email, String  senha) {
        //barra de progresso
        progressDialog.setMessage("Logando...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), Cadastro.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Usuário não encontrado...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}