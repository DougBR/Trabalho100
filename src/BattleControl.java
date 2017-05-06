

public class BattleControl extends Controller {
	long TEMPO = 2000;
	public class Batalhar extends Event {
		Treinador t1, t2;
		long tm = System.currentTimeMillis();
		
		public Batalhar(Treinador t1, Treinador t2, long tm){
			super(tm);
			this.t1 = t1;
			this.t2 = t2;
		}
		
		public void action() {
			addEvent(new Apresentar(t1, tm + TEMPO));
			addEvent(new Apresentar(t2, tm+2*TEMPO));
			addEvent(new Lancar(t1, tm+3*TEMPO));
			addEvent(new Lancar(t2, tm+4*TEMPO));
			t1.agir(tm+6*TEMPO, es);
			t2.agir(tm+7*TEMPO, es);
			
		}

		public String description() {
			// TODO Auto-generated method stub
			return "E começa a batalha";
		}
		
	}
	
	private class Apresentar extends Event{
		Treinador t;
		public Apresentar(Treinador t1, long tm){
			super(tm);
			t = t1;
		}
		
		public void action(){
			t.apresenta();
		}

		public String description() {
			// TODO Auto-generated method stub
			return "Vamos batalhar!!";
		}
		
	}
	
	private class Lancar extends Event{
		Treinador t;
		public Lancar(Treinador t1, long tm){
			super(tm);
			t = t1;
		}
		
		public void action() {
			t.lancar();
		}

		public String description() {
			
			return t.getNome() + ": Vai " + t.getPokeAtivo().getNome() +"!! Eu escolho você";
		}
	}
	
	public class Fugir extends Event{
		Treinador t;
		EventSet es;
		public Fugir(Treinador t1, long tm, EventSet es){
			super(tm);
			t = t1;
			this.es = es;
		}
		public void action() {
			t.fugir();
			es.add(null);
		}

		@Override
		public String description() {
			return t.getNome()+ " foge da batalha";
		}
		
	}
	
	public static void main(String[] args) {
		BattleControl bc = new BattleControl();
		long tm = System.currentTimeMillis();
		Treinador t1 = new Ash();
		Treinador t2 = new Cagao();
		bc.addEvent(bc.new Batalhar(t1, t2, tm));
		bc.run();
		System.out.println("Fim de batalha");
	}
	
}
