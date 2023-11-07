package ma.projet.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ma.projet.R;
import ma.projet.entities.Filiere;

public class FiliereAdapter extends BaseAdapter {
    private List<Filiere> filieres;
    private LayoutInflater inflater;

    public FiliereAdapter(List<Filiere> filieres, Activity activity) {
        this.filieres = filieres;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public void updatefilieresList(List<Filiere> newfilieres) {
        filieres.clear();
        filieres.addAll(newfilieres);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return filieres.size();
    }

    @Override
    public Object getItem(int position) {
        return filieres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return filieres.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.filiere_item, null);

        TextView id = convertView.findViewById(R.id.idFiliereItem);
        TextView code = convertView.findViewById(R.id.idFiliereCodeItem);
        TextView libelle = convertView.findViewById(R.id.idFiliereNomItem);

        id.setText(filieres.get(position).getId()+"");
        code.setText(filieres.get(position).getCode());
        libelle.setText(filieres.get(position).getNom());
        return convertView;
    }
}
