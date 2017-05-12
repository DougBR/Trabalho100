
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
			addEvent(new Agir(t1, t2, es, tm+cont*TEMPO)); cont++;
			
		}

		public String description() {
			return "E come�a a batalha";
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
			return null;
		}
	}

	public class Fugir extends Event{
		Treinador t1, t2;
		EventSet es;
		long tm;
		public Fugir(Treinador t1, Treinador t2, long tm, EventSet es){
			super(tm);
			this.tm = tm;
			this.t1 = t1;
			this.t2 = t2;
			this.es = es;
		}
		public void action() {
			t1.fugir();
			es.clearAll();
			es.add(new Fim(t2, es, tm + TEMPO)); // esse Evento � retirado pelo Controler ap�s a execu��o do Evento atual
			es.add(new Fim(t2, es, tm + TEMPO));
		}
		public String description() {
			return t1.getNome()+ " foge da batalha";
		}
	}
	
	public class Atacar extends Event{
		Treinador t1, t2;
		EventSet es;
		int nAtaque;
		long tm;
		public Atacar(Treinador t1, Treinador t2, int nAtaque, EventSet es, long tm){
			super(tm);
			this.tm = tm;
			this.t1 = t1;
			this.t2 = t2;
			this.es = es;
			this.nAtaque = nAtaque%t1.getNAtaque();
			
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
			System.out.println(	t2.getPokeAtivo().getNome() + " est� com " +
								String.valueOf(t2.getPokeAtivo().getVida()) + " de vida");
			if(t2.getPokeAtivo().getVida()<=0){
				boolean morreu = t2.pokeMorreu();
				if(morreu == true){
					es.clearAll();
					es.add(new Fim(t1, es, tm + TEMPO)); // esse Evento � retirado pelo Controler ap�s a execu��o do Evento atual
					es.add(new Fim(t1, es, tm + TEMPO));
				}	
				else{
					es.add(new Lancar(t1, tm + TEMPO));	
				}
			}
			
		}

		public String description() {
			return  null;
		}
	}
	public class Trocar extends Event{
		Treinador t1, t2;
		EventSet es;
		int nAtaque = 0;
		long tm;
		public Trocar(Treinador t1, EventSet es, long tm){
			super(tm);
			this.tm = tm;
			this.t1 = t1;
			this.t2 = t2;
			this.es = es;
		}
		public void action() {
			boolean trocou;
			trocou = t1.trocar();
			if(trocou){
				System.out.println(t1.getNome() + " trocou de pokemon");
				t1.lancar();
			}
			else
				System.out.println(t1.getNome() + " tentou trocar de pokemon");
		}
		public String description() {
			return null;
		}
		
	}
	public class Curar extends Event{
		Treinador t1, t2;
		EventSet es;
		int nAtaque = 0;
		long tm;
		public Curar(Treinador t1, EventSet es, long tm){
			super(tm);
			this.tm = tm;
			this.t1 = t1;
			this.t2 = t2;
			this.es = es;
		}
		public void action() {
			System.out.println(t1.getNome() + " utilizou potion");
			t1.curar();
		}

		public String description() {
			return t1.getPokeAtivo().getNome() + " est� com " +
					String.valueOf(t1.getPokeAtivo().getVida()) + " de vida";
		}
		
	}
	public class Agir extends Event{
		Treinador t1, t2;
		EventSet es;
		int nAtaque = 0;
		long tm;
		public Agir(Treinador t1, Treinador t2, EventSet es, long tm){
			super(tm);
			this.tm = tm;
			this.t1 = t1;
			this.t2 = t2;
			this.es = es;
		}
		
		public void action() {
			Event e1, e2;
			int p1, p2;
			e1 = t1.agir(t1, t2, es, tm+2*TEMPO);
			e2 = t2.agir(t2, t1, es, tm+4*TEMPO);
			p1 = getPrioridade(e1);
			p2 = getPrioridade(e2);
			if(p1 <= p2){
				es.add(e1);
				es.add(e2);
			}
			else{
				e2 = t2.agir(t2, t1, es, tm+2*TEMPO);
				e1 = t1.agir(t1, t2, es, tm+4*TEMPO);
				es.add(e2);
				es.add(e1);
			}
			es.add(new Agir(t1, t2, es, tm + 6*TEMPO));
			
		}
		public String description() {
			
			return "\nE come�a o round";
		}
		
	}
	public class Fim extends Event{
		EventSet es;
		Treinador vencedor;
		public Fim(Treinador t, EventSet es, long tm){
			super(tm);
			vencedor = t;
			this.es = es;
		}

		public void action() {
		}

		public String description() {
			return "E o vencedor �: " + vencedor.getNome();
		}
	}
	public int getPrioridade(Event e){
		if(e instanceof Fugir)
			return 1;
		else if(e instanceof Trocar)
			return 2;
		else if (e instanceof Curar)
			return 3;
		else if(e instanceof Atacar)
			return 4;
		else
			return 0;
	}
	public static void main(String[] args) {
		BattleControl bc = new BattleControl();
		long tm = System.currentTimeMillis();
		int mode = Integer.parseInt(args[0]);
		Treinador t1, t2;
		if (mode == 1){
			t1 = new Ash();
			t2 = new Brook();
			bc.addEvent(bc.new Batalhar(t1, t2, tm));
			bc.run();
			System.out.println("Fim de batalha");
		}
		else{
			t1 = new Ash();
			t2 = new Cagao();
			Terreno ter = new Terreno(t1, t2);
			//ter.ataqueSelvagem();
		}
	}
}