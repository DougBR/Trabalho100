
 public abstract class Treinador {
	String nome;
	Pokemon[] pokemon = new Pokemon[5];
	Pokemon pokeAtivo;
	void trocar (){
		
	}
	void atacar(){
		
	}
	void fugir (){
		System.out.println(nome + ": Eu não aguento mais!!");
	}
	public void apresenta(){
		System.out.println("Oi. Sou "+ nome + " e tenho os pokemons:");
		for (int i = 0; pokemon[i] != null; i++)
			System.out.print(pokemon[i].getNome() + "\n");
	}
	
	public void lancar(){
		int i = 0;
		for (i = 0; pokemon[i] != null; i++)
			pokeAtivo = pokemon[i];
		if(i==0){
			//Morreu
		}	
	}
	
	public Pokemon getPokeAtivo(){
		return pokeAtivo;
	}
	
	public String getNome(){
		return nome;
	}
	
	abstract public void agir(long tm, EventSet es);
		
	
}
