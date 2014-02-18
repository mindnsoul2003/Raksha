package net.sf.anathema.character.raksha.template;

import net.sf.anathema.character.generic.health.HealthLevelType;
import net.sf.anathema.character.generic.impl.magic.charm.special.OxBodyTechniqueCharm;
import net.sf.anathema.character.generic.magic.charms.special.IOxBodyTechniqueCharm;
import net.sf.anathema.character.generic.traits.types.OtherTraitType;

import java.util.LinkedHashMap;

public interface IRakshaSpecialCharms
{
	  @SuppressWarnings("serial")
      IOxBodyTechniqueCharm OX_BODY_TECHNIQUE = new OxBodyTechniqueCharm(
		      "Raksha.OxBodyTechnique", OtherTraitType.Valor,//$NON-NLS-1$
		      new LinkedHashMap<String, HealthLevelType[]>() {
		        {
		          put("Category.-1,-2", new HealthLevelType[] { HealthLevelType.ONE, HealthLevelType.TWO }); //$NON-NLS-1$
		        }
		      });

}
