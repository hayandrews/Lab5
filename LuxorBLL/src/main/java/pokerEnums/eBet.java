package pokerEnums;

import java.util.HashMap;
import java.util.Map;

public enum eBet {
	NoLimit(1, true){
		@Override
		public String toString() {
			return "No Limit";
		}
	},
	PotLimit(2, false) {
		@Override
		public String toString() {
			return "Pot Limit";
		}
	};private int ruleNbr;
	private boolean bDefault = false;
	private static Map<Integer, eBet> map = new HashMap<Integer, eBet>();
	
	static {
        for (eBet rule : eBet.values()) {
            map.put(rule.ruleNbr, rule);
        }
    }
	
	 public static eBet getRule(int ruleNbr) {
	        return map.get(ruleNbr);
	    }
	 
	private eBet(final int ruleNbr, boolean bDefault){
		this.ruleNbr = ruleNbr;
		this.bDefault = bDefault;
	}
	
	public int getRule(){
		return ruleNbr;
	}
	
	public boolean getDefault(){
		return this.bDefault;
	}
}