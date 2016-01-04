package com.seb.upg2.main;

/**
 * @author Robert Jonsson, ITM Östersund
 * @version 1.0
 * @file Ex01_08 - TestAvVäxerKrymper.java
 */

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.seb.upg2.model.FotbollsPlan;

public class TestFotbolls extends JFrame
{
	// Deklarerar de komponenter som ska användas
	// Vilket är vår egen komponent VäxerKrymperPanel
	private final FotbollsPlan panel;

	// Konstruktorn i vilken vi skapar komponenterna
	public TestFotbolls()
	{
		// Sätter titel på fönstret
		setTitle("Test av Fotbolls");

		// Anger vad som ska hända när vi stänger
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Sätter storlek och placering av fönstret
		setSize(400, 300);
		setLocation(200, 200);

		// Skapar komponenten (panelen)
		panel = new FotbollsPlan();

		// Placerar ut komponenterna i mitten av fönstret
		add(panel, BorderLayout.CENTER);

		// Gör fönstret synligt
		setVisible(true);
	}

	public static void main(String[] args)
	{
		// Skapar ett objekt av den egna klassen
		final TestFotbolls test = new TestFotbolls();
	}
}