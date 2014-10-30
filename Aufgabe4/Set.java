import java.util.ArrayList;

public abstract class Set implements Artikel {

  private ArrayList<Artikel> artikelSet;

  public void service() {
    if (zustand() == Zustand.benutzt) {

    }
  }

  @Override
  public String kunde() {
    return null;
  }

  @Override
  public Zustand zustand() {
    return null;
  }

}
