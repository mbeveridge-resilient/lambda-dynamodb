package com.resilient

import com.amazonaws.services.dynamodbv2.datamodeling.{DynamoDBHashKey, DynamoDBTable}

import scala.annotation.meta.beanGetter
import scala.beans.BeanProperty

@DynamoDBTable(tableName = "callsTable")
case class CallRecord(@(DynamoDBHashKey @beanGetter) @BeanProperty var callId: String,
                      @BeanProperty var timestamp: Long,
                      @BeanProperty var cli: String,
                      @BeanProperty var withheld: Boolean) {

}
