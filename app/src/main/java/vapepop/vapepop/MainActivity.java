package vapepop.vapepop;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos recycler
        final RecyclerView recyclerView = findViewById(R.id.recycler);
        //Tamaño fijo
        recyclerView.setHasFixedSize(true); //Para evitar errores
        //Establecemos layoutmanager
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        //Spinner con los tipos
        final Spinner spinnerTipo = findViewById(R.id.spinnerTipoPrin);
        String[] tipos = {"Todos los artículos", "Mod", "Atomizador", "Líquido"};
        spinnerTipo.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tipos));

        //Boton para ir a vender
        Button btnVender = findViewById(R.id.btnVender);
        btnVender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentarVender = new Intent(view.getContext(), AddProducto.class);
                startActivity(intentarVender);
            }
        });

        new GetDataFromFirebase().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        // Read from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("productos");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ArrayList<Producto> values = new ArrayList<>();
                EditText txtBusqueda = findViewById(R.id.txtBusqueda);
                Spinner spinnerTipo = findViewById(R.id.spinnerTipoPrin);

                for (DataSnapshot child: dataSnapshot.getChildren()) {
                    values.add(child.getValue(Producto.class));
                }


                recyclerView.setAdapter(new Adaptador(values));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("Failed to read value." + error.toException());
            }
        });


    }

    private class GetDataFromFirebase extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }

    }


}
