package vapepop.vapepop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddProducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_producto);

        //Cargamos datos en los spinners
        Spinner spinnerTipo = findViewById(R.id.spinnerTipo);
        String[] tipos = {"Elige un tipo de artículo", "Mod", "Atomizador", "Líquido"};
        spinnerTipo.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tipos));

        Spinner spinnerProvincias = findViewById(R.id.spinnerProvincias);
        String[] provincias = {"Elige tu provincia", "Alava","Albacete","Alicante","Almería","Asturias","Avila","Badajoz","Barcelona","Burgos","Cáceres",
                "Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","La Coruña","Cuenca","Gerona","Granada","Guadalajara",
                "Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra",
                "Orense","Palencia","Las Palmas","Pontevedra","La Rioja","Salamanca","Segovia","Sevilla","Soria","Tarragona",
                "Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};
        spinnerProvincias.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, provincias));




        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentarVolver = new Intent(view.getContext(), MainActivity.class);
                startActivity(intentarVolver);
            }
        });

        //Creamos referencia DB


        Button btnPublicar = findViewById(R.id.btnPublicar);
        btnPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase basedatos = FirebaseDatabase.getInstance();
                DatabaseReference ref = basedatos.getReference();

                TextView vnombre = findViewById(R.id.txtNombre);
                String nombre = (String) vnombre.getText().toString();
                TextView vprecio = findViewById(R.id.txtPrecio);
                String precio = (String) vprecio.getText().toString();
                Spinner vspinnerTipo = findViewById(R.id.spinnerTipo);
                String tipo = vspinnerTipo.getSelectedItem().toString();
                Spinner vspinnerProvincias = findViewById(R.id.spinnerProvincias);
                String provincia = vspinnerProvincias.getSelectedItem().toString();
                RadioButton vmano = findViewById(R.id.radioMano);
                Boolean mano = vmano.isChecked();
                TextView vmail = findViewById(R.id.txtMail);
                String mail = (String) vmail.getText().toString();
                TextView vwhatsapp = findViewById(R.id.txtWhatsapp);
                String whatsapp = (String) vwhatsapp.getText().toString();

                String envio;
                if (mano) {
                    envio = "En mano";
                } else {
                    envio = "En mano y envio";
                }

                if (nombre.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Debe especificar un nombre", Toast.LENGTH_SHORT).show();
                } else if (precio.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Debe especificar un precio", Toast.LENGTH_SHORT).show();
                } else if (tipo.startsWith("Elige")) {
                    Toast.makeText(getApplicationContext(), "Debe especificar un tipo", Toast.LENGTH_SHORT).show();
                } else if (provincia.startsWith("Elige")) {
                    Toast.makeText(getApplicationContext(), "Debe especificar una provincia", Toast.LENGTH_SHORT).show();
                } else if (mail.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Debe especificar un mail", Toast.LENGTH_SHORT).show();
                } else if (whatsapp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Debe especificar un Whatsapp", Toast.LENGTH_SHORT).show();
                } else {
                    Date date = new Date();
                    DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
                    Producto producto = new Producto(nombre, tipo, precio, envio, provincia, mail, whatsapp, fecha.format(date));
                    ref.child("productos").push().setValue(producto);
                    Toast.makeText(getApplicationContext(), "Su anuncio se ha creado satisfactoriamente", Toast.LENGTH_LONG).show();
                    Intent intentarPrincipal = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intentarPrincipal);
                }






            }
        });


    }
}
