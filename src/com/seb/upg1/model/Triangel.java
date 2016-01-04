package com.seb.upg1.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Triangel extends RitObjekt
{
	Polygon p;

	public Triangel(int x, int y, int max, int min)
	{
		super(x, y, max, min);
		// TODO Auto-generated constructor stub
	}

	public Triangel(int x, int y)
	{
		super(x, y, 100, 10);
		final Random generator = new Random(System.currentTimeMillis());
		setTheColor(Color.getHSBColor(generator.nextFloat(), generator.nextFloat(), generator.nextFloat()));
		setIsFilled(generator.nextBoolean());

	}

	@Override
	public void rita(Graphics g)
	{

		g.setColor(getTheColor());

		p = new Polygon();
		p.addPoint(x, y);
		p.addPoint(x, storlek);
		p.addPoint(y, storlek);

		if (getIsFilled())
		{
			g.fillPolygon(p);
		}
		g.drawPolygon(p);
	}
}
