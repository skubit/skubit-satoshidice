
package com.skubit.satoshidice.responses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "hash",
    "nick",
    "version",
    "luck",
    "rounds",
    "winsInSatoshis",
    "leastLikelyWin",
    "leastLikelyWinStreak",
    "taggedToAffiliate",
    "added",
    "lastSeen",
    "luckToday",
    "roundsToday",
    "winsInSatoshisToday",
    "leastLikelyWinToday",
    "leastLikelyWinStreakToday",
    "fiftyMostRecentRounds",
    "queryTimeInSeconds"
})
public class PlayerStatResponse {

    @JsonProperty("hash")
    private String hash;
    @JsonProperty("nick")
    private String nick;
    @JsonProperty("version")
    private String version;
    @JsonProperty("luck")
    private Double luck;
    @JsonProperty("rounds")
    private Integer rounds;
    @JsonProperty("winsInSatoshis")
    private Integer winsInSatoshis;
    @JsonProperty("leastLikelyWin")
    private Integer leastLikelyWin;
    @JsonProperty("leastLikelyWinStreak")
    private Double leastLikelyWinStreak;
    @JsonProperty("taggedToAffiliate")
    private Integer taggedToAffiliate;
    @JsonProperty("added")
    private String added;
    @JsonProperty("lastSeen")
    private String lastSeen;
    @JsonProperty("luckToday")
    private Double luckToday;
    @JsonProperty("roundsToday")
    private Integer roundsToday;
    @JsonProperty("winsInSatoshisToday")
    private Integer winsInSatoshisToday;
    @JsonProperty("leastLikelyWinToday")
    private Double leastLikelyWinToday;
    @JsonProperty("leastLikelyWinStreakToday")
    private Double leastLikelyWinStreakToday;
    @JsonProperty("fiftyMostRecentRounds")
    private List<FiftyMostRecentRound> fiftyMostRecentRounds = new ArrayList<FiftyMostRecentRound>();
    @JsonProperty("queryTimeInSeconds")
    private Double queryTimeInSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The hash
     */
    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    /**
     * 
     * @param hash
     *     The hash
     */
    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * 
     * @return
     *     The nick
     */
    @JsonProperty("nick")
    public String getNick() {
        return nick;
    }

    /**
     * 
     * @param nick
     *     The nick
     */
    @JsonProperty("nick")
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * 
     * @return
     *     The version
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The luck
     */
    @JsonProperty("luck")
    public Double getLuck() {
        return luck;
    }

    /**
     * 
     * @param luck
     *     The luck
     */
    @JsonProperty("luck")
    public void setLuck(Double luck) {
        this.luck = luck;
    }

    /**
     * 
     * @return
     *     The rounds
     */
    @JsonProperty("rounds")
    public Integer getRounds() {
        return rounds;
    }

    /**
     * 
     * @param rounds
     *     The rounds
     */
    @JsonProperty("rounds")
    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    /**
     * 
     * @return
     *     The winsInSatoshis
     */
    @JsonProperty("winsInSatoshis")
    public Integer getWinsInSatoshis() {
        return winsInSatoshis;
    }

    /**
     * 
     * @param winsInSatoshis
     *     The winsInSatoshis
     */
    @JsonProperty("winsInSatoshis")
    public void setWinsInSatoshis(Integer winsInSatoshis) {
        this.winsInSatoshis = winsInSatoshis;
    }

    /**
     * 
     * @return
     *     The leastLikelyWin
     */
    @JsonProperty("leastLikelyWin")
    public Integer getLeastLikelyWin() {
        return leastLikelyWin;
    }

    /**
     * 
     * @param leastLikelyWin
     *     The leastLikelyWin
     */
    @JsonProperty("leastLikelyWin")
    public void setLeastLikelyWin(Integer leastLikelyWin) {
        this.leastLikelyWin = leastLikelyWin;
    }

    /**
     * 
     * @return
     *     The leastLikelyWinStreak
     */
    @JsonProperty("leastLikelyWinStreak")
    public Double getLeastLikelyWinStreak() {
        return leastLikelyWinStreak;
    }

    /**
     * 
     * @param leastLikelyWinStreak
     *     The leastLikelyWinStreak
     */
    @JsonProperty("leastLikelyWinStreak")
    public void setLeastLikelyWinStreak(Double leastLikelyWinStreak) {
        this.leastLikelyWinStreak = leastLikelyWinStreak;
    }

    /**
     * 
     * @return
     *     The taggedToAffiliate
     */
    @JsonProperty("taggedToAffiliate")
    public Integer getTaggedToAffiliate() {
        return taggedToAffiliate;
    }

