package br.edu.ifsp.dpdm.list_array_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dpdm.list_array_android.adapter.ProdutoListAdapter;
import br.edu.ifsp.dpdm.list_array_android.model.Produto;

public class MainActivity extends AppCompatActivity {

    private Produto produto;
    private List<Produto> produtoList;

    private EditText edId;
    private EditText edRotulo;
    private EditText edValor;

    private ListView lvProdutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edRotulo = findViewById(R.id.edRotulo);
        edValor = findViewById(R.id.edValor);

        lvProdutos = findViewById(R.id.lvProdutos);
        lvProdutos.setOnItemClickListener(selecionaProduto);
        produtoList = new ArrayList<Produto>();
    }

    public void salvar(View v) {
        produto = new Produto();
        produto.setRotulo(edRotulo.getText().toString());
        produto.setValor(Double.parseDouble(edValor.getText().toString()));
        produtoList.add(produto);
        atualizarLista();
        //limparDados();
        exibirMensagem("Produto cadastrado com sucesso!");
    }

    private void exibirMensagem(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    private void limparDados() {
        edRotulo.setText("");
        edRotulo.requestFocus();
        edValor.setText(0);
    }

    private void atualizarLista() {
        ProdutoListAdapter pla = new ProdutoListAdapter(getApplicationContext(),
                produtoList);
        lvProdutos.setAdapter(pla);
    }

    private AdapterView.OnItemClickListener selecionaProduto = new AdapterView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long id) {
            Produto produto = produtoList.get(pos);
            preecherDados(produto);

        }

        private void preecherDados(Produto produto) {
            edId.setText(String.valueOf(produto.getId()));
            edRotulo.setText(String.valueOf(produto.getRotulo()));
            edValor.setText(String.valueOf(produto.getValor()));
        }
    };
}