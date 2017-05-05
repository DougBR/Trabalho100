
public class Treinador {
	String nome;
	Pokemon[] pokemon;
	void trocar (){
		
	}
	void fugir (){
		System.out.println(nome + "fugiu!");
	}
	void apresenta(){
		System.out.println("Oi. Sou "+ nome + " e tenho os pokemons:");
		for (int i = 0; i < pokemon.length; i++)
			System.out.print(pokemon.toString());
	}
	
}
