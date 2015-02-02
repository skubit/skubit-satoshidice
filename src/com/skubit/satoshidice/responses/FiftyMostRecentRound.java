
package com.skubit.satoshidice.responses;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "game",
    "betID",
    "betTX",
    "playerNick",
    "playerHash",
    "betType",
    "target",
    "probability",
    "streak",
    "streakBetSize",
    "streakWinSize",
    "streakProfit",
    "streakProbability",
    "roll",
    "rollInPercent",
    "time",
    "result",
    "betInSatoshis",
    "prize",
    "prizeInSatoshis",
    "payoutInSatoshis",
    "payoutTX",
    "profitInSatoshis"
})
public class FiftyMostRecentRound {

    @JsonProperty("game")
    private String game;
    @JsonProperty("betID")
    private Integer betID;
    @JsonProperty("betTX")
    private Object betTX;
    @JsonProperty("playerNick")
    private String playerNick;
    @JsonProperty("playerHash")
    private String playerHash;
    @JsonProperty("betType")
    private String betType;
    @JsonProperty("target")
    private Integer target;
    @JsonProperty("probability")
    private String probability;
    @JsonProperty("streak")
    private Integer streak;
    @JsonProperty("streakBetSize")
    private Integer streakBetSize;
    @JsonProperty("streakWinSize")
    private Integer streakWinSize;
    @JsonProperty("streakProfit")
    private Integer streakProfit;
    @JsonProperty("streakProbability")
    private Double streakProbability;
    @JsonProperty("roll")
    private Integer roll;
    @JsonProperty("rollInPercent")
    private String rollInPercent;
    @JsonProperty("time")
    private String time;
    @JsonProperty("result")
    private String result;
    @JsonProperty("betInSatoshis")
    private Integer betInSatoshis;
    @JsonProperty("prize")
    private String prize;
    @JsonProperty("prizeInSatoshis")
    private Integer prizeInSatoshis;
    @JsonProperty("payoutInSatoshis")
    private Integer payoutInSatoshis;
    @JsonProperty("payoutTX")
    private Object payoutTX;
    @JsonProperty("profitInSatoshis")
    private Integer profitInSatoshis;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The game
     */
    @JsonProperty("game")
    public String getGame() {
        return game;
    }

    /**
     * 
     * @param game
     *     The game
     */
    @JsonProperty("game")
    public void setGame(String game) {
        this.game = game;
    }

    /**
     * 
     * @return
     *     The betID
     */
    @JsonProperty("betID")
    public Integer getBetID() {
        return betID;
    }

    /**
     * 
     * @param betID
     *     The betID
     */
    @JsonProperty("betID")
    public void setBetID(Integer betID) {
        this.betID = betID;
    }

    /**
     * 
     * @return
     *     The betTX
     */
    @JsonProperty("betTX")
    public Object getBetTX() {
        return betTX;
    }

    /**
     * 
     * @param betTX
     *     The betTX
     */
    @JsonProperty("betTX")
    public void setBetTX(Object betTX) {
        this.betTX = betTX;
    }

    /**
     * 
     * @return
     *     The playerNick
     */
    @JsonProperty("playerNick")
    public String getPlayerNick() {
        return playerNick;
    }

    /**
     * 
     * @param playerNick
     *     The playerNick
     */
    @JsonProperty("playerNick")
    public void setPlayerNick(String playerNick) {
        this.playerNick = playerNick;
    }

    /**
     * 
     * @return
     *     The playerHash
     */
    @JsonProperty("playerHash")
    public String getPlayerHash() {
        return playerHash;
    }

    /**
     * 
     * @param playerHash
     *     The playerHash
     */
    @JsonProperty("playerHash")
    public void setPlayerHash(String playerHash) {
        this.playerHash = playerHash;
    }

    /**
     * 
     * @return
     *     The betType
     */
    @JsonProperty("betType")
    public String getBetType() {
        return betType;
    }

    /**
     * 
     * @param betType
     *     The betType
     */
    @JsonProperty("betType")
    public void setBetType(String betType) {
        this.betType = betType;
    }

    /**
     * 
     * @return
     *     The target
     */
    @JsonProperty("target")
    public Integer getTarget() {
        return target;
    }

    /**
     * 
     * @param target
     *     The target
     */
    @JsonProperty("target")
    public void setTarget(Integer target) {
        this.target = target;
    }

    /**
     * 
     * @return
     *     The probability
     */
    @JsonProperty("probability")
    public String getProbability() {
        return probability;
    }

    /**
     * 
     * @param probability
     *     The probability
     */
    @JsonProperty("probability")
    public void setProbability(String probability) {
        this.probability = probability;
    }

    /**
     * 
     * @return
     *     The streak
     */
    @JsonProperty("streak")
    public Integer getStreak() {
        return streak;
    }

    /**
     * 
     * @param streak
     *     The streak
     */
    @JsonProperty("streak")
    public void setStreak(Integer streak) {
        this.streak = streak;
    }

