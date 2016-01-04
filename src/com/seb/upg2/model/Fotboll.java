package com.seb.upg2.model;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import com.seb.upg1.model.RitObjekt;

public class Fotboll extends RitObjekt
{
	// Instansvariabler
	FotbollsPlan plan;
	ArrayList<Image> fotbollsImages = new ArrayList<Image>();

	// Konstruktor
	public Fotboll(int x, int y)
	{
		super(x, y, 10, 1);
		// import images..
		for (int i = 0; i <= 9; i++)
		{
			final URL url = this.getClass().getResource("/fotboll" + (i + 1) + ".png");
			final Image img = new javax.swing.ImageIcon(url).getImage();
			fotbollsImages.add(img);

		}

	}

	@Override
	public void rita(Graphics g)
	{
		// Ritar en bild av fotbollen.
		g.drawImage(fotbollsImages.get(3), x, y, null);
	}
}
