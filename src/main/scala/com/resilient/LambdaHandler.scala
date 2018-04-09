package com.resilient

import java.io.{InputStream, OutputStream}

import com.amazonaws.services.lambda.runtime.{Context, RequestStreamHandler}
import com.fasterxml.jackson.databind.ObjectMapper
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper

class LambdaHandler extends RequestStreamHandler {

  private val objectMapper = new ObjectMapper()
  private val dynamoDB = AmazonDynamoDBClientBuilder.defaultClient()
  private val dynamoMapper = new DynamoDBMapper(dynamoDB)

  def handleRequest(is: InputStream, os: OutputStream, c: Context): Unit = {
    val callAttrs = objectMapper.readValue(is, classOf[CallAttributes])
    val callRecord = getCallrecord(callAttrs)

    dynamoMapper.save(callRecord)

    os.write(callRecord.toString().getBytes())
  }

  private def getCallrecord(call: CallAttributes): CallRecord = {
    new CallRecord(call.callId, call.timestamp, call.cli, call.withheld)
  }

}
