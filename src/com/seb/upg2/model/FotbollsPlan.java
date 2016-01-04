package com.seb.upg2.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FotbollsPlan extends JPanel implements ActionListener, MouseListener
{
	ArrayList<Fotboll> myBalls;

	public FotbollsPlan()
	{
		myBalls = new ArrayList<Fotboll>();

		final Timer t = new Timer(50, this);
		t.start();

		addMouseListener(this);

	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		ritaFotbollsplan(g);

		for (final Fotboll boll : myBalls)
		{
			boll.rita(g);
		}

	}

	private void ritaFotbollsplan(Graphics g)
	{
		final Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		/* Nedan b�r s�ttas som instansvariabler i klassen */
		final double LÄNGD = 100; // Fotbollsplanens LÄNGD i meter
		final double BREDD = 64; // Fotbollsplanens bredd i meter
		final double LINJEBREDD = 0.24; // Linjens bredd i meter (normalt max 12 cm)
		AffineTransform orginal = null;
		AffineTransform centreraOchSkala = null;
		/* Ovan b�r s�ttas som instansvariabler i klassen */

		// Ber�knar vilken skala som ska anv�ndas f�r att planen
		// alltid ska uppta st�rsta m�jliga storlek
		final double SKALA = Math.min(getWidth() / LÄNGD, getHeight() / BREDD);

		// Sparar orginaltransformeringen
		orginal = g2.getTransform();

		// Ber�kning f�r att centrera och skala planen
		centreraOchSkala = new AffineTransform();
		centreraOchSkala.translate((getWidth() - LÄNGD * SKALA) / 2, (getHeight() - BREDD * SKALA) / 2);
		centreraOchSkala.scale(SKALA, SKALA);
		g2.transform(centreraOchSkala);

		// Ritar sj�lva fotbollsplanen och linje runt den
		g2.setPaint(new Color(2, 152, 52));
		g2.fill(new Rectangle2D.Double(0, 0, LÄNGD, BREDD));
		g2.setStroke(new BasicStroke((float) (LINJEBREDD)));
		g2.setPaint(Color.white);
		g2.draw(new Rectangle2D.Double(0, 0, LÄNGD, BREDD));

		// Ritar mittlinjen och mittcirkel
		g2.draw(new Line2D.Double(LÄNGD / 2, 0, LÄNGD / 2, BREDD));
		g2.fill(new Ellipse2D.Double(LÄNGD / 2 - 0.5 / 2, BREDD / 2 - 0.5 / 2, 0.5, 0.5));
		g2.draw(new Ellipse2D.Double(LÄNGD / 2 - 9.15, BREDD / 2 - 9.15, 9.15 * 2, 9.15 * 2));

		// De fyra h�rnen
		g2.draw(new Arc2D.Double(-1, -1, 2, 2, 270, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(-1, -1 + BREDD, 2, 2, 0, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(-1 + LÄNGD, -1, 2, 2, 180, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(-1 + LÄNGD, -1 + BREDD, 2, 2, 90, 90, Arc2D.OPEN));

		// Ritar straffomr�den
		g2.draw(new Rectangle2D.Double(0, BREDD / 2 - 30.32 / 2, 16.5, 30.32));
		g2.draw(new Rectangle2D.Double(LÄNGD - 16.5, BREDD / 2 - 30.32 / 2, 16.5, 30.32));

		// Ritar m�lomr�den
		g2.draw(new Rectangle2D.Double(0, BREDD / 2 - 12.82 / 2, 5.5, 12.82));
		g2.draw(new Rectangle2D.Double(LÄNGD - 5.5, BREDD / 2 - 12.92 / 2, 5.5, 12.82));

		// Ritar straffpunkterna
		g2.fill(new Ellipse2D.Double(11, BREDD / 2 - 0.5 / 2, 0.5, 0.5));
		g2.fill(new Ellipse2D.Double(-11 + LÄNGD, BREDD / 2 - 0.5 / 2, 0.5, 0.5));

		// Ritar b�gen utanf�r straffomr�den
		g2.draw(new Arc2D.Double(11, BREDD / 2 - 9.15 / 2, 9.15, 9.15, 285, 150, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(-(11 + 9.15) + LÄNGD, BREDD / 2 - 9.15 / 2, 9.15, 9.15, 105, 150, Arc2D.OPEN));

		// �terst�ller transformering
		g2.setTransform(orginal);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// Vi unders�ker MouseEvent f�r att avg�ra om
		// anv�nderen tryckte p� v�nster eller h�ger knapp
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			// Vi har tryckt ner v�nster knapp och l�gger till en ny boll
			// ritobjekt.add(new Boll(me.getX(), me.getY()));
			System.out.println("x: " + e.getX() + " y: " + e.getY());
			myBalls.add(new Fotboll(e.getX(), e.getY()));
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}

}
