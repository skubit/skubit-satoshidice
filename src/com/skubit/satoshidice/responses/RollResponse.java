
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
    "serverRoll",
    "serverSalt",
    "serverHash",
    "clientRoll",
    "resultingRoll",
    "created",
    "streakId",
    "bet",
    "queryTimeInSeconds"
})
public class RollResponse {

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
    @JsonProperty("created")
    private String created;
    @JsonProperty("streakId")
    private String streakId;
    @JsonProperty("bet")
    private Bet_ bet;
    @JsonProperty("queryTimeInSeconds")
    private Double queryTimeInSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The created
     */
    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The streakId
     */
    @JsonProperty("streakId")
    public String getStreakId() {
        return streakId;
    }

    /**
     * 
     * @param streakId
     *     The streakId
     */
    @JsonProperty("streakId")
    public void setStreakId(String streakId) {
        this.streakId = streakId;
    }

    /**
     * 
     * @return
     *     The bet
     */
    @JsonProperty("bet")
    public Bet_ getBet() {
        return bet;
    }

    /**
     * 
     * @param bet
     *     The bet
     */
    @JsonProperty("bet")
    public void setBet(Bet_ bet) {
        this.bet = bet;
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
