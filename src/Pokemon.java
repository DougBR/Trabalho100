public class Pokemon {
	String nome;
	int vida;
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
	
	public void setVida(int n){
		vida = n;
	}
}
