import java.util.ArrayList;

public class Player {

	private String name; //玩家姓名
	private int chips; //現有的籌碼
	private int bet;   //此局下注的籌碼 
	private ArrayList<Card> oneRoundCard;  //此牌局的卡
	
	/**
	 * @param name name
	 * @param chips chips
	 */	
	public Player(String name, int chips) {
		oneRoundCard=new ArrayList<Card>();
		this.name = name;
		this.chips = chips;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * 下注
	 * @return bet
	 */
	public int makeBet() {
		//檢查是否還有錢
		if(chips != 0) 
		{
			bet = bet;
		}
		else {
			bet = 0;
		}		
		return bet;
	}
	
	/**
	 * 設定此牌局所得到的卡 setter
	 * @param cards 所得到的牌
	 * @return
	 */
	public void setOneRoundCard(ArrayList cards) {
		oneRoundCard = cards;
	}
	
	/**
	 * 是否要牌
	 * @return b  (要牌：true, 不要牌:false)
	 */
	public boolean hitMe() {
		boolean b;
		//基本參考條件：16點以下要牌，17點以上不要牌
		//提示：用oneRoundCard來算
		int cardTotal = getTotalValue();
		if(cardTotal <= 16)
		{
			b = true;
		}
		else {
			b = false;
		}
		return b;
	}
	
	public int getTotalValue() {
		int counter = 0;
		//回傳此牌局所得的卡點數加總
		for(Card c : oneRoundCard) 
		{
			if(c.getRank()<10) 
			{
				counter += c.getRank();
			}
			else {
				counter += 10;
			}
		}
		return counter;
	}
	
	public int getCurrentChips() {
		//回傳玩家現有籌碼
		return chips;
	}
	
	public void increaseChips (int diff) {
		//玩家籌碼變動，setter
		bet = diff;
	}
	
	public void sayHello() {
		//玩家Say Hello
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
	}
}
