public class Pokemon {
	String nome;
	int vida;
	Ataque ataques[] = new Ataque[3];
	
	public Event atacar(){
		return ataques[1];
	}
}
