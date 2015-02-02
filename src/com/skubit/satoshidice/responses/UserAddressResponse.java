
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
    "depositaddress",
    "queryTimeInSeconds"
})
public class UserAddressResponse {

    @JsonProperty("nick")
    private String nick;
    @JsonProperty("depositaddress")
    private String depositaddress;
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
     *     The depositaddress
     */
    @JsonProperty("depositaddress")
    public String getDepositaddress() {
        return depositaddress;
    }

    /**
     * 
     * @param depositaddress
     *     The depositaddress
     */
    @JsonProperty("depositaddress")
    public void setDepositaddress(String depositaddress) {
        this.depositaddress = depositaddress;
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
