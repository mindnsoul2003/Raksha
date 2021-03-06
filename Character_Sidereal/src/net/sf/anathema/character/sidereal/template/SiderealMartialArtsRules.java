package net.sf.anathema.character.sidereal.template;

import net.sf.anathema.character.generic.impl.magic.MartialArtsUtilities;
import net.sf.anathema.character.generic.magic.ICharm;
import net.sf.anathema.character.generic.magic.charms.MartialArtsLevel;
import net.sf.anathema.character.generic.template.magic.MartialArtsCharmConfiguration;
import net.sf.anathema.character.generic.template.magic.MartialArtsRules;

public class SiderealMartialArtsRules implements MartialArtsRules {
  private static final int MAX_CREATION_SMA = 3;

  @Override
  public void setHighLevelAtCreation(boolean highLevelAtCreation) {
  }

  @Override
  public MartialArtsLevel getStandardLevel() {
    return MartialArtsLevel.Sidereal;
  }

  @Override
  public boolean isCharmAllowed(ICharm martialArtsCharm, MartialArtsCharmConfiguration charmConfiguration,
                                boolean isExperienced) {
    MartialArtsLevel level = MartialArtsUtilities.getLevel(martialArtsCharm);
    if (isExperienced ||
            level != MartialArtsLevel.Sidereal ||
            isLearned(martialArtsCharm, charmConfiguration)) {
      return true;
    }

    return countSMACharms(charmConfiguration) < MAX_CREATION_SMA;
  }

  private boolean isLearned(ICharm charm, MartialArtsCharmConfiguration config) {
    for (ICharm match : config.getLearnedCharms()) {
      if (charm == match) {
        return true;
      }
    }
    return false;
  }

  private int countSMACharms(MartialArtsCharmConfiguration charmConfiguration) {
    int smaCharms = 0;
    for (ICharm charm : charmConfiguration.getLearnedCharms()) {
      if (MartialArtsUtilities.getLevel(charm) == MartialArtsLevel.Sidereal) {
        smaCharms++;
      }
    }
    return smaCharms;
  }
}