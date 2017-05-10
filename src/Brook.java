

public class Brook extends Treinador {

	public Brook(){
		nome = "Brook";
		pokemon.add(new Charmander());
	}

	public Event agir(Treinador t1, Treinador t2, EventSet es, long tm) {
		BattleControl bc = new BattleControl();
		return (bc.new Atacar(t1, t2, es, tm));
	}

}
