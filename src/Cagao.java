

public class Cagao extends Treinador {

	public Cagao(){
		nome = "Cagao";
		pokemon.add(new Magikarp());
	}
	
	
	
	public Event agir(Treinador t1, Treinador t2, EventSet es, long tm) {
		BattleControl bc = new BattleControl();
		return (bc.new Fugir(this, tm, es));
	}

}
