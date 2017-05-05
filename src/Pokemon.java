public class Pokemon {
	String nome;
	int vida;
	Ataque ataques[] = new Ataque[3];
	
	public Evento atacar(){
		return ataques[1];
	}
}
