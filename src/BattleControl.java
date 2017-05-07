

public class BattleControl extends Controller {
	long TEMPO = 1000;
	public class Batalhar extends Event {
		Treinador t1, t2;
		long tm = System.currentTimeMillis();
		
		public Batalhar(Treinador t1, Treinador t2, long tm){
			super(tm);
			this.t1 = t1;
			this.t2 = t2;
		}
		
		public void action() {
			int cont = 1;
			addEvent(new Apresentar(t1, tm + cont * TEMPO)); cont++;
			addEvent(new Apresentar(t2, tm+ cont*TEMPO)); cont++;
			addEvent(new Lancar(t1, tm+cont*TEMPO)); cont++;
			addEvent(new Lancar(t2, tm+cont*TEMPO)); cont++;
			t1.agir(t1, t2, es, tm+cont*TEMPO); cont++;
			t2.agir(t2, t2, es, tm+cont*TEMPO); cont++;
			
			
			
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
		public String description() {
			return t.getNome()+ " foge da batalha";
		}
	}
	
	public class Atacar extends Event{
		Treinador t1, t2;
		EventSet es;
		int nAtaque = 0;
		long tm;
		public Atacar(Treinador t1, Treinador t2, EventSet es, long tm){
			super(tm);
			this.tm = tm;
			this.t1 = t1;
			this.t2 = t2;
			this.es = es;
		}
		public void action() {
			t2.getPokeAtivo().setVida(	t2.getPokeAtivo().getVida() - 
										t1.getPokeAtivo().getAtaque(nAtaque).getForca());
			System.out.println(	t1.getNome() + 	
								": " +
								t1.getPokeAtivo().getNome() + 
								", " + 
								t1.getPokeAtivo().getAtaque(nAtaque).getNome());
			System.out.println(	t2.getPokeAtivo().getNome() + 
								" leva "+
								t1.getPokeAtivo().getAtaque(nAtaque).getForca() + 
								" de dano");
			if(t2.getPokeAtivo().getVida() == 0){
				es.add(new Lancar(t1, tm + TEMPO));
			}
		}

		public String description() {
			return  t2.getPokeAtivo().getNome() + " está com " +
					String.valueOf(t2.getPokeAtivo().getVida()) + " de vida";
		}
	}
	
	/*
	public class Agir extends Event{
		Treinador t1, t2;
		EventSet es;
		int cont = 1;
		long tm;
		public Agir(Treinador t1, Treinador t2, EventSet es, long tm){
			super(tm);
			this.tm = tm;
			this.t1 = t1;
			this.t2 = t2;
			this.es = es;
		}
		public void action() {
			do {
				t1.agir(t1, t2, es, tm+cont*TEMPO); cont++;
				t2.agir(t2, t1, es, tm+cont*TEMPO); cont++;
			} while ((t1.getPokeAtivo() != null) && (t2.getPokeAtivo() != null));
			
		}

		public String description() {
			// TODO Auto-generated method stub
			return null;
		}
		
	} */
	
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
