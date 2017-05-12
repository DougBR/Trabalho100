import java.util.Vector;
import java.util.Iterator;
import java.util.Collections;

public abstract class Treinador {
	String nome;
	Vector pokemon = new Vector();
	Pokemon pokeAtivo;
	
	void atacar(){
		
	}
	void fugir (){
		System.out.println(nome + ": Eu não aguento mais!!");
	}
	public void apresenta(){
		Iterator itr = pokemon.iterator();
		System.out.println("Oi. Sou "+ nome + " e tenho os pokemons:");
		while(itr.hasNext()){
			Pokemon p = (Pokemon) itr.next();
	        System.out.print(p.getNome() + ", ");
		}
		System.out.println();
	}
	
	public void lancar(){
		System.out.println(nome + ": Vai " + ((Pokemon) pokemon.get(0)).getNome() +"!! Eu escolho você");
		}	
	public boolean trocar(){
		if(pokemon.size()==1){
			return false;
		}
		Collections.swap(pokemon, 0, 1);
		return true;
	}
	
	public void curar(){
		int CURAR = 10;
		pokeAtivo = (Pokemon)pokemon.get(0);
		pokeAtivo.setVida(pokeAtivo.getVida() + CURAR);
		if(pokeAtivo.getVida() > pokeAtivo.getVidaMax()){
			pokeAtivo.setVida(pokeAtivo.getVidaMax());
		}
		
		
		
	}
	
	
	public boolean pokeMorreu(){
		System.out.println(((Pokemon) pokemon.get(0)).getNome() + " está fora de combate" );
		pokemon.remove(0);
		if(pokemon.isEmpty()){
			System.out.println(nome + " não tem mais pokemons para lutar");
		}
		return pokemon.isEmpty();
	}
	
	public Pokemon getPokeAtivo(){
		if (pokemon.isEmpty())
			return null;
		return (Pokemon) pokemon.get(0);
	}
	
	
	public String getNome(){
		return nome;
	}
	
	abstract public Event agir(Treinador t1, Treinador t2, EventSet es, long tm);
		
	
}
