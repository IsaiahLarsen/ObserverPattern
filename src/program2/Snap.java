package program2;

public class Snap {
    private String company;
    private String ticker;
    private String updateDate;
    private float currentPrice;
    private float dollarChange;
    private float percentChange;
    private float yearToDateChange;
    private float weekHigh;
    private float weekLow;
    private float ratio;

    public Snap(){
        updateDate = "none";
        company = "default";
        ticker = "default";
        currentPrice = 0;
        dollarChange = 0;
        percentChange = 0;
        yearToDateChange = 0;
        weekHigh = 0;
        weekLow = 0;
        ratio = 0;
    }

    //setters
    public void setCompany(String company){
        this.company = company;
    }
    public void setTicker(String ticker){
        this.ticker = ticker;
    }
    public void setCurrentPrice(float currentPrice){
        this.currentPrice = currentPrice;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    public void setDollarChange(float dollarChange){
        this.dollarChange = dollarChange;
    }
    public void setPercentChange(float percentChange) {
        this.percentChange = percentChange;
    }
    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
    public void setWeekHigh(float weekHigh) {
        this.weekHigh = weekHigh;
    }
    public void setWeekLow(float weekLow) {
        this.weekLow = weekLow;
    }
    public void setYearToDateChange(float yearToDateChange) {
        this.yearToDateChange = yearToDateChange;
    }

    //getters
    public float getCurrentPrice() {
        return currentPrice;
    }
    public String getUpdateDate() {
        return updateDate;
    }
    public float getDollarChange() {
        return dollarChange;
    }
    public float getPercentChange() {
        return percentChange;
    }
    public float getRatio() {
        return ratio;
    }
    public float getWeekHigh() {
        return weekHigh;
    }
    public float getYearToDateChange() {
        return yearToDateChange;
    }
    public String getCompany() {
        return company;
    }
    public String getTicker() {
        return ticker;
    }
    public float getWeekLow() {
        return weekLow;
    }
}
