
public class Curador extends Treinador {
	public Curador(){
		nome = "Curador";
		pokemon.add(new Magikarp());
	}
	@Override
	public Event agir(Treinador t1, Treinador t2, EventSet es, long tm) {
		BattleControl bc = new BattleControl();
		return (bc.new Curar(t1, es, tm));
	}

}
