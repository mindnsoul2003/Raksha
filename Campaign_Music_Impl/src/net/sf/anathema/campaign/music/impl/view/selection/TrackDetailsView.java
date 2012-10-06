package net.sf.anathema.campaign.music.impl.view.selection;import net.miginfocom.layout.CC;import net.miginfocom.layout.LC;import net.miginfocom.swing.MigLayout;import net.sf.anathema.campaign.music.impl.view.categorization.MusicCategorizationView;import net.sf.anathema.campaign.music.presenter.ITrackDetailsProperties;import net.sf.anathema.campaign.music.view.categorization.IMusicCategorizationProperties;import net.sf.anathema.campaign.music.view.categorization.IMusicCategorizationView;import net.sf.anathema.campaign.music.view.selection.ITrackDetailsView;import net.sf.anathema.lib.workflow.textualdescription.ITextView;import net.sf.anathema.lib.workflow.textualdescription.view.LabelTextView;import net.sf.anathema.lib.workflow.textualdescription.view.LineTextView;import javax.swing.JComponent;import javax.swing.JLabel;import javax.swing.JPanel;import javax.swing.border.TitledBorder;import java.awt.BorderLayout;import static net.sf.anathema.lib.gui.layout.LayoutUtils.fillWithoutInsets;public class TrackDetailsView implements ITrackDetailsView {  private JPanel content;  private LabelledStringValueView titleView;  private LabelledStringValueView albumView;  private LabelledStringValueView trackNumberView;  private LabelledStringValueView artistView;  private final MusicCategorizationView musicCategorizationView = new MusicCategorizationView();  private final JPanel trackDetailsPanel = new JPanel(new MigLayout(fillWithoutInsets().wrapAfter(1)));  private final JPanel noTrackPanel = new JPanel(new MigLayout(new LC().fill()));  private final ITextView givenNameView = new LineTextView(30);  private final JPanel playerPanel = new JPanel(new BorderLayout());  public JComponent getContent(IMusicCategorizationProperties categoryProperties,                               ITrackDetailsProperties detailsProperties) {    if (content == null) {      content = createContent(categoryProperties, detailsProperties);    }    return content;  }  private JPanel createContent(IMusicCategorizationProperties categoryProperties,                               ITrackDetailsProperties detailsProperties) {    fillTrackDetailsPanel(categoryProperties, detailsProperties);    fillNoContentPanel(detailsProperties);    JPanel panel = new JPanel(new MigLayout(new LC().fill()));    panel.add(noTrackPanel);    return panel;  }  private void fillNoContentPanel(ITrackDetailsProperties detailsProperties) {    noTrackPanel.add(new JLabel(detailsProperties.getNoContentString()), new CC().push().grow());  }  private void fillTrackDetailsPanel(IMusicCategorizationProperties categoryProperties,                                     ITrackDetailsProperties detailsProperties) {    JPanel infoPlayerPanel = new JPanel(new MigLayout(new LC().fill().insets("0")));    infoPlayerPanel.add(createTrackInfoPanel(detailsProperties), new CC().grow().push());    infoPlayerPanel.add(playerPanel, new CC().grow());    trackDetailsPanel.add(infoPlayerPanel, new CC().growX());    trackDetailsPanel.add(musicCategorizationView.getContent(categoryProperties), new CC().grow());  }  private JPanel createTrackInfoPanel(ITrackDetailsProperties properties) {    titleView = new LabelledStringValueView(properties.getOriginalNameString() + ":"); //$NON-NLS-1$    albumView = new LabelledStringValueView(properties.getAlbumLabel() + ":"); //$NON-NLS-1$    trackNumberView = new LabelledStringValueView(properties.getTrackNumberLabel() + ":"); //$NON-NLS-1$    artistView = new LabelledStringValueView(properties.getArtistLabel() + ":"); //$NON-NLS-1$    JPanel panel = new JPanel(new MigLayout(new LC().wrapAfter(2)));    new LabelTextView(properties.getGivenNameLabel() + ":", givenNameView).addToMigPanel(panel); //$NON-NLS-1$    titleView.addToPanel(panel);    artistView.addToPanel(panel);    albumView.addToPanel(panel);    trackNumberView.addToPanel(panel);    panel.setBorder(new TitledBorder(properties.getInfoBorder()));    return panel;  }  @Override  public void setOriginalTitle(String title) {    titleView.setValue(title);  }  @Override  public void setAlbumTitle(String album) {    albumView.setValue(album);  }  @Override  public void setTrackNumber(String track) {    trackNumberView.setValue(track);  }  @Override  public void setArtistName(String artist) {    artistView.setValue(artist);  }  @Override  public void showTrackInfo(boolean show) {    content.removeAll();    JPanel panelToShow = getPanelToShow(show);    content.add(panelToShow, new CC().grow());    content.revalidate();  }  private JPanel getPanelToShow(boolean show) {    if (show) {      return trackDetailsPanel;    }    return noTrackPanel;  }  @Override  public IMusicCategorizationView getMusicCategorizationView() {    return musicCategorizationView;  }  @Override  public ITextView getGivenNameView() {    return givenNameView;  }  public void setPlayerComponent(JComponent component) {    playerPanel.removeAll();    playerPanel.add(component);  }}