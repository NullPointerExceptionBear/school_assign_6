import java.util.*;
public class Assignment6
{
	public static void main(String[] arg)
	{
		NFLFan stan = new NFLFan("Stan", "Marsh");
		NFLFan john = new NFLFan("John", "Wilson");
		StadiumSecurity bob = new StadiumSecurity("Bob", "Manson");
		SixPack myPack = new SixPack();
		
		
		stan.drinkBeer(myPack.dispenseBeer());
		System.out.println(stan);
		System.out.println(myPack);
		john.drinkBeer(myPack.dispenseBeer());
		System.out.println(john);
		System.out.println(myPack);
		bob.ChallengeFan(stan);
		bob.ChallengeFan(john);
		System.out.println(bob);
		
		stan.drinkBeer(myPack.dispenseBeer());
		System.out.println(stan);
		System.out.println(myPack);
		john.drinkBeer(myPack.dispenseBeer());
		System.out.println(john);
		System.out.println(myPack);
		bob.ChallengeFan(stan);
		bob.ChallengeFan(john);
		System.out.println(bob);
		
		stan.drinkBeer(myPack.dispenseBeer());
		System.out.println(stan);
		System.out.println(myPack);
		john.drinkBeer(myPack.dispenseBeer());
		System.out.println(john);
		System.out.println(myPack);
		bob.ChallengeFan(stan);
		bob.ChallengeFan(john);
		System.out.println(bob);
		
	}
}

class Beer
{
	boolean isFull = true;
	
	public void drinkMe()
	{
		isFull = false;
	}
	
	public boolean checkBeer()
	{
		return isFull;
	}
}

class SixPack
{
	Beer[] beers = new Beer[6];
	Beer coldOne = new Beer();
	int beersLeft;
	
	SixPack()
	{
		fillPack();
		beersLeft = 6;
	}
	
	public void fillPack()
	{
		for(int count = 0; count < 6; count++)
		{
			beers[count] = new Beer();
		}
	}
	
	public Beer dispenseBeer()
	{
		for(int count = 0; count < 6; count++)
		{
			if(beers[5] == null)
			{
				System.out.println("There are no more beers!");
				break;
			}
			else if(beers[count] != null)
			{
				coldOne = beers[count];
				beers[count] = null;
				beersLeft -= 1;
				break;
			}
		}
		return coldOne;
	}
	
	public String toString()
	{
		String iAm = "I am a six pack and i have " + beersLeft + " beers left.";
		return iAm;
	}
}

class Person
{
	String fName;
	String lName;
	
	public Person(String fn, String ln)
	{
		fName = fn;
		lName = ln;
	}
	
	public String GetFirstName()
	{
		return fName;
	}
	
	public String GetLastName()
	{
		return lName;
	}
	
	public String toString()
	{
		String iAm = "My name is " + GetFirstName() + " " + GetLastName();
		return iAm;
	}
}

class NFLFan extends Person
{
	int beersDowned;
	int unoMas;
	public NFLFan(String fn, String ln)
	{
		super(fn, ln);
		{
			fName = fn;
			lName = ln;
			beersDowned = 0;
		}
	}
	
	public void BeerCount(int brr)
	{
		beersDowned = brr;
	}
	
	public int GetBeerDwnd()
	{
		return beersDowned;
	}
	
	public void drinkBeer(Beer myBeer)
	{
		unoMas = GetBeerDwnd();
		if(myBeer.checkBeer() == true)
		{
			myBeer.drinkMe();
			unoMas += 1;
			BeerCount(unoMas);
		}
		else
		{
			System.out.println("This beer is empty!");
		}
	}
	
	public String toString()
	{
		String iAm = "My name is " + GetFirstName() + " " + GetLastName() + " and I've had " + GetBeerDwnd() + " beer(s).";
		return iAm;
	}
}

class StadiumSecurity extends Person
{
	int fansYelledAt;
	public StadiumSecurity(String fn, String ln)
	{
		super(fn, ln);
		{
			fName = fn;
			lName = ln;
			fansYelledAt = 0;
		}
	}
	public void setAngrr(int ang)
	{
		fansYelledAt = ang;
	}
	
	public int GetAngrr()
	{
		return fansYelledAt;
	}
	
	public void ChallengeFan(NFLFan fan)
	{
		int angry = GetAngrr();
		if(fan.GetBeerDwnd() > 2)
		{
			angry += 1;
			setAngrr(angry);
		}
	}
	
	public String toString()
	{
		String iAm = "My name is " + GetFirstName() + " " + GetLastName() + " and I'm a security guard and I've yelled at " + GetAngrr() + " fan(s).";
		return iAm;
	}
}