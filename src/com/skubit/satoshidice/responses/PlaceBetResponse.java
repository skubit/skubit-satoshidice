
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
    "newLuck",
    "message",
    "serverRoll",
    "serverSalt",
    "serverHash",
    "clientRoll",
    "resultingRoll",
    "userBalanceInSatoshis",
    "nextRound",
    "status",
    "bet",
    "verbose",
    "queryTimeInSeconds"
})
public class PlaceBetResponse {

    @JsonProperty("newLuck")
    private Double newLuck;
    @JsonProperty("message")
    private String message;
    @JsonProperty("serverRoll")
    private Integer serverRoll;
    @JsonProperty("serverSalt")
    private String serverSalt;
    @JsonProperty("serverHash")
    private String serverHash;
    @JsonProperty("clientRoll")
    private Integer clientRoll;
    @JsonProperty("resultingRoll")
    private Integer resultingRoll;
    @JsonProperty("userBalanceInSatoshis")
    private Long userBalanceInSatoshis;
    @JsonProperty("nextRound")
    private NextRound nextRound;
    @JsonProperty("status")
    private String status;
    @JsonProperty("bet")
    private Bet bet;
    @JsonProperty("verbose")
    private String verbose;
    @JsonProperty("queryTimeInSeconds")
    private Double queryTimeInSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The newLuck
     */
    @JsonProperty("newLuck")
    public Double getNewLuck() {
        return newLuck;
    }

    /**
     * 
     * @param newLuck
     *     The newLuck
     */
    @JsonProperty("newLuck")
    public void setNewLuck(Double newLuck) {
        this.newLuck = newLuck;
    }

    /**
     * 
     * @return
     *     The message
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * @return
     *     The serverRoll
     */
    @JsonProperty("serverRoll")
    public Integer getServerRoll() {
        return serverRoll;
    }

    /**
     * 
     * @param serverRoll
     *     The serverRoll
     */
    @JsonProperty("serverRoll")
    public void setServerRoll(Integer serverRoll) {
        this.serverRoll = serverRoll;
    }

    /**
     * 
     * @return
     *     The serverSalt
     */
    @JsonProperty("serverSalt")
    public String getServerSalt() {
        return serverSalt;
    }

    /**
     * 
     * @param serverSalt
     *     The serverSalt
     */
    @JsonProperty("serverSalt")
    public void setServerSalt(String serverSalt) {
        this.serverSalt = serverSalt;
    }

    /**
     * 
     * @return
     *     The serverHash
     */
    @JsonProperty("serverHash")
    public String getServerHash() {
        return serverHash;
    }

    /**
     * 
     * @param serverHash
     *     The serverHash
     */
    @JsonProperty("serverHash")
    public void setServerHash(String serverHash) {
        this.serverHash = serverHash;
    }

    /**
     * 
     * @return
     *     The clientRoll
     */
    @JsonProperty("clientRoll")
    public Integer getClientRoll() {
        return clientRoll;
    }

    /**
     * 
     * @param clientRoll
     *     The clientRoll
     */
    @JsonProperty("clientRoll")
    public void setClientRoll(Integer clientRoll) {
        this.clientRoll = clientRoll;
    }

    /**
     * 
     * @return
     *     The resultingRoll
     */
    @JsonProperty("resultingRoll")
    public Integer getResultingRoll() {
        return resultingRoll;
    }

    /**
     * 
     * @param resultingRoll
     *     The resultingRoll
     */
    @JsonProperty("resultingRoll")
    public void setResultingRoll(Integer resultingRoll) {
        this.resultingRoll = resultingRoll;
    }

    /**
     * 
     * @return
     *     The userBalanceInSatoshis
     */
    @JsonProperty("userBalanceInSatoshis")
    public Long getUserBalanceInSatoshis() {
        return userBalanceInSatoshis;
    }

    /**
     * 
     * @param userBalanceInSatoshis
     *     The userBalanceInSatoshis
     */
    @JsonProperty("userBalanceInSatoshis")
    public void setUserBalanceInSatoshis(Long userBalanceInSatoshis) {
        this.userBalanceInSatoshis = userBalanceInSatoshis;
    }

    /**
     * 
     * @return
     *     The nextRound
     */
    @JsonProperty("nextRound")
    public NextRound getNextRound() {
        return nextRound;
    }

    /**
     * 
     * @param nextRound
     *     The nextRound
     */
    @JsonProperty("nextRound")
    public void setNextRound(NextRound nextRound) {
        this.nextRound = nextRound;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The bet
     */
    @JsonProperty("bet")
    public Bet getBet() {
        return bet;
    }

    /**
     * 
     * @param bet
     *     The bet
     */
    @JsonProperty("bet")
    public void setBet(Bet bet) {
        this.bet = bet;
    }

    /**
     * 
     * @return
     *     The verbose
     */
    @JsonProperty("verbose")
    public String getVerbose() {
        return verbose;
    }

    /**
     * 
     * @param verbose
     *     The verbose
     */
    @JsonProperty("verbose")
    public void setVerbose(String verbose) {
        this.verbose = verbose;
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
