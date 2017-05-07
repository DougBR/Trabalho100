

public class Cagao extends Treinador {

	public Cagao(){
		nome = "Cagao";
		pokemon[0] = new Magikarp();;
	}
	
	
	
	public void agir(Treinador t1, Treinador t2, EventSet es, long tm) {
		BattleControl bc = new BattleControl();
		//es.add(bc.new Fugir(this, tm, es));
		es.add(bc.new Atacar(t1, t2, es, tm));
	}

}
