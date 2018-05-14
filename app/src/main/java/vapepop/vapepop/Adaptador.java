package vapepop.vapepop;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;


class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private ArrayList<Producto> values;
    Adaptador(ArrayList<Producto> values) {
        this.values = values;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.vista,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(values.get(position).getDescripcion());
        holder.precio.setText(values.get(position).getPrecioventa()+"€");
        holder.provincia.setText(values.get(position).getProvincia());


    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre, precio, provincia;
        ViewHolder(View itemView) {
            super(itemView);
            nombre =  itemView.findViewById(R.id.txtDescrip);
            precio = itemView.findViewById(R.id.txtPrecio);
            provincia = itemView.findViewById(R.id.txtProv);
        }
    }
}