package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.border.*;

public class OvalPane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OvalPane() {
		setOpaque(false);
		
		setBorder(new EmptyBorder(0, 0, 0, 0));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 400);
	}


	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);


		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(getBackground());
		g2d.fillOval(0, 0, getWidth(), getHeight());
		g2d.drawOval(0, 0, getWidth(), getHeight());

	}
}
