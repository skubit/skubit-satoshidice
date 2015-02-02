
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
    "bet_name",
    "address",
    "win_rate",
    "prize_factor",
    "house_rate",
    "expected_return",
    "expected_with_comp",
    "min_bet",
    "max_bet"
})
public class Game {

    @JsonProperty("bet_name")
    private String betName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("win_rate")
    private String winRate;
    @JsonProperty("prize_factor")
    private String prizeFactor;
    @JsonProperty("house_rate")
    private String houseRate;
    @JsonProperty("expected_return")
    private String expectedReturn;
    @JsonProperty("expected_with_comp")
    private String expectedWithComp;
    @JsonProperty("min_bet")
    private String minBet;
    @JsonProperty("max_bet")
    private String maxBet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The betName
     */
    @JsonProperty("bet_name")
    public String getBetName() {
        return betName;
    }

    /**
     * 
     * @param betName
     *     The bet_name
     */
    @JsonProperty("bet_name")
    public void setBetName(String betName) {
        this.betName = betName;
    }

    /**
     * 
     * @return
     *     The address
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The winRate
     */
    @JsonProperty("win_rate")
    public String getWinRate() {
        return winRate;
    }

    /**
     * 
     * @param winRate
     *     The win_rate
     */
    @JsonProperty("win_rate")
    public void setWinRate(String winRate) {
        this.winRate = winRate;
    }

    /**
     * 
     * @return
     *     The prizeFactor
     */
    @JsonProperty("prize_factor")
    public String getPrizeFactor() {
        return prizeFactor;
    }

    /**
     * 
     * @param prizeFactor
     *     The prize_factor
     */
    @JsonProperty("prize_factor")
    public void setPrizeFactor(String prizeFactor) {
        this.prizeFactor = prizeFactor;
    }

    /**
     * 
     * @return
     *     The houseRate
     */
    @JsonProperty("house_rate")
    public String getHouseRate() {
        return houseRate;
    }

    /**
     * 
     * @param houseRate
     *     The house_rate
     */
    @JsonProperty("house_rate")
    public void setHouseRate(String houseRate) {
        this.houseRate = houseRate;
    }

    /**
     * 
     * @return
     *     The expectedReturn
     */
    @JsonProperty("expected_return")
    public String getExpectedReturn() {
        return expectedReturn;
    }

    /**
     * 
     * @param expectedReturn
     *     The expected_return
     */
    @JsonProperty("expected_return")
    public void setExpectedReturn(String expectedReturn) {
        this.expectedReturn = expectedReturn;
    }

    /**
     * 
     * @return
     *     The expectedWithComp
     */
    @JsonProperty("expected_with_comp")
    public String getExpectedWithComp() {
        return expectedWithComp;
    }

    /**
     * 
     * @param expectedWithComp
     *     The expected_with_comp
     */
    @JsonProperty("expected_with_comp")
    public void setExpectedWithComp(String expectedWithComp) {
        this.expectedWithComp = expectedWithComp;
    }

    /**
     * 
     * @return
     *     The minBet
     */
    @JsonProperty("min_bet")
    public String getMinBet() {
        return minBet;
    }

    /**
     * 
     * @param minBet
     *     The min_bet
     */
    @JsonProperty("min_bet")
    public void setMinBet(String minBet) {
        this.minBet = minBet;
    }

    /**
     * 
     * @return
     *     The maxBet
     */
    @JsonProperty("max_bet")
    public String getMaxBet() {
        return maxBet;
    }

    /**
     * 
     * @param maxBet
     *     The max_bet
     */
    @JsonProperty("max_bet")
    public void setMaxBet(String maxBet) {
        this.maxBet = maxBet;
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
