import java.util.Vector;

public class Pokemon {
	String nome;
	int vida, vidaMax;
	Vector<Ataque> ataques = new Vector<Ataque> ();
	

	public Ataque getAtaque(int n){
		return ataques.get(n);
	}
	
	public int getNAtaque(){
		return ataques.size();
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getVida(){
		return vida;
	}
	public int getVidaMax(){
		return vidaMax;
	}
	
	public void setVida(int n){
		if(n<0)
			vida = 0;
		else
			vida = n;
	}
}
