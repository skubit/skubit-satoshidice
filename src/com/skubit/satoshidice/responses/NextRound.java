
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
    "id",
    "hash",
    "welcomeMessage",
    "maxProfitInSatoshis"
})
public class NextRound {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("hash")
    private String hash;
    @JsonProperty("welcomeMessage")
    private String welcomeMessage;
    @JsonProperty("maxProfitInSatoshis")
    private Integer maxProfitInSatoshis;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
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
     *     The welcomeMessage
     */
    @JsonProperty("welcomeMessage")
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    /**
     * 
     * @param welcomeMessage
     *     The welcomeMessage
     */
    @JsonProperty("welcomeMessage")
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
