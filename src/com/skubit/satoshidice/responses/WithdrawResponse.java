
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
    "amountWithdrawn",
    "transactionId",
    "status",
    "message",
    "confirmationsRequired",
    "balance"
})
public class WithdrawResponse {

    @JsonProperty("amountWithdrawn")
    private Double amountWithdrawn;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("confirmationsRequired")
    private Integer confirmationsRequired;
    @JsonProperty("balance")
    private Double balance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The amountWithdrawn
     */
    @JsonProperty("amountWithdrawn")
    public Double getAmountWithdrawn() {
        return amountWithdrawn;
    }

    /**
     * 
     * @param amountWithdrawn
     *     The amountWithdrawn
     */
    @JsonProperty("amountWithdrawn")
    public void setAmountWithdrawn(Double amountWithdrawn) {
        this.amountWithdrawn = amountWithdrawn;
    }

    /**
     * 
     * @return
     *     The transactionId
     */
    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 
     * @param transactionId
     *     The transactionId
     */
    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
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
     *     The confirmationsRequired
     */
    @JsonProperty("confirmationsRequired")
    public Integer getConfirmationsRequired() {
        return confirmationsRequired;
    }

    /**
     * 
     * @param confirmationsRequired
     *     The confirmationsRequired
     */
    @JsonProperty("confirmationsRequired")
    public void setConfirmationsRequired(Integer confirmationsRequired) {
        this.confirmationsRequired = confirmationsRequired;
    }

    /**
     * 
     * @return
     *     The balance
     */
    @JsonProperty("balance")
    public Double getBalance() {
        return balance;
    }

    /**
     * 
     * @param balance
     *     The balance
     */
    @JsonProperty("balance")
    public void setBalance(Double balance) {
        this.balance = balance;
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
