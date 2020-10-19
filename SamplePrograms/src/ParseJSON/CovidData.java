package ParseJSON;

import java.util.List;

public class CovidData {
	private List<StatewiseData> stateData;
	private String dailyConfirmed;
	private String dailyDeceased;
	public List<StatewiseData> getStateData() {
		return stateData;
	}
	public void setStateData(List<StatewiseData> stateData) {
		this.stateData = stateData;
	}
	public String getDailyConfirmed() {
		return dailyConfirmed;
	}
	public void setDailyConfirmed(String dailyConfirmed) {
		this.dailyConfirmed = dailyConfirmed;
	}
	
}
