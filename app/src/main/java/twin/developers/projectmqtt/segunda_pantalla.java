package twin.developers.projectmqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class segunda_pantalla extends AppCompatActivity {
    private Mqtt mqttManager;
    Button guardar, volver, enviar;
    TextView mensaje;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        mensaje = findViewById(R.id.txtMensaje);
        String resultado = getIntent().getStringExtra("resultado");
        mensaje.setText(resultado);
        volver = findViewById(R.id.Volver);
        enviar = findViewById(R.id.Enviar);
        guardar = findViewById(R.id.Guardar);
        mqttManager = new Mqtt(getApplicationContext());
        mqttManager.connectToMqttBroker();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference.child("Total").
                        setValue(mensaje.getText().toString());

            }

        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(intent);

            }
        });
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {mqttManager.publishMessage(mensaje.getText().toString());}
        });

    }
   }
