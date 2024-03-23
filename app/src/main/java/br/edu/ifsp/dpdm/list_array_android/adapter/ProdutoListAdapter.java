package br.edu.ifsp.dpdm.list_array_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.dpdm.list_array_android.R;
import br.edu.ifsp.dpdm.list_array_android.model.Produto;

public class ProdutoListAdapter extends BaseAdapter {
    private Context context;
    private List<Produto> produtoList;

    public ProdutoListAdapter(Context context, List<Produto> produtoList) {
        this.context = context;
        this.produtoList = produtoList;
    }

    public int getCount() {
        return produtoList.size();
    }

    public Object getItem(int position) {
        return produtoList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produto p = produtoList.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.produtos, null);

        TextView id = view.findViewById(R.id.txtIdProduto);
        id.setText(String.valueOf(++position));

        TextView rotulo = view.findViewById(R.id.txtRotulo);
        rotulo.setText(p.getRotulo());

        TextView valor = view.findViewById(R.id.txtValor);
        valor.setText(String.valueOf(p.getValor()));

        return view;
    }
}
