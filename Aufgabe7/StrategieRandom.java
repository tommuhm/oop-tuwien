
public class StrategieRandom implements Strategie {


	
	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) {
		return null;
	}

	public AmeisenRichtungen dice() {

		double dice = Math.random();

		if ( dice < 1/4 ) {
			return AmeisenRichtungen.rechts;
		}
			
			else if ( dice < 1/2 ) {
				return AmeisenRichtungen.links;
			}
			else if ( dice < 3/4 ) {
				return AmeisenRichtungen.oben;
			}
			else if (dice >= 3/4 ) {
				return AmeisenRichtungen.unten;
			}
		
		return AmeisenRichtungen.sleep; //should never happen

		}


		public void sleep(int n) throws InterruptedException {
			try {
				Thread.sleep(n);
			} catch(InterruptedException ex) {
				System.out.println("InterruptedException occured in StrategieRandom");
			}
		}
	}
