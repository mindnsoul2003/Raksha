package net.sf.anathema.character.raksha.reporting.rendering;


import net.sf.anathema.character.raksha.RakshaCharacterModule;
import net.sf.anathema.character.reporting.pdf.content.BasicContent;
import net.sf.anathema.character.reporting.pdf.rendering.EncoderIds;
import net.sf.anathema.character.reporting.pdf.rendering.boxes.AbstractEncoderFactory;
import net.sf.anathema.character.reporting.pdf.rendering.boxes.RegisteredEncoderFactory;
import net.sf.anathema.character.reporting.pdf.rendering.general.box.ContentEncoder;
import net.sf.anathema.lib.resources.Resources;


@RegisteredEncoderFactory
public class LureEncoderFactory extends AbstractEncoderFactory {


  public LureEncoderFactory() {
    super(EncoderIds.GREAT_CURSE);
  }


  @Override
  public ContentEncoder create(Resources resources, BasicContent content) {
    return new LureEncoder();
  }


  @Override
  public boolean supports(BasicContent content) {
    return content.isOfType(RakshaCharacterModule.type);
  }
}

