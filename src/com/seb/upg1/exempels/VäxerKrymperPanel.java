package com.seb.upg1.exempels;

/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex01_07 - V�xerKrymperPanel.java
 */

import com.seb.upg1.model.Rektangel;
import com.seb.upg1.model.Triangel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VäxerKrymperPanel extends JPanel implements ActionListener, MouseListener
{
	// Instansvariabler
	// Anledningen till att vi m�ste ange klassens fullst�ndiga namn
	// �r att det �ven i java.awt finns en klass men namnet List
	private final java.util.List<VäxerKrymper> ritobjekt;

	public VäxerKrymperPanel()
	{
		// Skapar en "lista som inneh�ller element av typen V�xerKrymper"
		ritobjekt = new java.util.ArrayList<VäxerKrymper>();

		// Skapar och startar timern f�r att rita ut alla objekt vid j�mna
		// mellanrum
		final Timer t = new Timer(50, this);
		t.start();

		// Panelen ska lyssna efter mush�ndelser (v�nster-, h�gerklick) s�
		// vi registrerar den egna klassen som en lyssnare efter s�dana
		// h�ndelser
		addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		System.out.println("paint");
		// Loopa igenom alla ritobjekt och be dem rita sig sj�lva
		for (final VäxerKrymper vk : ritobjekt)
		{
			vk.rita(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		// Ett ActionEvent fr�n timern s� vi ber panelen rita om sig
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent me)
	{
		// Vi unders�ker MouseEvent f�r att avg�ra om
		// anv�nderen tryckte p� v�nster eller h�ger knapp
		if (me.getButton() == MouseEvent.BUTTON1)
		{
			// Vi har tryckt ner v�nster knapp och l�gger till en ny boll
			// ritobjekt.add(new Boll(me.getX(), me.getY()));
			ritobjekt.add(new Rektangel(me.getX(), me.getY()));
		}
		else
		{
			// Vi har tryckt p� n�gon annan knapp och l�gger till en linje
			// ritobjekt.add(new Linje(me.getX(), me.getY()));
			ritobjekt.add(new Triangel(me.getX(), me.getY()));
		}
	}

	@Override
	public void mouseEntered(MouseEvent me)
	{
	}

	@Override
	public void mouseExited(MouseEvent me)
	{
	}

	@Override
	public void mousePressed(MouseEvent me)
	{
	}

	@Override
	public void mouseReleased(MouseEvent me)
	{
	}
}