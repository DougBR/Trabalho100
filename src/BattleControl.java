
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
			int cont = 1;
			addEvent(new Apresentar(t1, tm + cont * TEMPO)); cont++;
			addEvent(new Apresentar(t2, tm+ cont*TEMPO)); cont++;
			addEvent(new Lancar(t1, tm+cont*TEMPO)); cont++;
			addEvent(new Lancar(t2, tm+cont*TEMPO)); cont++;
			addEvent(new Agir(t1, t2, es, tm+cont*TEMPO)); cont++;
			
		}

		public String description() {
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
			System.out.println(	t2.getPokeAtivo().getNome() + " está com " +
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
			es.add(t1.agir(t1, t2, es, tm+2*TEMPO)); 
			es.add(t2.agir(t2, t1, es, tm+4*TEMPO)); 
			es.add(new Agir(t1, t2, es, tm + 6*TEMPO));
			
		}
		public String description() {
			
			return "\nE começa o round";
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
