

public class BattleControl extends Controller {
	
	private class batalhar extends Event {
		Treinador t1, t2;
		long tm = System.currentTimeMillis();
		
		public batalhar(Treinador t1, Treinador t2, long tm){
			super(tm);
			this.t1 = t1;
			this.t2 = t2;
		}
		
		public void action() {
			addEvent(new apresentar(t1, tm));
			addEvent(new apresentar(t2, tm+1000));
		}

		@Override
		public String description() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	private class apresentar extends Event{
		Treinador t;
		public apresentar(Treinador t1, long tm){
			super(tm);
			t = t1;
		}
		
		public void action(){
			t.apresenta();
		}

		@Override
		public String description() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		BattleControl bc = new BattleControl();
		long tm = System.currentTimeMillis();
		Treinador t1 = new Ash();
		Treinador t2 = new Ash();
		bc.addEvent(bc.new batalhar(t1, t2, tm));
		bc.run();
	}
	
}
