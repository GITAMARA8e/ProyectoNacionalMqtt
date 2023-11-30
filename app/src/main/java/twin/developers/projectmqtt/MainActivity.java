package twin.developers.projectmqtt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    Button calcular;
    EditText Verduras, Hectarea;

    Button Limpiar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Verduras = findViewById(R.id.txtverduras);
        Hectarea = findViewById(R.id.txthectarea);
        calcular = findViewById(R.id.btncalcular);
        Limpiar = findViewById(R.id.btnLimpiar);


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        segunda_pantalla.class);

                int VerdurasStr = Integer.parseInt(Verduras.getText().toString());
                int HectareaStr = Integer.parseInt(Hectarea.getText().toString());
                int multipliacion = VerdurasStr * HectareaStr;
                String multiplicacion = String.valueOf(multipliacion);
                intent.putExtra("resultado",multiplicacion.toString());
                startActivity(intent);



            }
        });


        Limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                int VerdurasStr = Integer.parseInt(Verduras.getText().toString());
                int HectareaStr = Integer.parseInt(Hectarea.getText().toString());
                String Limpiar = " ";
                intent.putExtra("Limpiar",Limpiar.toString());
                startActivity(intent);
            }
        });

    }

}