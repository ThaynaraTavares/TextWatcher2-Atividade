package br.edu.ifpb.atividadeandroid.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.atividadeandroid.callback.BuscarPessoaCallBack;
import br.edu.ifpb.atividadeandroid.entidade.Pessoa;
import br.edu.ifpb.atividadeandroid.util.HttpService;
import br.edu.ifpb.atividadeandroid.util.Response;

public class BuscarNomeAsyncTask extends AsyncTask<Pessoa, Void, Response> {

    private BuscarPessoaCallBack buscarNomeCallBack;

    public BuscarNomeAsyncTask(BuscarPessoaCallBack buscarNomeCallBack) {

        this.buscarNomeCallBack = buscarNomeCallBack;
    }

    @Override
    protected Response doInBackground(Pessoa... pessoas) {

        Response response = null;

        Pessoa pessoa = pessoas[0];
        
        Gson gson = new Gson();
        
        Log.i("EditTextListener", "doInBackground (JSON): " + pessoa);

        try {

        	response = HttpService.sendJSONPostResquest("get-byname", gson.toJson(pessoa));

        } catch (IOException e) {

            Log.e("EditTextListener", e.getMessage());
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {

        int codeHttp = response.getStatusCodeHttp();

        Log.i("EditTextListener", "C�digo HTTP: " + codeHttp
                + " Conte�do: " + response.getContentValue());

        if (codeHttp != HttpURLConnection.HTTP_OK) {

            buscarNomeCallBack.errorBuscarNome(response.getContentValue());

        } else {

            Gson gson = new Gson();
            List<Pessoa> pessoas = gson.fromJson(response.getContentValue(),
                    new TypeToken<ArrayList<Pessoa>>(){}.getType());

            buscarNomeCallBack.errorBuscarNome(pessoas);
        }
    }
}
