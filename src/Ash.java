
public class Ash extends Treinador {
	public Ash(){
		nome = "Ash";
		pokemon[0] = new Pikachu();
	}
	
	public void agir(Treinador t1, Treinador t2, EventSet es, long tm){
		BattleControl bc = new BattleControl();
		es.add(bc.new Atacar(t1, t2, es, tm));
	}
}
