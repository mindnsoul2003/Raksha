package net.sf.anathema.character.raksha;

import net.sf.anathema.character.generic.template.magic.FavoringTraitType;
import net.sf.anathema.character.generic.type.CharacterType;
import net.sf.anathema.character.generic.type.ICharacterType;
import net.sf.anathema.initialization.reflections.Weight;

@CharacterType
@Weight(weight = 6)
public class RakshaCharacterType implements ICharacterType {

  @Override
  public boolean isExaltType() {
    return false;
  }

  @Override
  public boolean isEssenceUser() {
    return true;
  }

  @Override
  public String getId() {
    return "Raksha";
  }


  public boolean equals(Object other) {
    return other instanceof RakshaCharacterType;
  }


  public int hashCode() {
    return 9;
  }
}

