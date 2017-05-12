public class Pokemon {
	String nome;
	int vida, vidaMax;
	Ataque ataques[] = new Ataque[3];
	

	public Ataque getAtaque(int n){
		return ataques[n];
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
