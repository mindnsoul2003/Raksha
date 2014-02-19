package net.sf.anathema.character.generic.traits.types;


import net.sf.anathema.character.generic.traits.ITraitType;


public enum GraceType implements ITraitType {
  Cup, Staff, Ring, Sword, Way, Heart;


  @Override
  public String getId() {
    return name();
  }


  @Override
  public void accept(ITraitTypeVisitor visitor) {
    visitor.visitVirtue(this);
  }


  @Override
  public String toString() {
    return getId();
  }
}

