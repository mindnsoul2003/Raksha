package net.sf.anathema.character.raksha.caste;

import net.sf.anathema.character.generic.caste.ICasteType;

public enum InfernalCaste implements ICasteType {

  Diplomat, Entertainer, Warrior, Worker, Guide;

  @Override
  public String getId() {
    return name();
  }
}