    /**
     * 
     * @param taggedToAffiliate
     *     The taggedToAffiliate
     */
    @JsonProperty("taggedToAffiliate")
    public void setTaggedToAffiliate(Integer taggedToAffiliate) {
        this.taggedToAffiliate = taggedToAffiliate;
    }

    /**
     * 
     * @return
     *     The added
     */
    @JsonProperty("added")
    public String getAdded() {
        return added;
    }

    /**
     * 
     * @param added
     *     The added
     */
    @JsonProperty("added")
    public void setAdded(String added) {
        this.added = added;
    }

    /**
     * 
     * @return
     *     The lastSeen
     */
    @JsonProperty("lastSeen")
    public String getLastSeen() {
        return lastSeen;
    }

    /**
     * 
     * @param lastSeen
     *     The lastSeen
     */
    @JsonProperty("lastSeen")
    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    /**
     * 
     * @return
     *     The luckToday
     */
    @JsonProperty("luckToday")
    public Double getLuckToday() {
        return luckToday;
    }

    /**
     * 
     * @param luckToday
     *     The luckToday
     */
    @JsonProperty("luckToday")
    public void setLuckToday(Double luckToday) {
        this.luckToday = luckToday;
    }

    /**
     * 
     * @return
     *     The roundsToday
     */
    @JsonProperty("roundsToday")
    public Integer getRoundsToday() {
        return roundsToday;
    }

    /**
     * 
     * @param roundsToday
     *     The roundsToday
     */
    @JsonProperty("roundsToday")
    public void setRoundsToday(Integer roundsToday) {
        this.roundsToday = roundsToday;
    }

    /**
     * 
     * @return
     *     The winsInSatoshisToday
     */
    @JsonProperty("winsInSatoshisToday")
    public Integer getWinsInSatoshisToday() {
        return winsInSatoshisToday;
    }

    /**
     * 
     * @param winsInSatoshisToday
     *     The winsInSatoshisToday
     */
    @JsonProperty("winsInSatoshisToday")
    public void setWinsInSatoshisToday(Integer winsInSatoshisToday) {
        this.winsInSatoshisToday = winsInSatoshisToday;
    }

    /**
     * 
     * @return
     *     The leastLikelyWinToday
     */
    @JsonProperty("leastLikelyWinToday")
    public Double getLeastLikelyWinToday() {
        return leastLikelyWinToday;
    }

    /**
     * 
     * @param leastLikelyWinToday
     *     The leastLikelyWinToday
     */
    @JsonProperty("leastLikelyWinToday")
    public void setLeastLikelyWinToday(Double leastLikelyWinToday) {
        this.leastLikelyWinToday = leastLikelyWinToday;
    }

    /**
     * 
     * @return
     *     The leastLikelyWinStreakToday
     */
    @JsonProperty("leastLikelyWinStreakToday")
    public Double getLeastLikelyWinStreakToday() {
        return leastLikelyWinStreakToday;
    }

    /**
     * 
     * @param leastLikelyWinStreakToday
     *     The leastLikelyWinStreakToday
     */
    @JsonProperty("leastLikelyWinStreakToday")
    public void setLeastLikelyWinStreakToday(Double leastLikelyWinStreakToday) {
        this.leastLikelyWinStreakToday = leastLikelyWinStreakToday;
    }

    /**
     * 
     * @return
     *     The fiftyMostRecentRounds
     */
    @JsonProperty("fiftyMostRecentRounds")
    public List<FiftyMostRecentRound> getFiftyMostRecentRounds() {
        return fiftyMostRecentRounds;
    }

    /**
     * 
     * @param fiftyMostRecentRounds
     *     The fiftyMostRecentRounds
     */
    @JsonProperty("fiftyMostRecentRounds")
    public void setFiftyMostRecentRounds(List<FiftyMostRecentRound> fiftyMostRecentRounds) {
        this.fiftyMostRecentRounds = fiftyMostRecentRounds;
    }

    /**
     * 
     * @return
     *     The queryTimeInSeconds
     */
    @JsonProperty("queryTimeInSeconds")
    public Double getQueryTimeInSeconds() {
        return queryTimeInSeconds;
    }

    /**
     * 
     * @param queryTimeInSeconds
     *     The queryTimeInSeconds
     */
    @JsonProperty("queryTimeInSeconds")
    public void setQueryTimeInSeconds(Double queryTimeInSeconds) {
        this.queryTimeInSeconds = queryTimeInSeconds;
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
