package br.com.gracibolos.jdbc.teste;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RandonLocalDate {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
	    long days = ChronoUnit.DAYS.between(start, LocalDate.now());
	    LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
	    System.out.println(randomDate);
	}

}
