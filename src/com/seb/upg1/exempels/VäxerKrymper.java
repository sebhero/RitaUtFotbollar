package com.seb.upg1.exempels;

/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex01_03 - V�xerKrymper.java
 */
public interface VäxerKrymper
{
	// publika konstanter f�r att indikera ett objekts tillst�nd
	public static final int VÄXER = 1;
	public static final int STILLA = 0;
	public static final int KRYMPER = -1;

	// metoder
	public void väx();

	public void krymp();

	public void rita(java.awt.Graphics g);
}