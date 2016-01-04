package com.seb.upg1.exempels;

/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex01_04 - RitObjekt.java
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class RitObjekt implements VäxerKrymper, ActionListener
{
	// Instansvariabler
	protected int x;
	protected int y;
	protected int storlek; // Objektets nuvarande storlek
	protected int tillstånd; // Objketets nuvarande tillst�nd
	protected final int MAX_STORLEK; // Objektets maximala storlek
	protected final int MIN_STORLEK; // Objektets minsta storlek

	public RitObjekt(int x, int y, int max, int min)
	{
		this.x = x;
		this.y = y;
		MAX_STORLEK = max;
		MIN_STORLEK = min;

		// Vi s�tter inledningsvis objektets storlek till minsta
		// och tillst�ndet till v�xer.
		storlek = MIN_STORLEK;
		tillstånd = VäxerKrymper.VÄXER;

		// Skapar och startar en Timer. G�r en ber�kning s� att det tar en
		// sekund
		// f�r objektet att v�xa fr�n sin minsta storlek till den st�rsta. Detta
		// s�tt
		// �r inte optimalt f�r objekt med stora storlekar d� tiden mellan varje
		// h�ndelse som genereras blir f�r kort. Helst b�r vi se till att tiden
		// blir
		// ca 100 ms och i st�llet �ka antalet pixlar vi �kar/minskar storleken
		// med.
		final Timer t = new Timer(1000 / (MAX_STORLEK - MIN_STORLEK), this);
		t.start();
	}

	// Metoden v�x anropas n�r objektet ska v�xa
	@Override
	public void väx()
	{
		// Vi ska bara v�xa om v�r storlek �r mindre �n max
		if (storlek < MAX_STORLEK)
		{
			storlek++;
		}
		else
		{
			// Vi har vaxt klart och �ndrar tillst�nd till krymper
			tillstånd = VäxerKrymper.KRYMPER;
		}
	}

	// Metoden krymp anropas n�r objektet ska krympa
	@Override
	public void krymp()
	{
		// Vi ska bara krympa om v�r storlek �r st�rre �n min
		if (storlek > MIN_STORLEK)
		{
			storlek--;
		}
		else
		{
			// Vi har krympt klart och �ndrar tillst�nd till v�xer
			tillstånd = VäxerKrymper.VÄXER;
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		// Hit kommer vi varje g�ng timern genererar en h�ndelse
		// Kontrollerar vilket tillst�nd vi befinner oss i och
		// anropar antingen v�x eller krymp beroende p� tillst�nd
		if (tillstånd == VäxerKrymper.VÄXER)
		{
			väx();
		}
		else if (tillstånd == VäxerKrymper.KRYMPER)
		{
			krymp();
		}

	}
}

/*
 * Observera att klassen m�ste deklareras som abstrakt eftersom endast metoderna
 * v�x och krymp i gr�nssnittet V�xerKrymper implementeras. Alla objekt som kan
 * krympa och v�xa g�r det genom att storleken minskar eller �kar med ett.
 * D�rf�r kan dessa tv� metoder implementeras direkt i denna basklass. Metoden
 * rita d�remot kan inte implementeras eftersom s�ttet att rita ut olika objekt
 * skiljer sig �t. Att implementera metoden rita �verl�ter vi till subklasserna.
 */