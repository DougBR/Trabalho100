
public class Ash extends Treinador {
	public Ash(){
		nome = "Ash";
		pokemon[0] = new Pikachu();
	}
	
	public void agir(long tm, EventSet es){
		BattleControl bc = new BattleControl();
		es.add(bc.new Fugir(this, tm, es));
		es.add(null);
	}
}
