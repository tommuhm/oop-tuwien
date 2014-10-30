public interface Artikel {
  Zustand zustand();
  // gibt den aktuellen Zustand wider:
  // - Artikel ist verleihbar,
  // - Artikel ist verliehen,
  // - Artikel ist benutzt (nach Retournierung).

  void verleihe(String kunde);
  // verleihe Artikel an Kunden namens kunde;
  // nur aufrufbar wenn Artikel verleihbar ist;
  // Artikel kommt in den Zustand verliehen.

  String kunde();
  // Name des Kunden, an den Artikel verliehen;
  // nur aufrufbar wenn Artikel verliehen ist.

  void retour();
  // nur aufrufbar wenn Artikel verliehen ist;
  // Artikel kommt in den Zustand benutzt.

  boolean kontrolle();
  // nur aufrufbar wenn Artikel benutzt ist;
  // falls Artikel als verleihbar einstufbar ist
  // - kommt Artikel in den Zustand verleihbar und
  // - es wird true zurueckgegeben;
  // sonst: Ergebnis false und Zustand unveraendert.
}