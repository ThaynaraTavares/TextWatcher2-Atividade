package br.edu.ifpb.atividadeandroid.entidade;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Pessoa implements Serializable {
	
	  public Pessoa{
		  
	  }
    
	  public Pessoa (String nome, String descricao) {
	        this.nome = nome;
	        this.descricao = descricao;
	    }
	  
	  @SerializedName("id")
	    private int id;

	    @SerializedName("fullName")
	    private String nome;

	    @SerializedName("email")
	    private String email;

	    @SerializedName("typeInscription")
	    private String descricao;

	    @SerializedName("isDelivered")
	    private boolean entregue;
	    
	public CharSequence getDescricao() {
		// TODO Auto-generated method stub
		return descricao;
	}
	 public void setDescricao(String descricao) {
	        this.descricao = descricao;
	    }

	public boolean isEntregue() {
		// TODO Auto-generated method stub
		return entregue;
	}
	 public void setEntregue(boolean entregue) {
	        this.entregue = entregue;
	    }

	public CharSequence getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	public void setEmail(String email) {
        this.email = email;
    }
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	 public void setId(int id) {
	        this.id = id;
	    }

	public CharSequence getNome() {
		// TODO Auto-generated method stub
		return nome;
	}
	public void setNome(String nome) {
        this.nome = nome;
    }
	@Override
    public String toString() {
        return "[fullName: " + nome + "; email: " + email + "]";
    }
	

}
