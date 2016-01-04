package com.seb.upg1.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Rektangel extends RitObjekt
{

	public Rektangel(int x, int y, int max, int min)
	{
		super(x, y, max, min);

	}

	public Rektangel(int x, int y)
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
		if (getIsFilled())
		{
			g.fillRect(x, y, storlek, storlek);
		}
		g.drawRect(x, y, storlek, storlek);
	}

}