    /**
     * 
     * @return
     *     The streakBetSize
     */
    @JsonProperty("streakBetSize")
    public Integer getStreakBetSize() {
        return streakBetSize;
    }

    /**
     * 
     * @param streakBetSize
     *     The streakBetSize
     */
    @JsonProperty("streakBetSize")
    public void setStreakBetSize(Integer streakBetSize) {
        this.streakBetSize = streakBetSize;
    }

    /**
     * 
     * @return
     *     The streakWinSize
     */
    @JsonProperty("streakWinSize")
    public Integer getStreakWinSize() {
        return streakWinSize;
    }

    /**
     * 
     * @param streakWinSize
     *     The streakWinSize
     */
    @JsonProperty("streakWinSize")
    public void setStreakWinSize(Integer streakWinSize) {
        this.streakWinSize = streakWinSize;
    }

    /**
     * 
     * @return
     *     The streakProfit
     */
    @JsonProperty("streakProfit")
    public Integer getStreakProfit() {
        return streakProfit;
    }

    /**
     * 
     * @param streakProfit
     *     The streakProfit
     */
    @JsonProperty("streakProfit")
    public void setStreakProfit(Integer streakProfit) {
        this.streakProfit = streakProfit;
    }

    /**
     * 
     * @return
     *     The streakProbability
     */
    @JsonProperty("streakProbability")
    public Double getStreakProbability() {
        return streakProbability;
    }

    /**
     * 
     * @param streakProbability
     *     The streakProbability
     */
    @JsonProperty("streakProbability")
    public void setStreakProbability(Double streakProbability) {
        this.streakProbability = streakProbability;
    }

    /**
     * 
     * @return
     *     The roll
     */
    @JsonProperty("roll")
    public Integer getRoll() {
        return roll;
    }

    /**
     * 
     * @param roll
     *     The roll
     */
    @JsonProperty("roll")
    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    /**
     * 
     * @return
     *     The rollInPercent
     */
    @JsonProperty("rollInPercent")
    public String getRollInPercent() {
        return rollInPercent;
    }

    /**
     * 
     * @param rollInPercent
     *     The rollInPercent
     */
    @JsonProperty("rollInPercent")
    public void setRollInPercent(String rollInPercent) {
        this.rollInPercent = rollInPercent;
    }

    /**
     * 
     * @return
     *     The time
     */
    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 
     * @return
     *     The result
     */
    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    /**
     * 
     * @param result
     *     The result
     */
    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 
     * @return
     *     The betInSatoshis
     */
    @JsonProperty("betInSatoshis")
    public Integer getBetInSatoshis() {
        return betInSatoshis;
    }

    /**
     * 
     * @param betInSatoshis
     *     The betInSatoshis
     */
    @JsonProperty("betInSatoshis")
    public void setBetInSatoshis(Integer betInSatoshis) {
        this.betInSatoshis = betInSatoshis;
    }

    /**
     * 
     * @return
     *     The prize
     */
    @JsonProperty("prize")
    public String getPrize() {
        return prize;
    }

    /**
     * 
     * @param prize
     *     The prize
     */
    @JsonProperty("prize")
    public void setPrize(String prize) {
        this.prize = prize;
    }

    /**
     * 
     * @return
     *     The prizeInSatoshis
     */
    @JsonProperty("prizeInSatoshis")
    public Integer getPrizeInSatoshis() {
        return prizeInSatoshis;
    }

    /**
     * 
     * @param prizeInSatoshis
     *     The prizeInSatoshis
     */
    @JsonProperty("prizeInSatoshis")
    public void setPrizeInSatoshis(Integer prizeInSatoshis) {
        this.prizeInSatoshis = prizeInSatoshis;
    }

    /**
     * 
     * @return
     *     The payoutInSatoshis
     */
    @JsonProperty("payoutInSatoshis")
    public Integer getPayoutInSatoshis() {
        return payoutInSatoshis;
    }

    /**
     * 
     * @param payoutInSatoshis
     *     The payoutInSatoshis
     */
    @JsonProperty("payoutInSatoshis")
    public void setPayoutInSatoshis(Integer payoutInSatoshis) {
        this.payoutInSatoshis = payoutInSatoshis;
    }

    /**
     * 
     * @return
     *     The payoutTX
     */
    @JsonProperty("payoutTX")
    public Object getPayoutTX() {
        return payoutTX;
    }

    /**
     * 
     * @param payoutTX
     *     The payoutTX
     */
    @JsonProperty("payoutTX")
    public void setPayoutTX(Object payoutTX) {
        this.payoutTX = payoutTX;
    }

    /**
     * 
     * @return
     *     The profitInSatoshis
     */
    @JsonProperty("profitInSatoshis")
    public Integer getProfitInSatoshis() {
        return profitInSatoshis;
    }

    /**
     * 
     * @param profitInSatoshis
     *     The profitInSatoshis
     */
    @JsonProperty("profitInSatoshis")
    public void setProfitInSatoshis(Integer profitInSatoshis) {
        this.profitInSatoshis = profitInSatoshis;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
