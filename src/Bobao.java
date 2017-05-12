

public class Bobao extends Treinador {
	public Bobao(){
		nome = "Bobao";
		pokemon.add(new Magikarp());
		pokemon.addElement(new Pikachu());
	}
	
	public Event agir(Treinador t1, Treinador t2, EventSet es, long tm) {
		BattleControl bc = new BattleControl();
		return (bc.new Trocar(t1, es, tm));
	}

}
