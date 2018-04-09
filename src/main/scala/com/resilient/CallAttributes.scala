package com.resilient

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

@JsonCreator
case class CallAttributes(@JsonProperty("callId") callId: String,
                          @JsonProperty("timestamp") timestamp: Long,
                          @JsonProperty("cli") cli: String,
                          @JsonProperty("withheld") withheld: Boolean) {

}
