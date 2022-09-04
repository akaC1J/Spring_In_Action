package com.kirill.classes;

public class Magician implements Performer {

  private MagicBox magicBox;
  private String magicWords;

  public MagicBox getMagicBox() {
    return magicBox;
  }

  public void setMagicBox(MagicBox magicBox) {
    this.magicBox = magicBox;
  }

  public String getMagicWords() {
    return magicWords;
  }

  public void setMagicWords(String magicWords) {
    this.magicWords = magicWords;
  }

  @Override
  public void perform() throws PerformanceException {
    System.out.println(magicWords);
    System.out.println("В магическом ящике находится...");
    System.out.println(magicBox.getContents());

  }
}