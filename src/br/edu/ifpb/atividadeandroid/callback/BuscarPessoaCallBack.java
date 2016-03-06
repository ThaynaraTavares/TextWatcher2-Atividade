package br.edu.ifpb.atividadeandroid.callback;

import java.util.List;

import br.edu.ifpb.atividadeandroid.entidade.Pessoa;

public class BuscarPessoaCallBack {

	

	public interface BuscarPessoaCallBack {

	      void backBuscarNome(List<Pessoa> names);
          void errorBuscarNome(String error);
	}

	public void errorBuscarNome(String string) {
		// TODO Auto-generated method stub
		
	}

}
