package com.seb.upg1.exempels;

/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex01_08 - TestAvV�xerKrymper.java
 */

import javax.swing.*;
import java.awt.*;

public class TestAvVäxerKrymper extends JFrame
{
	// Deklarerar de komponenter som ska anv�ndas
	// Vilket �r v�r egen komponent V�xerKrymperPanel
	private final VäxerKrymperPanel panel;

	// Konstruktorn i vilken vi skapar komponenterna
	public TestAvVäxerKrymper()
	{
		// S�tter titel p� f�nstret
		setTitle("Test av V�xerKrymper");

		// Anger vad som ska h�nda n�r vi st�nger
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// S�tter storlek och placering av f�nstret
		setSize(400, 300);
		setLocation(200, 200);

		// Skapar komponenten (panelen)
		panel = new VäxerKrymperPanel();

		// Placerar ut komponenterna i mitten av f�nstret
		add(panel, BorderLayout.CENTER);

		// G�r f�nstret synligt
		setVisible(true);
	}

	public static void main(String[] args)
	{
		// Skapar ett objekt av den egna klassen
		final TestAvVäxerKrymper test = new TestAvVäxerKrymper();
	}
}