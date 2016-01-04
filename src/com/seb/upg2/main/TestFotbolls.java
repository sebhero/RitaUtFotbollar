package com.seb.upg2.main;

/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex01_08 - TestAvV�xerKrymper.java
 */

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.seb.upg2.model.FotbollsPlan;

public class TestFotbolls extends JFrame
{
	// Deklarerar de komponenter som ska anv�ndas
	// Vilket �r v�r egen komponent V�xerKrymperPanel
	private final FotbollsPlan panel;

	// Konstruktorn i vilken vi skapar komponenterna
	public TestFotbolls()
	{
		// S�tter titel p� f�nstret
		setTitle("Test av Fotbolls");

		// Anger vad som ska h�nda n�r vi st�nger
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// S�tter storlek och placering av f�nstret
		setSize(400, 300);
		setLocation(200, 200);

		// Skapar komponenten (panelen)
		panel = new FotbollsPlan();

		// Placerar ut komponenterna i mitten av f�nstret
		add(panel, BorderLayout.CENTER);

		// G�r f�nstret synligt
		setVisible(true);
	}

	public static void main(String[] args)
	{
		// Skapar ett objekt av den egna klassen
		final TestFotbolls test = new TestFotbolls();
	}
}