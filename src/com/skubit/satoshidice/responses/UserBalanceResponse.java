
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
    "nick",
    "balanceInSatoshis",
    "unconfirmedBalanceInsSatoshis",
    "hash",
    "maxProfitInSatoshis",
    "queryTimeInSeconds"
})
public class UserBalanceResponse {

    @JsonProperty("nick")
    private String nick;
    @JsonProperty("balanceInSatoshis")
    private Integer balanceInSatoshis;
    @JsonProperty("unconfirmedBalanceInsSatoshis")
    private Integer unconfirmedBalanceInsSatoshis;
    @JsonProperty("hash")
    private String hash;
    @JsonProperty("maxProfitInSatoshis")
    private Integer maxProfitInSatoshis;
    @JsonProperty("queryTimeInSeconds")
    private Double queryTimeInSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The balanceInSatoshis
     */
    @JsonProperty("balanceInSatoshis")
    public Integer getBalanceInSatoshis() {
        return balanceInSatoshis;
    }

    /**
     * 
     * @param balanceInSatoshis
     *     The balanceInSatoshis
     */
    @JsonProperty("balanceInSatoshis")
    public void setBalanceInSatoshis(Integer balanceInSatoshis) {
        this.balanceInSatoshis = balanceInSatoshis;
    }

    /**
     * 
     * @return
     *     The unconfirmedBalanceInsSatoshis
     */
    @JsonProperty("unconfirmedBalanceInsSatoshis")
    public Integer getUnconfirmedBalanceInsSatoshis() {
        return unconfirmedBalanceInsSatoshis;
    }

    /**
     * 
     * @param unconfirmedBalanceInsSatoshis
     *     The unconfirmedBalanceInsSatoshis
     */
    @JsonProperty("unconfirmedBalanceInsSatoshis")
    public void setUnconfirmedBalanceInsSatoshis(Integer unconfirmedBalanceInsSatoshis) {
        this.unconfirmedBalanceInsSatoshis = unconfirmedBalanceInsSatoshis;
    }

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
     *     The maxProfitInSatoshis
     */
    @JsonProperty("maxProfitInSatoshis")
    public Integer getMaxProfitInSatoshis() {
        return maxProfitInSatoshis;
    }

    /**
     * 
     * @param maxProfitInSatoshis
     *     The maxProfitInSatoshis
     */
    @JsonProperty("maxProfitInSatoshis")
    public void setMaxProfitInSatoshis(Integer maxProfitInSatoshis) {
        this.maxProfitInSatoshis = maxProfitInSatoshis;
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
