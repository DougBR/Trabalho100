

public class Cagao extends Treinador {

	public Cagao(){
		nome = "Cagao";
		pokemon[0] = new Charmander();
	}
	
	
	
	public void agir(long tm, EventSet es) {
		BattleControl bc = new BattleControl();
		es.add(bc.new Fugir(this, tm, es));
		es.add(null);
	}

}
