import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	private ArrayList<Card> usedCards;
	public int nUsed;

	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		usedCards=new ArrayList<Card>();
		
		//產生幾副牌
		for(int i = 0; i < nDeck ;i++) 
		{
			//產生花色suit
			for(Card.Suit s : Card.Suit.values())
			{
				//產生數字rank
				for(int r = 1; r <= 13; r++)
				{
					Card card = new Card(s,r);
					//將撲克牌放入ArrayList
					cards.add(card);
				}
			}
		}	
		shuffle();
	}	
	
	public void shuffle() {
		
		//如果有發過牌的話
		if(usedCards.size() != 0)
		{
			//將牌收回來
			for(Card c : usedCards)
			{
				cards.add(c);
			}
			
			//將紀錄清空
			usedCards.clear();
			nUsed = 0;
		}

		Random rnd = new Random();
		
		//亂數重排
		for(int i = 0; i < cards.size(); i++)
		{
			int j = rnd.nextInt(cards.size());
			Card tempCard = cards.get(j);
			cards.set(j, cards.get(i));
			cards.set(i, tempCard);
		}
	}
	
	public Card getOneCard(){
		
		//取arrayList裡的第一張牌
		Card c = cards.get(0);
		
		//紀錄至usedCard和nUsed
		usedCards.add(c);
		nUsed++;
		
		//清除發出去的牌
		cards.remove(c);
		
		//如果牌發完了的話洗牌
		if (cards.size() == 0)
		{
			shuffle();
		}

		return c;
	}
	
	public void printDeck(){

		for(Card c:cards)
		{
			c.printCard();
		}

	}
	
	public ArrayList<Card> getAllCards(){
		return cards;
	}	
}

