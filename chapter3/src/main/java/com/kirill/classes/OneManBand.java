package com.kirill.classes;

import java.util.Collection;
import java.util.Map;

public class OneManBand implements Performer {
  public OneManBand() {
  }

  public void perform() throws PerformanceException {
    /*for (Instrument instrument : instruments) {
      instrument.play();
    }*/
    for (String key : instruments.keySet()){
      Instrument instrument = instruments.get(key);
      System.out.print(key + " : ");
      instrument.play();
    }
  }

  private Map<String,Instrument> instruments;

  public void setInstruments(Map<String, Instrument> instruments) {
    this.instruments = instruments;
  }

  /*private Collection<Instrument> instruments;

  public void setInstruments(Collection<Instrument> instruments) {
    this.instruments = instruments;
  }*/
}

